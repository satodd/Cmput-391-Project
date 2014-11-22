<% 	String username = (String)request.getSession().getAttribute("userName");
	if (username == null){
		username = "guest";
}
%>                 
<HTML>
	<HEAD>
		<TITLE>White screen image sharing</TITLE>
	</HEAD>

	<BODY>
	<!--This is the login page-->
		<H1><CENTER>Sample Login</CENTER></H1>
		<%if (username.equals("failed")){
			out.println("<p><CENTER><FONT color = \"red\">Login Failed please try again</FONT></CENTER></p>");
			}
		%>

		<FORM NAME="LoginForm" ACTION="login.jsp" METHOD="post" ><CENTER>

			<P><CENTER>Welcome to the worlds top barebones no style or design image sharing site.</CENTER></P>
			<TABLE>
				<TR VALIGN=TOP ALIGN=CENTER>
					<TD><B><I>Userid:</I></B></TD>
					<TD><INPUT TYPE="text" NAME="USERID"  PLACEHOLDER="userid"><BR></TD>
				</TR>
				<TR VALIGN=TOP ALIGN=CENTER>
					<TD><B><I>Password:</I></B></TD>
					<TD><INPUT TYPE="password" NAME="PASSWD" PLACEHOLDER="password"></TD>
				</TR>
			</TABLE>

			<INPUT TYPE="submit" NAME="Submit" VALUE="LOGIN">
		</CENTER></FORM>

		<form name "registerForm" ACTION="registerScreen.jsp" METHOD="post"><center>
			<INPUT Type="submit" NAME="Register" VALUE ="REGISTER">
		</center></form>
</HTML>