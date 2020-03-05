package org.zerock.member.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.login.NaverLoginBO;
import org.zerock.member.dto.UsersDTO;
import org.zerock.member.service.MemberService;
import org.zerock.member.service.SignupService;

@Controller
@RequestMapping("/member")
public class MemberController {

	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	@Inject
	private SignupService signupService;
	@Inject
	private MemberService service;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	// 멤버리스트
	@GetMapping("/list.do")
	public String mList(Model model) {
		model.addAttribute("list", service.list());
		return "member/list";
	}

	// 회원관리
	@GetMapping("/manage.do")
	public String mManageForm(Model model) {
		model.addAttribute("list", service.list());
		return "member/manage";
	}

	// 회원관리: 여러 회원 한꺼번에 수정(id, 상태, 등급 각각 배열로 받아와서(수정안되어도 name="", value=""로 한꺼번에
	// 받아온다.) for문 돌려 한명씩 dto에 저장)
	@PostMapping("/manage.do")
	public String mManage(HttpServletRequest req) {

		String[] id = req.getParameterValues("id");
		String[] state = req.getParameterValues("state");
		String[] gradeNo = req.getParameterValues("gradeNo");

		// dto에 담기
		UsersDTO udto = new UsersDTO();
		for (int i = 0; i < id.length; i++) {
			udto.setId(Integer.parseInt(id[i]));
			udto.setState(Integer.parseInt(state[i]));
			udto.setGradeNo(Integer.parseInt(gradeNo[i]));
			System.out.println("MemberController.mManage().udto : " + udto);

			// 서비스로 보내기 : for문 한번 돌때마다 한명의 정보가 service-mapper-db에 저장됨
			service.mManage(udto);
		}
		return "redirect:list.do";
	}

	// 권한처리
	@GetMapping("/noAuth.do")
	public String noAuth() {
		return "error/noauth";
	}
}
