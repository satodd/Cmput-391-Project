package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class infoUpload_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
      out.write('\n');

  String username = (String)request.getSession().getAttribute("userName");
  Integer pic_id = (Integer)request.getSession().getAttribute("pic_id");
  if (username == "failed" || username == "guest" || username == null){
    out.println("<h1><CENTER>Unauthorized access</CENTER></H1>");
  }
else{;

    String place = null;
    String timing = null;
    String subject = null;;
    String desc = null;
    String permitted = null;




      out.write("\n");
      out.write("<HEAD>\n");
      out.write("<TITLE>Upload</TITLE>\n");
      out.write("</HEAD>\n");
      out.write("<BODY>\n");
      out.write("\n");
      out.write("<title>Upload image</title> \n");
      out.write("<header>\n");
      out.write("<h1>\n");
      out.write("<center>\n");
      out.write("Image Upload\n");
      out.write("</center>\n");
      out.write("</h1>\n");
      out.write("</header>\n");
      out.write("<hr>\n");
      out.write("Please info for the image! \n");
      out.write("<form name=\"upload\" method=\"POST\" action=\"uploadall.jsp\">\n");
      out.write("<table>\n");
      out.write("<!-- -providing some required information, including a unique user name, password, first name, last name, address, email, and phone number -->\n");
      out.write("\t\t<CENTER>\n");
      out.write("      <TABLE>\n");
      out.write("        <TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("          <TD><B><I>Place:</I></B></TD>\n");
      out.write("          <TD><INPUT TYPE=\"text\" NAME=\"place\" value= ");
 out.println(place); 
      out.write(" ><BR></TD>\n");
      out.write("        </TR>\n");
      out.write("        <TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("          <TD><B><I>Date:</I></B></TD>\n");
      out.write("          <TD><INPUT TYPE=\"date\" NAME=\"timing\" value= ");
 out.println(timing); 
      out.write("></TD>\n");
      out.write("        </TR>\n");
      out.write("        <TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("          <TD><B><I>Subject:</I></B></TD>\n");
      out.write("          <TD><INPUT TYPE=\"text\" NAME=\"subject\" value= ");
 out.println(subject); 
      out.write("></TD>\n");
      out.write("        </TR>\n");
      out.write("        <TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("          <TD><B><I>Description:</I></B></TD>\n");
      out.write("          <TD><input type=\"text\" NAME=\"desc\" value= ");
 out.println(desc); 
      out.write("></TEXTAREA></TD>\n");
      out.write("        </TR>\n");
      out.write("        <!--<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("        <TD><B><I>photoid</I></B></TD>\n");
      out.write("          <TD><input type=\"text\" NAME=\"photoid\" value=\"");
out.println(pic_id);
      out.write("\" READONLY></TD>\n");
      out.write("        </TR>-->\n");
      out.write("        <TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("        <TD><B><I>Access:</I></B></TD>\n");
      out.write("          <TD><input type=\"text\" NAME=\"permit\" value = ");
 out.println(permitted); 
      out.write("></TD>\n");
      out.write("        </TR>\n");
      out.write("      </TABLE>\n");
      out.write("    </CENTER>\n");
      out.write("\n");
      out.write("\t <tr>\n");
      out.write("    <td ALIGN=CENTER COLSPAN=\"2\"><input type=\"submit\" name=\".submit\" \n");
      out.write("     value=\"Info\"></td>\n");
      out.write("  \t</tr>\n");
      out.write("</form>\n");
      out.write("\t</body>\n");
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
