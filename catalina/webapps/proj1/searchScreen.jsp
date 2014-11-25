<%
	String username = (String)request.getSession().getAttribute("userName");
	String query = (String)request.getSession().getAttribute("imageView");
	if (username == "failed" || username == "guest" || username == null){
		out.println("<h1><CENTER>Unauthorized access</CENTER></H1>");
	}

else {
%>

<HTML>
	<HEAD>
		<TITLE>Search Page</TITLE>
	</HEAD>

	<BODY>
	<!--This is the login page-->
		<H1><CENTER>Searching module</CENTER></H1>

		<FORM NAME="SearchForm" ACTION="search.jsp" METHOD="post" ><CENTER>

			<P><CENTER>Please enter search terms below</CENTER></P>
			<TABLE>
				<TR VALIGN=TOP ALIGN=LEFT>
				<select name="Ordering">
					<option value="null">------------</option>
					<option value="FTL">Most to least recent</option>
					<option value="LTF">Least to most recent</option>
				</TR>
				</select>
				<TR VALIGN=TOP ALIGN=CENTER>
					<TD><B><I>Key Words:</I></B></TD>
					<TD><INPUT TYPE="text" NAME="KEYWORDS"  PLACEHOLDER="keywords"><BR></TD>
				</TR>
				<TR VALIGN=TOP ALIGN=CENTER>
					<TD><B><I>From:</I></B></TD>
					<TD><input type="date" name="FROM"><BR></TD>
				</TR>
				<TR VALIGN=TOP ALIGN=CENTER>
					<TD><B><I>To:</I></B></TD>
					<TD> <input type="date" name="TO"><BR></TD>
				</TR>
			</TABLE>

			<INPUT TYPE="submit" NAME="SEARCH" VALUE="SEARCH">
		</CENTER></FORM>


	</BODY>
</HTML>
<%}%>