<%@ page import="java.sql.*" %>
<%
String name=request.getParameter("val");
if(name==null||name.trim().equals("")){
out.print("<p>Please enter name!</p>");
}else{
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/buyme","root","11111");
PreparedStatement ps=con.prepareStatement("select * from product where productName like '"+name+"%'");
ResultSet rs=ps.executeQuery();
%>
<div style="z-index:1000;background-color:white">
<%
if(!rs.isBeforeFirst()) {    
 out.println("<p>No Record Found!</p>"); 
}else{
out.print("<table z-index='200' cellpadding='2' width='100%'>");

while(rs.next()){
 %>
 <tr><td> <a href="showImage.jsp?Id=<%=rs.getInt(1)%>"> <%= rs.getString(4) %> </a></td></tr>
<%  System.out.println("------------------------------------"); %>
 
 <%
}
out.print("</table>");
}//end of else for rs.isBeforeFirst
con.close();
}catch(Exception e){out.print(e);}
}//end of else
%>
</div>