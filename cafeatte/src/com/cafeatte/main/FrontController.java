package com.cafeatte.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafeatte.bean.Beans;
import com.cafeatte.util.io.ViewResolver;

/**
 * Servlet implementation class FrontController
 */
// url 패턴은 web.xml에 설정
//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private Controller mainController = Beans.getController("mainController");
	private Controller noticeController = Beans.getController("noticeController");
	private Controller magazineController = Beans.getController("magazineController");
	private Controller qnaController = Beans.getController("qnaController");
	private Controller memberController = Beans.getController("memberController");
	private Controller cafeController = Beans.getController("cafeController");
	private Controller userCafeController = Beans.getController("userCafeController");
	private Controller ajaxController = Beans.getController("ajaxController");
	private Controller couponController = Beans.getController("couponController");
	private Controller errorController = Beans.getController("errorController");

	
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String jsp = "";
		try {
			String uri = request.getServletPath();
			System.out.println(uri);
			if(uri.indexOf("/member") == 0) {
				jsp = memberController.execute(request, response, uri);
			} else if (uri.indexOf("/notice") == 0){
				System.out.println("noticeController 처리");
				jsp = noticeController.execute(request, response, uri);
			
			} else if (uri.indexOf("/magazine") == 0){
				System.out.println("magazine 처리");
				jsp = magazineController.execute(request, response, uri);
			
			} else if (uri.indexOf("/userCafe") == 0) {
				System.out.println("userCafe 처리");
				jsp = userCafeController.execute(request, response, uri);
			
			} else if (uri.indexOf("/cafe") == 0) {
				System.out.println("cafe 처리");
				jsp = cafeController.execute(request, response, uri);
			
			} else if (uri.indexOf("/qna") == 0) {
				System.out.println("qna처리");
				jsp = qnaController.execute(request, response, uri);
			
			} else if (uri.indexOf("/coupon") == 0) {
				jsp = couponController.execute(request, response, uri);
			
			} else if (uri.indexOf("/ajax") == 0) {
				jsp = ajaxController.execute(request, response, uri);
				return;
			} else if(uri.indexOf("/error") == 0) {
				jsp = errorController.execute(request, response, uri);
			} else if(uri.indexOf("/main") == 0) {
				jsp = mainController.execute(request, response, uri);
			}
			
			ViewResolver.forward(request, response, jsp);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
