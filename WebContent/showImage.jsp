<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="jquery.min.js"></script>
    </head>
    <body bgcolor="silver">
   <center> <h2><a href="index.jsp" >Home</a></h2></center>
    <%
      String n =  request.getParameter("Id");
     int  id = Integer.parseInt(n);
     try{
         Class.forName("com.mysql.jdbc.Driver");
   Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/buyme", "root", "11111");
   Statement st= (Statement) con.createStatement();
    ResultSet rs=st.executeQuery("Select * from product");
    int ii=0;
    int k=1;
  
        while(rs.next()){
        	         	
        	
        	 int match =  rs.getInt(1);
             
        	if(match==id)
        	{
        		%>
        		<table >
        		<tr><td>
        		<div style="color:blue">
        		<img src=" <%= rs.getString(11) %> " style="float:left;width:500px;height:500px;margin:40px"/></td><td>
        		<div  style="float:center;color: black;margin-left:100px">
        		
        		<h1>Prodduct Name : <%= rs.getString(4) %></h1>
        		<h1>Prodduct Company : <%= rs.getString(5) %></h1>
        		<h1>Price Before Discount : $<%= rs.getString(6) %></h1>
        		<h1>Price After Discount  : $<%= rs.getString(7) %></h1>
        			<h1>Quantity : 4</h1>	
        		<h2>Prodduct Description : <%= rs.getString(8) %></h2>
        		
        		<table><tr><td>
        		 
        		<h1> <form action="AddtoCart_Process">
        		<input type="hidden" value=<%= id %>  name="Id"/>
        		 <input type="submit" value="Add to Cart" style="width:100px;height:40px;color:blue"/> 
        	    
        		 </form></h1></td>	</table>
        		 
        		</div>
        		</div></td></tr>
        		</table>
        		
        		
        		<% 
        	}
        
        
        
        }
        con.close();
     }
        catch(Exception e){
        System.out.println(e.getMessage());
        
        }   
                
       
       %>
       
       
      
      
    </body>
</html>
