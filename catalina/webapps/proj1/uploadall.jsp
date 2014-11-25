<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<%
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
%>