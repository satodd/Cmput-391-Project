<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<%
  String username = (String)request.getSession().getAttribute("userName");
  Integer pic_id = (Integer)request.getSession().getAttribute("pic_id");
  if (username == "failed" || username == "guest" || username == null){
    out.println("<h1><CENTER>Unauthorized access</CENTER></H1>");
  }
else{;

    String place = null;
    String timing = null;
    String subject = null;;
    String desc = null;
    String permitted = null;



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
Please info for the image! 
<form name="upload" method="POST" action="uploadall.jsp">
<table>
<!-- -providing some required information, including a unique user name, password, first name, last name, address, email, and phone number -->
		<CENTER>
      <TABLE>
        <TR VALIGN=TOP ALIGN=CENTER>
          <TD><B><I>Place:</I></B></TD>
          <TD><INPUT TYPE="text" NAME="place" value= <% out.println(place); %> ><BR></TD>
        </TR>
        <TR VALIGN=TOP ALIGN=CENTER>
          <TD><B><I>Date:</I></B></TD>
          <TD><INPUT TYPE="date" NAME="timing" value= <% out.println(timing); %>></TD>
        </TR>
        <TR VALIGN=TOP ALIGN=CENTER>
          <TD><B><I>Subject:</I></B></TD>
          <TD><INPUT TYPE="text" NAME="subject" value= <% out.println(subject); %>></TD>
        </TR>
        <TR VALIGN=TOP ALIGN=CENTER>
          <TD><B><I>Description:</I></B></TD>
          <TD><input type="text" NAME="desc" value= <% out.println(desc); %>></TEXTAREA></TD>
        </TR>
        <!--<TR VALIGN=TOP ALIGN=CENTER>
        <TD><B><I>photoid</I></B></TD>
          <TD><input type="text" NAME="photoid" value="<%out.println(pic_id);%>" READONLY></TD>
        </TR>-->
        <TR VALIGN=TOP ALIGN=CENTER>
        <TD><B><I>Access:</I></B></TD>
          <TD><input type="text" NAME="permit" value = <% out.println(permitted); %>></TD>
        </TR>
      </TABLE>
    </CENTER>

	 <tr>
    <td ALIGN=CENTER COLSPAN="2"><input type="submit" name=".submit" 
     value="Info"></td>
  	</tr>
</form>
	</body>
</HTML>
<%}%>