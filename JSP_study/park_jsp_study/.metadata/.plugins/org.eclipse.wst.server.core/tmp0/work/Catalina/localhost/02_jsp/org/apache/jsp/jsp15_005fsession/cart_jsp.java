/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.9
 * Generated at: 2019-12-12 03:40:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp15_005fsession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/jsp15_session/menu.jsp", Long.valueOf(1576119414716L));
  }

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
      out.write("\r\n");

request.setCharacterEncoding("utf-8");//post요청 한글처리

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>menu.jsp</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h2>구매CD를 고르세요</h2>\r\n");
      out.write("\r\n");
      out.write("<form method=\"post\">\r\n");
      out.write("<select name=\"item\">\r\n");
      out.write("\t<option value=\"bts\">bts</option>\r\n");
      out.write("\t<option value=\"Justin Bieber\">Justin Bieber</option>\r\n");
      out.write("\t<option value=\"아이유\">아이유</option>\r\n");
      out.write("</select>\r\n");
      out.write("\r\n");
      out.write("<!-- 장바구니에 추가 -->\r\n");
      out.write("\t<input type=\"hidden\" name=\"step\" value=\"add\">\r\n");
      out.write("\t<input type=\"submit\"  value=\"select\">\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');

String item=request.getParameter("item");//menu.jsp,remove.jsp
String step=request.getParameter("step");//menu.jsp,remove.jsp
Vector vec=null;//변수

      out.write("\r\n");
      out.write("\r\n");

if(item != null){//선택한 item이 있으면 
	
	//장바구니 내용을 가져온다
		vec=(Vector)session.getAttribute("cart");
		if(vec==null){//장바구니에 아무것도 없으면, 처음 물건을 선택했을때
			vec=new Vector();//객체생성(장바구니 생성)
			vec.add(item);//장바구니에 item 넣기 
			session.setAttribute("cart", vec);//session에 설정 
			
		}else{ //장바구니에 물건이 들어있을 때
			//이미 선택된 CD가 있을때
			if(step.equals("add")){ 
				//장바구니에 넣는다.
				vec.add(item);//장바구니에 추가( 넣기 )
			}else{
				//장바구니에서 제거한다.
				vec.remove(item);//장바구니에서 item을 제거
			}
		}//else end
		
		out.println("쇼핑 cart에 담긴 cd<br>");

		for(int i=0; i<vec.size(); i++){//장바구니 내용을 뿌려준다
			out.println((i+1)+":"+(vec.get(i).toString())+"<br>");
		}//for
		
      out.write("\r\n");
      out.write("\t\t현재 cart에 모두 ");
      out.print(vec.size() );
      out.write("개 담겨 있습니다<br>\r\n");
      out.write("\t\t");

		
		if(vec.size()>0){//장바구니에 물건이 있을때 
		
      out.write("\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "remove.jsp", out, true);
      out.write("\r\n");
      out.write("\t\t");
	
			
		}//if end
}//if end

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