<%
  String username = (String)request.getSession().getAttribute("userName");
  if (username == "failed" || username == "guest" || username == null){
    out.println("<h1><CENTER>Unauthorized access</CENTER></H1>");
  }
else{
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
			<INPUT Type="submit" NAME="Search" VALUE ="Search">

</form>

<form name "Groups" ACTION="groupScreen.jsp" METHOD="post"><center>
      <INPUT Type="submit" NAME="Search" VALUE ="Groups">

</form>


</body> 
</html>






</BODY>
</HTML>
<%}%>