package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class upload_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	//CHECK FOR LOGIN

	//String username = (String)request.getSession().getAttribute("userName");
	String username = "Test2";

	Connection conn = null;
    String driverName = "oracle.jdbc.driver.OracleDriver";
    String dbstring = "jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
	Class drvClass = Class.forName(driverName); 
	DriverManager.registerDriver((Driver)
    drvClass.newInstance());

    conn = DriverManager.getConnection(dbstring,"satodd","Edmonton01");
	conn.setAutoCommit(false);

	Statement stmt = null;
	ResultSet rset = null;
 	
    String sql = "SELECT group_id, group_name FROM groups WHERE user_name='" + username + "'";

    try{
        stmt = conn.createStatement();
        rset = stmt.executeQuery(sql);
    }

    catch(Exception ex){
        out.println("<hr>" + ex.getMessage() + "<hr>");
    }

    ArrayList<Integer> group_ids = new ArrayList<Integer>();
    ArrayList<String> group_names = new ArrayList<String>();

    if (rset == null) return;

    while(rset.next()) {
    	group_ids.add(rset.getInt(1));
    	group_names.add(rset.getString(2));
	}


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<HTML>\n");
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
      out.write("Please input or select the path of the image!\n");
      out.write("<form name=\"upload-image\" method=\"POST\" enctype=\"multipart/form-data\" action=\"upload\">\n");
      out.write("\n");
      out.write("<table>\n");
      out.write("  <tr>\n");
      out.write("    <th>File path: </th>\n");
      out.write("    <td><input name=\"file-path\" type=\"file\" size=\"30\" ></input></td>\n");
      out.write("  </tr>\n");
      out.write("\n");
      out.write("<!-- -providing some required information, including a unique user name, password, first name, last name, address, email, and phone number -->\n");
      out.write("\t\t<CENTER>\n");
      out.write("\t\t\t<TABLE>\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t\t<TD><B><I>Place:</I></B></TD>\n");
      out.write("\t\t\t\t\t<TD><INPUT TYPE=\"text\" NAME=\"place\"><BR></TD>\n");
      out.write("\t\t\t\t</TR>\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t\t<TD><B><I>Date:</I></B></TD>\n");
      out.write("\t\t\t\t\t<TD><INPUT TYPE=\"date\" NAME=\"timing\"></TD>\n");
      out.write("\t\t\t\t</TR>\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t\t<TD><B><I>Subject:</I></B></TD>\n");
      out.write("\t\t\t\t\t<TD><INPUT TYPE=\"text\" NAME=\"subject\"></TD>\n");
      out.write("\t\t\t\t</TR>\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t\t<TD><B><I>Description:</I></B></TD>\n");
      out.write("\t\t\t\t\t<TD><TEXTAREA style=\"resize:none;\" NAME=\"desc\"></TEXTAREA></TD>\n");
      out.write("\t\t\t\t</TR>\n");
      out.write("\n");
      out.write("\t\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t<TD><B><I>Access:</I></B></TD>\n");
      out.write("\t\t\t\t<TD>\n");
      out.write("\t\t\t\t\t<select name=\"permitted\">\n");
      out.write("\t\t\t\t\t\t<option value=\"2\">Private</option>\n");
      out.write("\t\t\t\t    \t<option value=\"1\">Public</option>\n");
      out.write("\t\t\t\t    \t");
 for (int i = 0; i < group_names.size(); i++) { 
      out.write("\n");
      out.write("\t\t\t\t    \t\t<option value=\"");
      out.print(group_ids.get(i));
      out.write('"');
      out.write('>');
      out.print(group_names.get(i));
      out.write("</option>\n");
      out.write("\t\t\t\t    \t");
 } 
      out.write("\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t</TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t</TABLE>\n");
      out.write("\t\t</CENTER>\n");
      out.write("\n");
      out.write("\t  <tr>\n");
      out.write("    <td ALIGN=CENTER COLSPAN=\"2\"><input type=\"submit\" name=\".submit\" \n");
      out.write("     value=\"Upload\"></td>\n");
      out.write("  </tr>\n");
      out.write("\n");
      out.write("\t</body>\n");
      out.write("</HTML>\n");
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
