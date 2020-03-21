package org.zerock.member.controller;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.login.NaverLoginBO;
import org.zerock.member.dto.UsersDTO;
import org.zerock.member.service.MemberService;
import org.zerock.member.service.SignupService;

import com.github.scribejava.core.model.OAuth2AccessToken;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	@Inject
	private SignupService signupService;
	@Inject // 의존성주입을 하지 않고 서비스 실행시 : return값이 null일 경우 nullpointexception오류난다.
	private MemberService mService;
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired //이방법의 의존성주입이 더 추천됨
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	
	// 회원가입 ------------------------------------------------
	@GetMapping("/login/signup.do")
	public String signup() {
		return "login/signup";
	}

	// 일반 로그인 : 세션에 저장해야된다.------------------------------------------------
	@PostMapping("/login/normallogin.do")
	public String normalLogin(UsersDTO udto, Model model, HttpSession session) {

		System.out.println("loginController.normallogin().udto:" + udto);// 뷰에서받은 userName, pw
	
		if (signupService.selectNormalUser(udto) == null) { // userName, pw가 일치하는 db가 없으면 로그인 안됨 에러
			model.addAttribute("msg", "Please enter correct username or password.");
			return "login/login";
		} else { //로그인성공시
			// -------------------------------------------------
			// 사용자 정보 세션에 저장 ★★★
			// -------------------------------------------------------
			udto = signupService.selectNormalUser(udto);
			session.setAttribute("login", udto); //이렇게 key, value로 세션에 저장해놓으면 뷰에서 ${login.nickname}등으로 갖다 쓴다.
			System.out.println("session.getAttribute(\"login\"): "+session.getAttribute("login"));
			
			//AuthInterceptor
			String uri = (String) session.getAttribute("uri");
			session.removeAttribute("uri");
			return (uri == null)? "login/loginSuccess" : "redirect:"+uri;
		}
	}

	// 네이버로 로그인 첫 화면 요청 메소드-------------------------------
	@RequestMapping(value = "/login/login.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {

		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);

		// https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		// redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);

		// 네이버
		model.addAttribute("url", naverAuthUrl);

		/* 생성한 인증 URL을 View로 전달 */
		return "login/login";
	}

	// 네이버 로그인 성공시 callback호출 메소드--------------------------------
	@RequestMapping(value = "/login/callback.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException, ParseException {
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);

		// 1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken); // String형식의 json데이터

		// 2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;

		System.out.println(jsonObj);

		// 3. 데이터 파싱
		// Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject) jsonObj.get("response");
		// response의 nickname값 파싱
		String nickname = (String) response_obj.get("nickname");
		String email = (String) response_obj.get("email");
		String sns_id = (String) response_obj.get("id");
		String sns_profile = (String) response_obj.get("profile_image");

		// 로그인한 사용자 정보 dto에 담기 -> 사용자의 이메일이 db에 없으면 db에 저장하기
		UsersDTO udto = new UsersDTO();
		udto.setSns_id(sns_id);
		udto.setNickName(nickname);
		udto.setEmail(email);
		udto.setSns_profile(sns_profile);
		int result = signupService.insertNaverUser(udto);

		// db에 저장됐으면 1, 아니면 0 출력
		System.out.println("=============================================");
		System.out.println("loginController:db에 insert성공여부:" + result);
		System.out.println("=============================================");

		// -------------------------------------------------
		// 사용자 정보 세션에 저장 (나중에 grade별 권한 처리할때도 필요함, navbar에 환영합니다xxx님.등 회원 관련 정보 처리하려면.)
		// -------------------------------------------------------
		udto = signupService.selectNaverUser(udto); // sns_id일치하는 사용자의 데이터 가져오기
		System.out.println("LoginController.callback().userDTO: " + udto);
		session.setAttribute("login", udto);
		model.addAttribute("result", apiResult);
		
		//AuthInterceptor
		String uri = (String) session.getAttribute("uri");
		session.removeAttribute("uri");
		return (uri == null)? "login/loginSuccess":
			"redirect:"+uri;
	}

	// 로그아웃-----------------------------------------------------
	@GetMapping("/login/signout.do")
	public void signOut(HttpSession session, HttpServletRequest req, HttpServletResponse res) throws IOException {
		session.invalidate();

		// 정보기술에서 헤더(header)는 저장되거나 전송되는 데이터 블록의 맨앞에 위치한 보충 데이터를 가리킨다.
		// Referer 헤더는 사람들이 어디로부터 와서 방문 중인지를 인식할 수 있도록 해주며 해당 데이터는 예를 들어, 분석, 로깅, 혹은 캐싱
		// 최적화에 사용
		String uri = req.getHeader("REFERER"); // 로그아웃버튼 클릭 전 uri 얻어오기
		System.out.println("loginCongroller.signOut().uri:" + uri);

		if (uri.indexOf("callback.do") == -1) { // 로그인성공해서 콜백된 페이지에서 바로 로그아웃하면 response가 비어서 nullpointexception. -> 이경우
												// 바로 메인페이지로 보내기. 그게 아니면 로그아웃버튼 클릭하기 바로 전 페이지로 보내기
			res.sendRedirect(uri);
		} else {
			res.sendRedirect("/main/main.do");
		}
	}

}
