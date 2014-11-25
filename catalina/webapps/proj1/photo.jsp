	
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%
	String username = (String)request.getSession().getAttribute("userName");
	if (username == "failed" || username == "guest" || username == null){
		out.println("<h1><CENTER>Unauthorized access</CENTER></H1>");
	} else {
	//CHECK FOR LOGIN
	//String username = (String)request.getSession().getAttribute("userName");
	//String username = "Test";

		String pid = request.getQueryString();

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

	    String isOwner;
		//check if user is owner
	    if (username.equals(owner)){
	    	isOwner = "true";
		} else {isOwner = "false";}

		boolean isInGroup;
	    //sql = "SELECT group_id, group_name FROM groups WHERE user_name='" + username + "'";
	    sql = "Select groups.group_id, groups.group_name from groups, group_lists Where groups.group_id = group_lists.group_id AND group_lists.friend_id ='"+ username + "'";

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
Hello <%=username%> - Image 
</center>
</h1>
</header>
<hr>

<table>
  <tr>
    <td><img src="image?<%=pid%>"/></td>
  </tr>
<% if(isOwner == "true") { %>
	<CENTER>
		<FORM NAME="Back" ACTION="main.jsp" METHOD="post" ><CENTER>
		<FORM NAME="UpdateForum" ACTION="updated.jsp" METHOD="post" ><CENTER>
		<TABLE>
			<TR VALIGN=TOP ALIGN=CENTER>
				<TD><B><I>ID Number:</I></B></TD>
				<TD><INPUT TYPE="text" NAME="imgid" value="<%=pid%>" READONLY><BR></TD>
			</TR>
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
					</select>
				</TD>
			</TR>
		</TABLE>
	</CENTER>
    <INPUT TYPE="submit" NAME="OK" VALUE="OK">
    <INPUT TYPE="submit" NAME="main" VALUE="Main">
	
<%} else { %>

	<CENTER>
		<TABLE>
			<TR VALIGN=TOP ALIGN=CENTER>
				<TD><B><I>Place:</I></B></TD>
				<TD><NAME="place" value="<%=place%>"><BR></TD>
			</TR>
			<TR VALIGN=TOP ALIGN=CENTER>
				<TD><B><I>Date:</I></B></TD>
				<TD><NAME="timing"></TD>
			</TR>
			<TR VALIGN=TOP ALIGN=CENTER>
				<TD><B><I>Subject:</I></B></TD>
				<TD><NAME="subject" value="<%=subject%>"></TD>
			</TR>
			<TR VALIGN=TOP ALIGN=CENTER>
				<TD><B><I>Description:</I></B></TD>
				<TD><NAME="desc" value="<%=desc%>"></TD>
			</TR>
		</TABLE>
	</CENTER>
<% } %>
	</body>
</HTML>
<%}%>
