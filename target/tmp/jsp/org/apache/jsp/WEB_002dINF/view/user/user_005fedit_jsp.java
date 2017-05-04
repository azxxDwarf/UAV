package org.apache.jsp.WEB_002dINF.view.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class user_005fedit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Edit User</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form id=\"userForm\" action=\"updateConfirm.do\" method=\"post\">\r\n");
      out.write("\t\tid:<input type=\"text\" name=\"id\" id=\"user_id\"/>\r\n");
      out.write("\t\tusername:<input type=\"text\" name=\"username\" id=\"username\" />\r\n");
      out.write("\t\tpassword:<input type=\"password\" name=\"password\" />\r\n");
      out.write("\t\tname:<input type=\"text\" name=\"name\" />\r\n");
      out.write("\t\t<a onclick=\"confirm();\"><input type=\"button\" value=\"Confirm\" /></a>\r\n");
      out.write("\t\t<!-- <input type=\"submit\" value=\"Confirm\" /> -->\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"../static/jquery-1.7.2.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction confirm() {\r\n");
      out.write("\t\t//alert(\"Inside the func!\");\r\n");
      out.write("\t\t/* if ($(\"#user_id\").val() == \"\") {\r\n");
      out.write("\t\t\talert(\"ID is null\");\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\talert(\"ID is not null\");\r\n");
      out.write("\t\t} */\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\thasUser();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction hasUser() {\r\n");
      out.write("\t\t//alert(\"The 2nd func!\");\r\n");
      out.write("\t\tvar username = $.trim($(\"#username\").val());\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype: \"POST\",\r\n");
      out.write("\t\t\turl: '");
      out.print(basePath);
      out.write("user/hasU.do',\r\n");
      out.write("\t\t\tdata: {username:username},\r\n");
      out.write("\t\t\tdataType: 'json',\r\n");
      out.write("\t\t\tsuccess: function(data) {\r\n");
      out.write("\t\t\t\tif (data == null)\r\n");
      out.write("\t\t\t\t\talert(\"data is null!\")\r\n");
      out.write("\t\t\t\talert(data);\r\n");
      out.write("\t\t\t\tif (\"success\" == data.result) {\r\n");
      out.write("\t\t\t\t\talert(\"success!\");\r\n");
      out.write("\t\t\t\t\t$(\"#userForm\").submit();\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\talert(\"Username already exists, opr's failed!\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
