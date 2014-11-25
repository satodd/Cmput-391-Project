<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<HTML>
    <head>
    </head>
    <body>
            <%
                String username = (String)request.getSession().getAttribute("userName");
                if (username == "failed" || username == "guest" || username == null){
                    out.println("<h1><CENTER>Unauthorized access</CENTER></H1>");
                } else {

                String pid = request.getParameter ("imgid");
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
            %>

    </body>
</HTML>