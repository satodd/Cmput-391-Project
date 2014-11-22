

<HTML>
<HEAD>


<TITLE>Registration Results</TITLE>
</HEAD>

<BODY>
<!--A simple example to demonstrate how to use JSP to 
    connect and query a database. 
    @author  Hong-Yu Zhang, University of Alberta
 -->
<%@ page import="java.sql.*" %>
<% 

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

            while(rset != null && rset.next()){
                taken = rset.getInt(1);
            }

            stmt = null;
            rset = null;
            int emailtest = 0;
            String sql4 = "SELECT COUNT(*) FROM persons WHERE email ='"+email+"'";

            //out.println("<p>"+sql+"</p>");
            try{
                stmt = conn.createStatement();
                rset = stmt.executeQuery(sql4);
            }

            catch(Exception ex){
                out.println("<hr>" + ex.getMessage() + "<hr>");
            }
              while(rset != null && rset.next()){
                emailtest = rset.getInt(1);
            }



    
 

            if (taken == 0){
                if (emailtest == 0){
                    out.println("<p>User registered please click Next to continue.</p>");
                    stmt = null;
                    rset = null;
                    String sql2 = "INSERT INTO users VALUES('"+userName+"','"+passwd+"',CURRENT_DATE)";

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
                    String redirectURL = "loginScreen.jsp";
                    response.sendRedirect(redirectURL);
                }
                else {
                out.println("<p>email taken please click Return to try again</p>");
                out.println("<form method=post action=registerScreen.jsp>");
                out.println("<input type=submit name=RETURN value=Return>");
                out.println("</form>");
            }
            }

            else{
                out.println("<p>User name taken please click Return to try again</p>");
                out.println("<form method=post action=registerScreen.jsp>");
                out.println("<input type=submit name=RETURN value=Return>");
                out.println("</form>");

                try{
                        conn.close();
                }
                catch(Exception ex){
                        out.println("<hr>" + ex.getMessage() + "<hr>");
                }


        }
}
%>



</BODY>
</HTML>

