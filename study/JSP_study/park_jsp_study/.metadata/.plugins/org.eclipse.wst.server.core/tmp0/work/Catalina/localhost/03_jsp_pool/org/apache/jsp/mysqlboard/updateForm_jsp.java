/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.9
 * Generated at: 2019-12-18 03:57:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.mysqlboard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import boardmysql.BoardDTO;
import boardmysql.BoardDAO;

public final class updateForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/view/color.jsp", Long.valueOf(1576547023352L));
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
      out.write("\r\n");
      out.write("    ");
 
 String bodyback_c="#e0ffff";
 String back_c="#8fbc8f";
 String title_c="#5f9ea0";
 String value_c="#b0e0e6";
 String bar="#778899";

      out.write('\r');
      out.write('\n');
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("\r\n");

request.setCharacterEncoding("utf-8");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write(" ");

  int num=Integer.parseInt(request.getParameter("num"));
  String pageNum=request.getParameter("pageNum");
  
  BoardDAO dao=BoardDAO.getDao();//dao객체 얻기 
  BoardDTO dto=dao.updateGetArticle(num);
  
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<h2><center>글수정</center></h2>\r\n");
      out.write("<form name=\"writeForm\" method=\"post\" action=\"updatePro.jsp?pageNum=");
      out.print(pageNum );
      out.write("\">\r\n");
      out.write("\t<table width=\"60%\" cellpadding=\"5\"  align=\"center\">\r\n");
      out.write("\t\t<tr bgclor=");
      out.print(value_c );
      out.write(">\r\n");
      out.write("\t\t\t<td align=\"right\"  width=\"70\"\t>이름</td>\r\n");
      out.write("\t\t\t<td width=\"330\"\t>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"writer\" id=\"writer\" size=\"16\" value=");
      out.print(dto.getWriter() );
      out.write(">\r\n");
      out.write("\t\t</td>\t\t\r\n");
      out.write("\t\t       <tr bgcolor=\"");
      out.print(value_c);
      out.write("\">\r\n");
      out.write("         <td width=\"70\" align=\"center\">글제목</td>\r\n");
      out.write("         <td width=\"330\">\r\n");
      out.write("           <input type=\"text\" name=\"subject\" id=\"subject\" size=\"16\" value=\"");
      out.print(dto.getSubject());
      out.write("\">\r\n");
      out.write("          </td>\r\n");
      out.write("       </tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t       <tr bgcolor=\"");
      out.print(value_c);
      out.write("\">\r\n");
      out.write("         <td width=\"70\" align=\"center\">이메일</td>\r\n");
      out.write("         <td width=\"330\">\r\n");
      out.write("           <input type=\"text\" name=\"email\" id=\"email\" size=\"16\" value=\"");
      out.print(dto.getEmail());
      out.write("\">\r\n");
      out.write("          </td>\r\n");
      out.write("       </tr>\r\n");
      out.write("\t\r\n");
      out.write("\t       <tr bgcolor=\"");
      out.print(value_c);
      out.write("\">\r\n");
      out.write("         <td width=\"70\" align=\"center\">글내용</td>\r\n");
      out.write("         <td width=\"330\">\r\n");
      out.write("\t\t\t<textarea rows=\"10\" cols=\"50\" name=\"content\" id=\"content\">");
      out.print(dto.getContent() );
      out.write("</textarea>\r\n");
      out.write("          </td>\r\n");
      out.write("       </tr>\r\n");
      out.write("\r\n");
      out.write("       <tr bgcolor=\"");
      out.print(value_c);
      out.write("\">\r\n");
      out.write("         <td width=\"70\" align=\"center\">암호</td>\r\n");
      out.write("         <td width=\"330\">\r\n");
      out.write("           <input type=\"password\" name=\"passwd\" id=\"passwd\" size=\"16\" >\r\n");
      out.write("          </td>\r\n");
      out.write("       </tr>\r\n");
      out.write("       \r\n");
      out.write("       <tr height=\"30\">\r\n");
      out.write("       <td colspan=\"4\" bgcolor=\"");
      out.print(value_c);
      out.write("\" align=\"right\">\r\n");
      out.write("       <input type=\"submit\" value=\"글수정\" >\r\n");
      out.write("       <input type=\"reset\" value=\"취소\" >\r\n");
      out.write("       <input type=\"button\" value=\"글목록보기\" onClick=\"document.location.href='list.jsp?pageNum=");
      out.print(pageNum);
      out.write("'\">\r\n");
      out.write("       </td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     </form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
