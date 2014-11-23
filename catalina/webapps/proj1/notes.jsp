<%@ page import="java.sql.*" %>

<%
    String username = (String)request.getSession().getAttribute("userName");
    if (username == "failed" || username == "guest" || username == null){
        out.println("<h1><CENTER>Unauthorized access</CENTER></H1>");
    }
else{
%>
<HTML>
<HEAD>


<TITLE>Group creation results</TITLE>
</HEAD>

<BODY>
<!--
 -->

<%
/*
   ____ _____ _____   _____ ___  ____  __  __   ____   _    ____      _    __  __ ____  
  / ___| ____|_   _| |  ___/ _ \|  _ \|  \/  | |  _ \ / \  |  _ \    / \  |  \/  / ___| 
 | |  _|  _|   | |   | |_ | | | | |_) | |\/| | | |_) / _ \ | |_) |  / _ \ | |\/| \___ \ 
 | |_| | |___  | |   |  _|| |_| |  _ <| |  | | |  __/ ___ \|  _ <  / ___ \| |  | |___) |
  \____|_____| |_|   |_|   \___/|_| \_\_|  |_| |_| /_/   \_\_| \_\/_/   \_\_|  |_|____/ 
                                                                                        
*/


        outerloop:
        if(request.getParameter("RETURN") != null)
        {

	        //get the user input from the register page
            String number = (request.getParameter("Numberadded")).trim();
            int count = Integer.parseInt(number);
            String number2 = (request.getParameter("GMEM0")).trim();
            int group_id = Integer.parseInt(number2);
            if (count == 0){
                String redirectURL = "main.jsp";
                response.sendRedirect(redirectURL);

        }
        	String [] memNames  = new String[count];
            String [] memNotes = new String[count];
            String memTemp = "";
            String noteTemp ="";
            for(int i = 0;i<count;i++){
                memTemp = (request.getParameter("MEMBNAME"+i)).trim();
                noteTemp =(request.getParameter("MemNote"+i)).trim();
                memNames[i] = memTemp;
                memNotes[i] = noteTemp;
                out.println("<p>"+memTemp+"</p>");


        }




/*
   ____ ___  _   _ _   _ _____ ____ _____   _____ ___    ____  ____  
  / ___/ _ \| \ | | \ | | ____/ ___|_   _| |_   _/ _ \  |  _ \| __ ) 
 | |  | | | |  \| |  \| |  _|| |     | |     | || | | | | | | |  _ \ 
 | |__| |_| | |\  | |\  | |__| |___  | |     | || |_| | | |_| | |_) |
  \____\___/|_| \_|_| \_|_____\____| |_|     |_| \___/  |____/|____/ 

*/

	        //establish the connection to the underlying database
        	Connection conn = null;
	
	        String driverName = "oracle.jdbc.driver.OracleDriver";
            String dbstring = "jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
	
	        try{
		        //load and register the driver
        		Class drvClass = Class.forName(driverName); 
	        	DriverManager.registerDriver((Driver)
                drvClass.newInstance());
        	}
	        catch(Exception ex){
		        out.println("<hr>test1" + ex.getMessage() + "<hr>");
	
	        }
	
        	try{
	        	//establish the connection 
		        conn = DriverManager.getConnection(dbstring,"satodd","Edmonton01");
        		conn.setAutoCommit(false);
	        }
        	catch(Exception ex){
	        
		        out.println("<hr>test2" + ex.getMessage() + "<hr>");
        	}





            Statement stmt = null;
            ResultSet rset = null;
            String sql = " ";

            for(int j = 0;j<count;j++){
            
                stmt = null;
                rset = null;
                sql = "UPDATE group_lists SET notice = '"+memNotes[j]+"' WHERE group_id = '"+group_id+"' and friend_id ='"+memNames[j]+"'";

                

                try{
                    stmt = conn.createStatement();
                    rset = stmt.executeQuery(sql);
                    conn.commit();
                }
                catch(Exception ex){
                    out.println("<hr>test6" + ex.getMessage() + "<hr>");
                }


        }


        try{
            conn.close();
        }
        catch(Exception ex){
            out.println("<hr>" + ex.getMessage() + "<hr>");
        }
        String redirectURL = "main.jsp";
        response.sendRedirect(redirectURL);




            
    }


    else{
        out.println("<p>Unathorized Access</p>");
        }
}
%>




</BODY>
</HTML>

