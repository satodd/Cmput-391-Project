<%
	String username = (String)request.getSession().getAttribute("userName");
	if (username == "failed" || username == "guest" || username == null){
		out.println("<h1><CENTER>Unauthorized access</CENTER></H1>");
	}
else{
%>
<HTML>
	<HEAD>
		<TITLE>Add a group</TITLE>
	</HEAD>

	<BODY>
	<!--This is the login page-->
		<H1><CENTER>Create your own user group, add members sperated by commas</CENTER></H1>

		<FORM NAME="GroupForm" ACTION="group.jsp" METHOD="post" ><CENTER>
			<TD><B><I>Group Name:</I></B></TD>
				<TD><INPUT TYPE="text" NAME="GNAME" placeholder="group name" required><BR></TD>
			<TD><B><I>Group Members:</I></B></TD>
				<TD><INPUT TYPE="text" NAME="GMEM" placeholder="group members" required><BR></TD>

			<INPUT TYPE="submit" NAME="GSUBMIT" VALUE="SUBMIT">
		</CENTER></FORM>


	</BODY>
</HTML>
<%}%>