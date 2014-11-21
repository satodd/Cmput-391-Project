package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<HEAD>\n");
      out.write("\n");
      out.write("\n");
      out.write("<TITLE>Registration Results</TITLE>\n");
      out.write("</HEAD>\n");
      out.write("\n");
      out.write("<BODY>\n");
      out.write("<!--A simple example to demonstrate how to use JSP to \n");
      out.write("    connect and query a database. \n");
      out.write("    @author  Hong-Yu Zhang, University of Alberta\n");
      out.write(" -->\n");
      out.write("\n");
 

        if(request.getParameter("CREATE") != null)
        {

	        //get the user input from the register page
        	String userName = (request.getParameter("USERID")).trim();
	        String passwd = (request.getParameter("PASSWD")).trim();
            String firstName = (request.getParameter("FNAME")).trim();
            String lastName = (request.getParameter("LNAME")).trim();
            String address = (request.getParameter("ADDR")).trim();
            String email = (request.getParameter("EMAIL")).trim();
            String phone = (request.getParameter("PHNO")).trim();
        	out.println("<p>Your input User Name is "+userName+"</p>");


	        //establish the connection to the underlying database
        	Connection conn = null;
	
	        String driverName = "oracle.jdbc.driver.OracleDriver";
            String dbstring = "jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
	
	        try{
		        //load and register the driver
        		Class drvClass = Class.forName(driverName); 
	        	DriverManager.registerDriver((Driver)
                drvClass.newInstance());
        	}
	        catch(Exception ex){
		        out.println("<hr>" + ex.getMessage() + "<hr>");
	
	        }
	
        	try{
	        	//establish the connection 
		        conn = DriverManager.getConnection(dbstring,"satodd","Edmonton01");
        		conn.setAutoCommit(false);
	        }
        	catch(Exception ex){
	        
		        out.println("<hr>" + ex.getMessage() + "<hr>");
        	}
	

	        //Checks if the username is unique
            Statement stmt = null;
            ResultSet rset = null;
            int taken = 0;
            String sql = "SELECT COUNT(*) FROM users WHERE user_name ='"+userName+"'";

            //out.println("<p>"+sql+"</p>");
            try{
                stmt = conn.createStatement();
                rset = stmt.executeQuery(sql);
            }

            catch(Exception ex){
                out.println("<hr>" + ex.getMessage() + "<hr>");
            }


    
            while(rset != null && rset.next())
                taken = rset.getInt(1);

            if (taken == 0){
            out.println("<p>userName not taken</p>");
            stmt = null;
            rset = null;
            String sql2 = "INSERT INTO users VALUES('"+userName+"','"+passwd+"',CURRENT_DATE)";

            out.println(sql2);
            try{
                stmt = conn.createStatement();
                rset = stmt.executeQuery(sql2);
                conn.commit();
            }

            catch(Exception ex){
                out.println("<hr>" + ex.getMessage() + "<hr>");
            }

            stmt = null;
            rset = null;
            String sql3 = "INSERT INTO persons VALUES('"+userName+"','"+firstName+"','"+lastName+"','"+address+"','"+email+"','"+phone+"')";
            try{
                stmt = conn.createStatement();
                rset = stmt.executeQuery(sql3);
                conn.commit();
            }

            catch(Exception ex){
                out.println("<hr>" + ex.getMessage() + "<hr>");
            }
        }

            else
                out.println("<p>User name taken</p>");


                try{
                        conn.close();
                }
                catch(Exception ex){
                        out.println("<hr>" + ex.getMessage() + "<hr>");
                }









        }
        else
        {
                out.println("<form method=post action=login.jsp>");
                out.println("UserName: <input type=text name=USERID maxlength=20><br>");
                out.println("Password: <input type=password name=PASSWD maxlength=20><br>");
                out.println("<input type=submit name=bSubmit value=Submit>");
                out.println("</form>");
        }      

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</BODY>\n");
      out.write("</HTML>\n");
      out.write("\n");
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
