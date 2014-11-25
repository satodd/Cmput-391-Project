package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registerScreen_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<HTML>\n");
      out.write("\t<head>\n");
      out.write("\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("\t<body>\n");
      out.write("\t\t<h1><center>User Registration</center></h1>\n");
      out.write("\t\t<p><center>Please provide your information</center></p>\n");
      out.write("\t\t<!-- -providing some required information, including a unique user name, password, first name, last name, address, email, and phone number -->\n");
      out.write("\t\t<FORM NAME=\"RegistrationForm\" ACTION=\"register.jsp\" METHOD=\"post\" ><CENTER>\n");
      out.write("\t\t\t<TABLE>\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t\t<TD><B><I>Userid:</I></B></TD>\n");
      out.write("\t\t\t\t\t<TD><INPUT TYPE=\"text\" NAME=\"USERID\" placeholder=\"userid\" required><BR></TD>\n");
      out.write("\t\t\t\t</TR>\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t\t<TD><B><I>Password:</I></B></TD>\n");
      out.write("\t\t\t\t\t<TD><INPUT TYPE=\"password\" NAME=\"PASSWD\" placeholder=\"password\" required></TD>\n");
      out.write("\t\t\t\t</TR>\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t\t<TD><B><I>First Name:</I></B></TD>\n");
      out.write("\t\t\t\t\t<TD><INPUT TYPE=\"text\" NAME=\"FNAME\" placeholder=\"first name\" required></TD>\n");
      out.write("\t\t\t\t</TR>\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t\t<TD><B><I>Last Name:</I></B></TD>\n");
      out.write("\t\t\t\t\t<TD><INPUT TYPE=\"text\" NAME=\"LNAME\" placeholder=\"last name\" required></TD>\n");
      out.write("\t\t\t\t</TR>\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t\t<TD><B><I>Address:</I></B></TD>\n");
      out.write("\t\t\t\t\t<TD><INPUT TYPE=\"text\" NAME=\"ADDR\" placeholder=\"address\" required></TD>\n");
      out.write("\t\t\t\t</TR>\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t\t<TD><B><I>Email:</I></B></TD>\n");
      out.write("\t\t\t\t\t<TD><INPUT TYPE=\"text\" NAME=\"EMAIL\" placeholder=\"email\" required></TD>\n");
      out.write("\t\t\t\t</TR>\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t\t<TD><B><I>Phone Number:</I></B></TD>\n");
      out.write("\t\t\t\t\t<TD><INPUT TYPE=\"text\" NAME=\"PHNO\" placeholder=\"phone #\" required></TD>\n");
      out.write("\t\t\t\t</TR>\n");
      out.write("\t\t\t</TABLE>\n");
      out.write("\t\t\t<INPUT TYPE=\"submit\" NAME=\"CREATE\" VALUE=\"Create\">\n");
      out.write("\t\t</CENTER></FORM>\n");
      out.write("\n");
      out.write("\t</body>\n");
      out.write("</HTML>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
