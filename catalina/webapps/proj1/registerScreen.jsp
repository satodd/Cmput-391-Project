<HTML>
	<head>

	</head>

	<body>
		<h1><center>User Registration</center></h1>
		<p><center>Please provide your information</center></p>
		<!-- -providing some required information, including a unique user name, password, first name, last name, address, email, and phone number -->
		<FORM NAME="RegistrationForm" ACTION="register.jsp" METHOD="post" ><CENTER>
			<TABLE>
				<TR VALIGN=TOP ALIGN=CENTER>
					<TD><B><I>Userid:</I></B></TD>
					<TD><INPUT TYPE="text" NAME="USERID" placeholder="userid" required><BR></TD>
				</TR>
				<TR VALIGN=TOP ALIGN=CENTER>
					<TD><B><I>Password:</I></B></TD>
					<TD><INPUT TYPE="password" NAME="PASSWD" placeholder="password" required></TD>
				</TR>
				<TR VALIGN=TOP ALIGN=CENTER>
					<TD><B><I>First Name:</I></B></TD>
					<TD><INPUT TYPE="text" NAME="FNAME" placeholder="first name" required></TD>
				</TR>
				<TR VALIGN=TOP ALIGN=CENTER>
					<TD><B><I>Last Name:</I></B></TD>
					<TD><INPUT TYPE="text" NAME="LNAME" placeholder="last name" required></TD>
				</TR>
				<TR VALIGN=TOP ALIGN=CENTER>
					<TD><B><I>Address:</I></B></TD>
					<TD><INPUT TYPE="text" NAME="ADDR" placeholder="address" required></TD>
				</TR>
				<TR VALIGN=TOP ALIGN=CENTER>
					<TD><B><I>Email:</I></B></TD>
					<TD><INPUT TYPE="text" NAME="EMAIL" placeholder="email" required></TD>
				</TR>
				<TR VALIGN=TOP ALIGN=CENTER>
					<TD><B><I>Phone Number:</I></B></TD>
					<TD><INPUT TYPE="text" NAME="PHNO" placeholder="phone #" required></TD>
				</TR>
			</TABLE>
			<INPUT TYPE="submit" NAME="CREATE" VALUE="Create">
		</CENTER></FORM>

	</body>
</HTML>