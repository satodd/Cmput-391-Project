<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<%
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
%>
<HTML>
<HEAD>


<TITLE>Main Page</TITLE>
</HEAD>
<BODY>

<hr>
<title>Sample program -- Upload image</title> 

<hr>
<!--<form name="upload-image" method="POST" enctype="multipart/form-data" action="upload">
<table>
  <tr>
    <th>File path: </th>
    <td><input name="file-path" type="file" size="30" ></input></td>
  </tr>

  <tr>
    <td ALIGN=CENTER COLSPAN="2"><input type="submit" name=".submit" 
     value="Upload"></td>
  </tr> 

</table>
Search:
<form name="search" method="POST" enctype="multipart/form-data" action="search">
<table>
  <tr>
    <td ALIGN=CENTER COLSPAN="2"><input type="submit" name=".submit" 
     value="Search"></td> -->

<form name "Upload" ACTION="upload.html" METHOD="post"><center>
			<INPUT Type="submit" NAME="Upload" VALUE ="Upload">
</form>

<form name "Search" ACTION="searchScreen.jsp" METHOD="post"><center>
			<INPUT Type="submit" NAME="SEARCH" VALUE ="Search">

</form>

<form name "Groups" ACTION="groupScreen.jsp" METHOD="post"><center>
      <INPUT Type="submit" NAME="GROUPS" VALUE ="Groups">

</form>

<form name "GroupEdit" ACTION="editScreen.jsp" METHOD="post"><center>
        <TD><B><I>Edit a group:</I></B></TD>
        <TR VALIGN=TOP ALIGN=LEFT>
        <select name="permitted">
        <% for (int i = 0; i < group_names.size(); i++) { %>
          <option value="<%=group_ids.get(i)%>"><%=group_names.get(i)%></option>
              <% } %>
            </TR>
      <INPUT Type="submit" NAME="EDIT" VALUE ="EDIT">

</form>


</body> 
</html>






</BODY>
</HTML>
<%}%>