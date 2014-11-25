package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  if (username == "failed" || username == "guest" || username == null){
    out.println("<h1><CENTER>Unauthorized access</CENTER></H1>");
  }
else{

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
  String sql;

  if(!username.equals("admin")){
    sql = "SELECT group_id, group_name FROM groups WHERE user_name='" + username + "'";
  }
  else{
    sql = "SELECT group_id, group_name FROM groups";
  }
    try{
        stmt = conn.createStatement();
        rset = stmt.executeQuery(sql);
    }
    catch(Exception ex){
        out.println("<hr>" + ex.getMessage() + "<hr>");
    }
    ArrayList<Integer> group_ids = new ArrayList<Integer>();
    ArrayList<String> group_names = new ArrayList<String>();
    out.println("<P>Signed in as "+username+" </p>");
    if (rset == null) return;
    while(rset.next()) {
      group_ids.add(rset.getInt(1));
      group_names.add(rset.getString(2));
  }

      out.write("\n");
      out.write("<HTML>\n");
      out.write("<HEAD>\n");
      out.write("\n");
      out.write("\n");
      out.write("<TITLE>Main Page</TITLE>\n");
      out.write("</HEAD>\n");
      out.write("<BODY>\n");
      out.write("\n");
      out.write("<hr>\n");
      out.write("<title>Sample program -- Upload image</title> \n");
      out.write("\n");
      out.write("<hr>\n");
      out.write("<!--<form name=\"upload-image\" method=\"POST\" enctype=\"multipart/form-data\" action=\"upload\">\n");
      out.write("<table>\n");
      out.write("  <tr>\n");
      out.write("    <th>File path: </th>\n");
      out.write("    <td><input name=\"file-path\" type=\"file\" size=\"30\" ></input></td>\n");
      out.write("  </tr>\n");
      out.write("\n");
      out.write("  <tr>\n");
      out.write("    <td ALIGN=CENTER COLSPAN=\"2\"><input type=\"submit\" name=\".submit\" \n");
      out.write("     value=\"Upload\"></td>\n");
      out.write("  </tr> \n");
      out.write("\n");
      out.write("</table>\n");
      out.write("Search:\n");
      out.write("<form name=\"search\" method=\"POST\" enctype=\"multipart/form-data\" action=\"search\">\n");
      out.write("<table>\n");
      out.write("  <tr>\n");
      out.write("    <td ALIGN=CENTER COLSPAN=\"2\"><input type=\"submit\" name=\".submit\" \n");
      out.write("     value=\"Search\"></td> -->\n");
      out.write("\n");
      out.write("<form name \"Upload\" ACTION=\"upload.html\" METHOD=\"post\"><center>\n");
      out.write("\t\t\t<INPUT Type=\"submit\" NAME=\"Upload\" VALUE =\"Upload\">\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<form name \"Search\" ACTION=\"searchScreen.jsp\" METHOD=\"post\"><center>\n");
      out.write("\t\t\t<INPUT Type=\"submit\" NAME=\"SEARCH\" VALUE =\"Search\">\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<form name \"Groups\" ACTION=\"groupScreen.jsp\" METHOD=\"post\"><center>\n");
      out.write("      <INPUT Type=\"submit\" NAME=\"GROUPS\" VALUE =\"Groups\">\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<form name \"GroupEdit\" ACTION=\"editScreen.jsp\" METHOD=\"post\"><center>\n");
      out.write("        <TD><B><I>Edit a group:</I></B></TD>\n");
      out.write("        <TR VALIGN=TOP ALIGN=LEFT>\n");
      out.write("        <select name=\"permitted\">\n");
      out.write("        ");
 for (int i = 0; i < group_names.size(); i++) { 
      out.write("\n");
      out.write("          <option value=\"");
      out.print(group_ids.get(i));
      out.write('"');
      out.write('>');
      out.print(group_names.get(i));
      out.write("</option>\n");
      out.write("              ");
 } 
      out.write("\n");
      out.write("            </TR>\n");
      out.write("      <INPUT Type=\"submit\" NAME=\"EDIT\" VALUE =\"EDIT\">\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body> \n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</BODY>\n");
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
