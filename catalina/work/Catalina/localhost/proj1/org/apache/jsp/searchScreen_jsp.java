package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class searchScreen_jsp extends org.apache.jasper.runtime.HttpJspBase
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


	String username = (String)request.getSession().getAttribute("userName");
	String query = (String)request.getSession().getAttribute("imageView");
	if (username == "failed" || username == "guest" || username == null){
		out.println("<h1><CENTER>Unauthorized access</CENTER></H1>");
	}

else {

      out.write("\n");
      out.write("\n");
      out.write("<HTML>\n");
      out.write("\t<HEAD>\n");
      out.write("\t\t<TITLE>Search Page</TITLE>\n");
      out.write("\t</HEAD>\n");
      out.write("\n");
      out.write("\t<BODY>\n");
      out.write("\t<!--This is the login page-->\n");
      out.write("\t\t<H1><CENTER>Searching module</CENTER></H1>\n");
      out.write("\n");
      out.write("\t\t<FORM NAME=\"SearchForm\" ACTION=\"search.jsp\" METHOD=\"post\" ><CENTER>\n");
      out.write("\n");
      out.write("\t\t\t<P><CENTER>Please enter search terms below</CENTER></P>\n");
      out.write("\t\t\t<TABLE>\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=LEFT>\n");
      out.write("\t\t\t\t<select name=\"Ordering\">\n");
      out.write("\t\t\t\t\t<option value=\"null\">------------</option>\n");
      out.write("\t\t\t\t\t<option value=\"FTL\">Most to least recent</option>\n");
      out.write("\t\t\t\t\t<option value=\"LTF\">Least to most recent</option>\n");
      out.write("\t\t\t\t</TR>\n");
      out.write("\t\t\t\t</select>\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t\t<TD><B><I>Key Words:</I></B></TD>\n");
      out.write("\t\t\t\t\t<TD><INPUT TYPE=\"text\" NAME=\"KEYWORDS\"  PLACEHOLDER=\"keywords\"><BR></TD>\n");
      out.write("\t\t\t\t</TR>\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t\t<TD><B><I>From:</I></B></TD>\n");
      out.write("\t\t\t\t\t<TD><input type=\"date\" name=\"FROM\"><BR></TD>\n");
      out.write("\t\t\t\t</TR>\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t\t<TD><B><I>To:</I></B></TD>\n");
      out.write("\t\t\t\t\t<TD> <input type=\"date\" name=\"TO\"><BR></TD>\n");
      out.write("\t\t\t\t</TR>\n");
      out.write("\t\t\t</TABLE>\n");
      out.write("\n");
      out.write("\t\t\t<INPUT TYPE=\"submit\" NAME=\"SEARCH\" VALUE=\"SEARCH\">\n");
      out.write("\t\t</CENTER></FORM>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t</BODY>\n");
      out.write("</HTML>\n");
}
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
