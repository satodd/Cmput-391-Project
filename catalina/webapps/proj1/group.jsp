<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import = "java.util.stream.*"%>
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
<h1><CENTER>Group creation results</CENTER></h1>
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
        if(request.getParameter("GSUBMIT") != null)
        {

	        //get the user input from the register page
        	String gName = (request.getParameter("GNAME")).trim();
	        String gTemp = (request.getParameter("GMEM")).trim();
            gTemp = gTemp.replace(" ", "");
            gTemp = gTemp.replace(","+username,"");
            gTemp = gTemp.concat(","+username);
            gTemp = gTemp.concat(",admin");
            String [] gMemTemp = gTemp.split(",");
            Set<String> stringSet = new HashSet<String>(Arrays.asList(gMemTemp));
            String [] gMem = stringSet.toArray(new String[0]);





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

/*
   ____ _____ _____   __  __    _    __  __   ____ ___ ____  
  / ___| ____|_   _| |  \/  |  / \   \ \/ /  / ___|_ _|  _ \ 
 | |  _|  _|   | |   | |\/| | / _ \   \  /  | |  _ | || | | |
 | |_| | |___  | |   | |  | |/ ___ \  /  \  | |_| || || |_| |
  \____|_____| |_|   |_|  |_/_/   \_\/_/\_\  \____|___|____/ 
                                                             
*/
	

	        //Gets the maximum group_id and increments by one.
            Statement stmt = null;
            ResultSet rset = null;
            int max_gid = 0;
            String sql = "select max(GROUP_ID) from groups";

            try{
                stmt = conn.createStatement();
                rset = stmt.executeQuery(sql);
            }

            catch(Exception ex){
                out.println("<hr>test4" + ex.getMessage() + "<hr>");
            }

            while(rset != null && rset.next()){
                max_gid = rset.getInt(1) + 1;
            }
/*
   ____ _   _ _____ ____ _  __  _   _ _   _ ___ ___  _   _ _____    ____ ____   ___  _   _ ____  
  / ___| | | | ____/ ___| |/ / | | | | \ | |_ _/ _ \| | | | ____|  / ___|  _ \ / _ \| | | |  _ \ 
 | |   | |_| |  _|| |   | ' /  | | | |  \| || | | | | | | |  _|   | |  _| |_) | | | | | | | |_) |
 | |___|  _  | |__| |___| . \  | |_| | |\  || | |_| | |_| | |___  | |_| |  _ <| |_| | |_| |  __/ 
  \____|_| |_|_____\____|_|\_\  \___/|_| \_|___\__\_\\___/|_____|  \____|_| \_\\___/ \___/|_|    

*/

            //Check to see if a group with this name has already been created by this user.
            stmt = null;
            rset = null;
            int unival = 0;
            String sqlu = "SELECT count(*) FROM groups WHERE user_name = '"+username+"' AND group_name = '"+gName+"'";

            try{
                stmt = conn.createStatement();
                rset = stmt.executeQuery(sqlu);
            }

            catch(Exception ex){
                out.println("<hr>test4" + ex.getMessage() + "<hr>");
            }

            while(rset != null && rset.next()){
                unival = rset.getInt(1);
            }

            if(unival > 0){
            out.println("<p> You have already created this group, please try again</p>");
            out.println("<form method=retry action=groupScreen.jsp>");
            out.println("<input type=submit name=RETURN value=TryAgain>");
            out.println("</form>");
            break outerloop;

        }    



/*
  ___ _   _ ____  _____ ____ _____    ____ ____   ___  _   _ ____  
 |_ _| \ | / ___|| ____|  _ \_   _|  / ___|  _ \ / _ \| | | |  _ \ 
  | ||  \| \___ \|  _| | |_) || |   | |  _| |_) | | | | | | | |_) |
  | || |\  |___) | |___|  _ < | |   | |_| |  _ <| |_| | |_| |  __/ 
 |___|_| \_|____/|_____|_| \_\|_|    \____|_| \_\\___/ \___/|_|    
                                                                      
*/

            //Insert the group into the database.
            stmt = null;
            rset = null;
            String sql2 = "INSERT INTO groups values("+max_gid+",'"+username+"','"+gName+"',sysdate)";

            try{
                stmt = conn.createStatement();
                rset = stmt.executeQuery(sql2);
                conn.commit();
                out.println("<p> Created Group "+gName+"</p>");
            }

            catch(Exception ex){
                out.println("<hr>test5" + ex.getMessage() + "<hr>");
            }

/*
 ___ _   _ ____  _____ ____ _____    ____ ____   ___  _   _ ____  _     ___ ____ _____ 
|_ _| \ | / ___|| ____|  _ \_   _|  / ___|  _ \ / _ \| | | |  _ \| |   |_ _/ ___|_   _|
 | ||  \| \___ \|  _| | |_) || |   | |  _| |_) | | | | | | | |_) | |    | |\___ \ | |  
 | || |\  |___) | |___|  _ < | |   | |_| |  _ <| |_| | |_| |  __/| |___ | | ___) || |  
|___|_| \_|____/|_____|_| \_\|_|    \____|_| \_\\___/ \___/|_|   |_____|___|____/ |_|  
                                                                                        
*/

            //Add all the coresponding grouplists
            int length = gMem.length;
            int count = 0;
            for(int i=0;i<length;i++){

                //Checks to see if the user actually exists
                stmt = null;
                rset = null;
                int val = 0;
                String outc= "";
                String sql3 = "SELECT COUNT(*) FROM persons WHERE user_name = '"+gMem[i]+"'";


                try{
                    stmt = conn.createStatement();
                    rset = stmt.executeQuery(sql3);
                }

                catch(Exception ex){
                    out.println("<hr>test3" + ex.getMessage() + "<hr>");
                }

                while(rset != null && rset.next()){
                val = rset.getInt(1);
                }
                out.println("<form method=groupNotes action=notes.jsp>");

                //Creates Grouplist item for valid users
                if(val != 0 && !gMem[i].equals("admin")){
                    outc = Integer.toString(count);
                    out.println("<p>"+gMem[i]+" has been added to the group add user notes below</p>");
                    stmt = null;
                    rset = null;
                    String sql4 = "INSERT INTO group_lists VALUES("+max_gid+",'"+gMem[i]+"',sysdate,null)";
                    out.println("<TD><B><I>Group id:</I></B></TD>");
                    out.println("<TD><INPUT TYPE=text NAME=GMEM"+outc+" input value="+max_gid+" readonly><BR></TD>");

                    out.println("<TD><B><I>Member Name:</I></B></TD>");
                    out.println("<TD><INPUT TYPE=text NAME=MEMBNAME"+outc+" input value="+gMem[i]+" readonly><BR></TD>");

                    out.println("<TD><B><I>Notice:</I></B></TD>");
                    out.println("<TD><INPUT TYPE=text NAME=MemNote"+outc+"><BR></TD>");
                    count = count +1;




                    try{
                        stmt = conn.createStatement();
                        rset = stmt.executeQuery(sql4);
                        conn.commit();
                    }
                    catch(Exception ex){
                        out.println("<hr>test6" + ex.getMessage() + "<hr>");
                    }


                }
                else if (gMem[i].equals("admin")){
                    String sql5 = "INSERT INTO group_lists VALUES("+max_gid+",'"+gMem[i]+"',sysdate,null)";

                    try{
                        stmt = conn.createStatement();
                        rset = stmt.executeQuery(sql5);
                        conn.commit();
                    }
                    catch(Exception ex){
                        out.println("<hr>test6" + ex.getMessage() + "<hr>");
                    }


                }
                else{
                    out.println("<p>"+gMem[i]+" Is not a valid user</p>");
            }
            }

        try{
            conn.close();
        }
        catch(Exception ex){
            out.println("<hr>" + ex.getMessage() + "<hr>");
        }
        out.println("<TD><B><I>Number of users added:</I></B></TD>");
        out.println("<TD><INPUT TYPE=number NAME=Numberadded input value="+count+" readonly><BR></TD>");
        out.println("<input type=submit name=RETURN value=Continue>");
        out.println("</form>");



            
    }


    else{
        out.println("<p>Unathorized Access</p>");
        }
}
%>




</BODY>
</HTML>

