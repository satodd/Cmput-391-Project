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

    String place1 = null;
    String timing1 = null;
    String subject1 = null;
    String desc1 = null;
    String permitted1 = "Private";
%>



<HTML>
<HEAD>
<TITLE>Upload</TITLE>
</HEAD>
<BODY>

<title>Upload image</title> 
<header>
<h1>
<center>
Image Upload
</center>
</h1>
</header>
<hr>
Please input or select the path of the image!
<form name="upload-image" method="POST" enctype="multipart/form-data" action="upload">

<table>
  <tr>
    <th>File path: </th>
    <td><input name="file-path" type="file" size="30" ></input></td>
  </tr>
</TABLE>
<!-- -providing some required information, including a unique user name, password, first name, last name, address, email, and phone number 
		<CENTER>
      <TABLE>
        <TR VALIGN=TOP ALIGN=CENTER>
          <TD><B><I>Place:</I></B></TD>
          <TD><INPUT TYPE="text" NAME="place" value= <% out.println(place1); %> ><BR></TD>
        </TR>
        <TR VALIGN=TOP ALIGN=CENTER>
          <TD><B><I>Date:</I></B></TD>
          <TD><INPUT TYPE="date" NAME="timing" value= <% out.println(timing1); %>></TD>
        </TR>
        <TR VALIGN=TOP ALIGN=CENTER>
          <TD><B><I>Subject:</I></B></TD>
          <TD><INPUT TYPE="text" NAME="subject" value= <% out.println(subject1); %>></TD>
        </TR>
        <TR VALIGN=TOP ALIGN=CENTER>
          <TD><B><I>Description:</I></B></TD>
          <TD><input type="text" NAME="desc" value= <% out.println(desc1); %>></TEXTAREA></TD>
        </TR>
        <TR VALIGN=TOP ALIGN=CENTER>
        <TD><B><I>Access:</I></B></TD>
          <TD><input type="text" NAME="groupid" value = <% out.println(permitted1); %>></TD>
        </TR>
        <TR VALIGN=TOP ALIGN=CENTER>
        <TD><B><I>Access:</I></B></TD>
          <TD><input type="text" NAME="permit" value = <% out.println(permitted1); %>></TD>
        </TR>
      </TABLE>
    </CENTER>-->

	 <tr>
    <td ALIGN=CENTER COLSPAN="2"><input type="submit" name=".submit" 
     value="Upload"></td>
  	</tr>
</form>
	</body>
</HTML>
<%}%>