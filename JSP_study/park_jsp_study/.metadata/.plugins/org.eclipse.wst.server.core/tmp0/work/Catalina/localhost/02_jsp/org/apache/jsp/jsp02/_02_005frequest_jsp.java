/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.9
 * Generated at: 2019-12-10 01:15:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp02;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _02_005frequest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>02_request.jsp</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h2>미니's 홈</h2>\r\n");
      out.write("\r\n");

String ip = request.getRemoteAddr();
if(ip.equals("192.168.1.00")){
	out.println("이 ip로는 접속할 수 없습니다.");
	return;
}
// 위의 IP로 이 페이지에 접속하는것을 차단시킴

      out.write("\r\n");
      out.write("\r\n");
      out.write("<li> 메서드 방식: ");
      out.print( request.getMethod() );
      out.write("\r\n");
      out.write("<li> 요청 URI: ");
      out.print( request.getRequestURI() );
      out.write("\r\n");
      out.write("<li> 요청 URL: ");
      out.print( request.getRequestURL() );
      out.write("\r\n");
      out.write("<p>\r\n");
      out.write("<li> 프로토콜 : ");
      out.print(request.getProtocol() );
      out.write("\r\n");
      out.write("<li> 서버이름 : ");
      out.print(request.getServerName() );
      out.write(" \r\n");
      out.write("<li> 서버포트번호 : ");
      out.print(request.getServerPort() );
      out.write("\r\n");
      out.write("<p>\r\n");
      out.write("<li> 사용자 컴퓨터 주소: ");
      out.print(request.getRemoteAddr() );
      out.write("\r\n");
      out.write("<li> 사용자 컴퓨터 이름: ");
      out.print(request.getRemoteHost() );
      out.write("\r\n");
      out.write("<p>\r\n");
      out.write("<li> 현재 사용중인 웹 브라우저 : \r\n");
      out.print(request.getHeader("User-Agent") );
      out.write("\r\n");
      out.write("\r\n");
      out.write("<li> 브라우저를 지원하는 file의 type : text/html\r\n");
      out.print(request.getHeader("Accept") );
      out.write("\r\n");
      out.write("\r\n");
      out.write("<li> 이전 url 알아내기: \r\n");
      out.print(request.getHeader("referer") );
      out.write("\r\n");
      out.write("\r\n");



      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
