package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class updated_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<HTML>\n");
      out.write("    <head>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("            ");

                String username = (String)request.getSession().getAttribute("userName");
                if (username == "failed" || username == "guest" || username == null){
                    out.println("<h1><CENTER>Unauthorized access</CENTER></H1>");
                } else {

                String pid = request.getParameter("imgid");
                out.println(pid);

                Connection conn = null;
                String driverName = "oracle.jdbc.driver.OracleDriver";
                String dbstring = "jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
                Class drvClass = Class.forName(driverName); 
                DriverManager.registerDriver((Driver)
                drvClass.newInstance());

                conn = DriverManager.getConnection(dbstring,"satodd","Edmonton01");
                conn.setAutoCommit(false);

             if (request.getParameter("OK") != null) {
                PreparedStatement sql2 = conn.prepareStatement("UPDATE images SET place=?, subject=?, description=? WHERE photo_id ="+pid);
                out.println(pid);

                out.println(request.getParameter("place"));
                out.println(request.getParameter("subject"));
                out.println(request.getParameter("desc"));
                sql2.setString(1, request.getParameter("place"));
                sql2.setString(2, request.getParameter("subject"));
                sql2.setString(3, request.getParameter("desc"));

                try {
                    sql2.execute();
                    sql2.executeUpdate("commit");
                    out.println("<p>Updated!</p>");

                    out.println("<form method=post action=photo.jsp?"+pid+">");
                    out.println("<input type=submit name=RETURN value=Return>");
                    out.println("</form>");
                }
                catch(Exception ex){
                    out.println("<hr>" + ex.getMessage() + "<hr>");
                }
                
            }
        }
            
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
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
