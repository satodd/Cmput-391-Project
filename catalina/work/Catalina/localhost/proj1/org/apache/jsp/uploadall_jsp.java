package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class uploadall_jsp extends org.apache.jasper.runtime.HttpJspBase
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
else{

    String place = request.getParameter("place");
    String timing = request.getParameter("timing");
    String subject = request.getParameter("subject");
    String desc = request.getParameter("desc");
    String permitted = request.getParameter("permitted");



    Connection conn = null;
    String driverName = "oracle.jdbc.driver.OracleDriver";
    String dbstring = "jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
    Class drvClass = Class.forName(driverName); 
    DriverManager.registerDriver((Driver)drvClass.newInstance());

    conn = DriverManager.getConnection(dbstring,"satodd","Edmonton01");
    conn.setAutoCommit(false);
    

    PreparedStatement sql = conn.prepareStatement("UPDATE images SET place=?, subject=?, description=?, permitted=? WHERE photo_id =" +pic_id);
                out.println(pic_id);
                out.println(request.getParameter("place"));
                out.println(request.getParameter("subject"));
                out.println(request.getParameter("desc"));
                out.println(request.getParameter("permited"));
                sql.setString(1, place);
                sql.setString(2, subject);
                sql.setString(3, desc);
                sql.setString(4, permitted);

    try{
          sql.execute();
          sql.executeUpdate("commit");
      }

      catch(Exception ex){
          out.println("<hr>" + ex.getMessage() + "<hr>");
      }
    //response.sendRedirect("upload.jsp");
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
