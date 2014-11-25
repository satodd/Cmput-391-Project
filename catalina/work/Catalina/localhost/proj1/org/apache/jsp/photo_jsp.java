package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class photo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\t\n");
      out.write("\n");
      out.write("\n");

	String username = (String)request.getSession().getAttribute("userName");
	if (username == "failed" || username == "guest" || username == null){
		out.println("<h1><CENTER>Unauthorized access</CENTER></H1>");
	} else {
	//CHECK FOR LOGIN
	//String username = (String)request.getSession().getAttribute("userName");
	//String username = "Test";

		String pid = request.getQueryString();

		Connection conn = null;
	    String driverName = "oracle.jdbc.driver.OracleDriver";
	    String dbstring = "jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
		Class drvClass = Class.forName(driverName); 
		DriverManager.registerDriver((Driver)
	    drvClass.newInstance());

	    conn = DriverManager.getConnection(dbstring,"satodd","Edmonton01");
		conn.setAutoCommit(false);
		

		String sql = "SELECT * FROM images WHERE photo_id ='" + pid + "'";

		Statement stmt = null;
		ResultSet rset = null;

		try{
	        stmt = conn.createStatement();
	        rset = stmt.executeQuery(sql);
	    }

	    catch(Exception ex){
	        out.println("<hr>" + ex.getMessage() + "<hr>");
	    }

	    if (rset == null || !rset.next()) return;

	    String owner = rset.getString(2);
	    int permitted = rset.getInt(3);
	    String subject = rset.getString(4);
	    String place = rset.getString(5);
	    String desc = rset.getString(7);

	    String isOwner;
		//check if user is owner
	    if (username.equals(owner)){
	    	isOwner = "true";
		} else {isOwner = "false";}

		boolean isInGroup;
	    //sql = "SELECT group_id, group_name FROM groups WHERE user_name='" + username + "'";
	    sql = "Select groups.group_id, groups.group_name from groups, group_lists Where groups.group_id = group_lists.group_id AND group_lists.friend_id ='"+ username + "'";

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
      out.write("<HTML>\n");
      out.write("<HEAD>\n");
      out.write("\n");
      out.write("\n");
      out.write("<TITLE>Image</TITLE>\n");
      out.write("</HEAD>\n");
      out.write("<BODY>\n");
      out.write("\n");
      out.write("<title>Image</title> \n");
      out.write("<header>\n");
      out.write("<h1>\n");
      out.write("<center>\n");
      out.write("Hello ");
      out.print(username);
      out.write(" - Image \n");
      out.write("</center>\n");
      out.write("</h1>\n");
      out.write("</header>\n");
      out.write("<hr>\n");
      out.write("\n");
      out.write("<table>\n");
      out.write("  <tr>\n");
      out.write("    <td><img src=\"image?");
      out.print(pid);
      out.write("\"/></td>\n");
      out.write("  </tr>\n");
 if(isOwner == "true") { 
      out.write("\n");
      out.write("\t<CENTER>\n");
      out.write("\t\t<FORM NAME=\"Back\" ACTION=\"main.jsp\" METHOD=\"post\" ><CENTER>\n");
      out.write("\t\t<FORM NAME=\"UpdateForum\" ACTION=\"updated.jsp\" METHOD=\"post\" ><CENTER>\n");
      out.write("\t\t<TABLE>\n");
      out.write("\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t<TD><B><I>ID Number:</I></B></TD>\n");
      out.write("\t\t\t\t<TD><INPUT TYPE=\"text\" NAME=\"imgid\" value=\"");
      out.print(pid);
      out.write("\" READONLY><BR></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t<TD><B><I>Place:</I></B></TD>\n");
      out.write("\t\t\t\t<TD><INPUT TYPE=\"text\" NAME=\"place\" value=\"");
      out.print(place);
      out.write("\"><BR></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t<TD><B><I>Date:</I></B></TD>\n");
      out.write("\t\t\t\t<TD><INPUT TYPE=\"date\" NAME=\"timing\"></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t<TD><B><I>Subject:</I></B></TD>\n");
      out.write("\t\t\t\t<TD><INPUT TYPE=\"text\" NAME=\"subject\" value=\"");
      out.print(subject);
      out.write("\"></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t<TD><B><I>Description:</I></B></TD>\n");
      out.write("\t\t\t\t<TD><TEXTAREA style=\"resize:none;\" NAME=\"desc\" value=\"");
      out.print(desc);
      out.write("\"></TEXTAREA></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\n");
      out.write("\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
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
      out.write("\t\t</TABLE>\n");
      out.write("\t</CENTER>\n");
      out.write("    <INPUT TYPE=\"submit\" NAME=\"OK\" VALUE=\"OK\">\n");
      out.write("    <INPUT TYPE=\"submit\" NAME=\"main\" VALUE=\"Main\">\n");
      out.write("\t\n");
} else { 
      out.write("\n");
      out.write("\n");
      out.write("\t<CENTER>\n");
      out.write("\t\t<TABLE>\n");
      out.write("\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t<TD><B><I>Place:</I></B></TD>\n");
      out.write("\t\t\t\t<TD><NAME=\"place\" value=\"");
      out.print(place);
      out.write("\"><BR></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t<TD><B><I>Date:</I></B></TD>\n");
      out.write("\t\t\t\t<TD><NAME=\"timing\"></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t<TD><B><I>Subject:</I></B></TD>\n");
      out.write("\t\t\t\t<TD><NAME=\"subject\" value=\"");
      out.print(subject);
      out.write("\"></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t<TR VALIGN=TOP ALIGN=CENTER>\n");
      out.write("\t\t\t\t<TD><B><I>Description:</I></B></TD>\n");
      out.write("\t\t\t\t<TD><NAME=\"desc\" value=\"");
      out.print(desc);
      out.write("\"></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t</TABLE>\n");
      out.write("\t</CENTER>\n");
 } 
      out.write("\n");
      out.write("\t</body>\n");
      out.write("</HTML>\n");
}
      out.write('\n');
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
