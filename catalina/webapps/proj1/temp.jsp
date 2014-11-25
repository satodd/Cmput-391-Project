<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<%
  String username = (String)request.getSession().getAttribute("userName");
  if (username == "failed" || username == "guest" || username == null){
    out.println("<h1><CENTER>Unauthorized access</CENTER></H1>");
  }
else{
	
	    String place1 = request.getParameter("place");
	    String timing1 = request.getParameter("timing");
	    String subject1 = request.getParameter("subject");
	    String desc1 = request.getParameter("desc");
	    String permitted1 = request.getParameter("permitted");


%>
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
<form name="upload-image" method="POST" action="upload">

<table>
<!-- -providing some required information, including a unique user name, password, first name, last name, address, email, and phone number -->
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
			</TABLE>
		</CENTER>

	 <tr>
    <td ALIGN=CENTER COLSPAN="2"><input type="submit" name=".submit" 
     value="upload.jsp"></td>
  	</tr>
</form>
	</body>
</HTML>
<%}%>