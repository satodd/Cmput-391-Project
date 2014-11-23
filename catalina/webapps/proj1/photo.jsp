	
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%
	//CHECK FOR LOGIN
	//String username = (String)request.getSession().getAttribute("userName");
	String username = "Test2";

	String pid = request.getQueryString();

	// check if user is owner
	boolean isOwner = true;

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

    sql = "SELECT group_id, group_name FROM groups WHERE user_name='" + username + "'";

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

%>

<HTML>
<HEAD>


<TITLE>Image</TITLE>
</HEAD>
<BODY>

<title>Image</title> 
<header>
<h1>
<center>
Image 
</center>
</h1>
</header>
<hr>

<form name="upload-image" method="POST" enctype="multipart/form-data" action="upload">

<table>
  <tr>
    <td><img src="image?<%=pid%>"/></td>
  </tr>

<% if(isOwner) { %>
	<CENTER>
		<TABLE>
			<TR VALIGN=TOP ALIGN=CENTER>
				<TD><B><I>Place:</I></B></TD>
				<TD><INPUT TYPE="text" NAME="place" value="<%=place%>"><BR></TD>
			</TR>
			<TR VALIGN=TOP ALIGN=CENTER>
				<TD><B><I>Date:</I></B></TD>
				<TD><INPUT TYPE="date" NAME="timing"></TD>
			</TR>
			<TR VALIGN=TOP ALIGN=CENTER>
				<TD><B><I>Subject:</I></B></TD>
				<TD><INPUT TYPE="text" NAME="subject" value="<%=subject%>"></TD>
			</TR>
			<TR VALIGN=TOP ALIGN=CENTER>
				<TD><B><I>Description:</I></B></TD>
				<TD><TEXTAREA style="resize:none;" NAME="desc" value="<%=desc%>"></TEXTAREA></TD>
			</TR>

			<TR VALIGN=TOP ALIGN=CENTER>
				<TD><B><I>Access:</I></B></TD>
				<TD>
					<select name="permitted">
						<option value="2">Private</option>
				    	<option value="1">Public</option>
				    	<% for (int i = 0; i < group_names.size(); i++) { %>
				    		<option value="<%=group_ids.get(i)%>"><%=group_names.get(i)%></option>
				    	<% } %>
						<!-- 
						each(group)
							<option value="{{group.id}}">{{group.name}}</option>
						-->
					</select>
				</TD>
			</TR>
		</TABLE>
	</CENTER>
<% } else { %>
	
<% } %>

		

	  <tr>
    <td ALIGN=CENTER COLSPAN="2"><input type="submit" name=".submit" 
     value="OK"></td>
  </tr>

	</body>
</HTML>
