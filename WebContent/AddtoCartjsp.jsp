<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.* , java.lang.*" %>
<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.Cart" %>
<%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Droid+Sans:400,700" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.8.1/baguetteBox.min.css">
    <link rel="stylesheet" href="thumbnail-gallery.css">


</head>
<body>

 <div class="container gallery-container">
  <a href="index.jsp" style="float:right;font-size:20px;">Back to Home Page</a>
   <center>
   <h1>Your added items in the Cart </h1></center>
 
      
    <div class="tz-gallery">

        <div class="row">
        
        <%
        ArrayList <Cart> alk = new ArrayList<Cart>();
        alk =(ArrayList<Cart>) request.getAttribute("dat");
       int i=1;
       HttpSession sessions = request.getSession( );  
         for(Cart model : alk) {	
        	
         %> 

            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <a class="lightbox" href="#">
                        <img src='<%= model.getImage()%>' alt="Park" style="width:200px;height:200px;" />
                        
                    </a>
                    <div class="caption">
                        <center> <h3> US $<%=model.getPrice()%></h3>
                       Product Name : <%= model.getName() %> <br>
                       Product Id :<%= model.getProductId() %> <br>
                       </center>
                      <center><table><tr>
                    
                      <td><h4>
                      
                      <form action="BuyProduct.jsp" method="get">
                      
                      <input type="hidden" value=<%= model.getProductId() %> name="Id1" />
                       <input type="hidden" value=<%= model.getPrice() %> name="Id" />
                       <input type="submit" value="Buy" /> &nbsp;&nbsp;
                      </form>
                    </h4></td>
                      <td><h4>
                       <form action="RemoveItem_Process" method="get" style="align:right">
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      <input type="hidden" value=<%= model.getProductId() %> name="Id" />
             
                       <input type="submit" value="Remove" />&nbsp;&nbsp;&nbsp;
                     
                      </form>
                    </h4></td>
                     
                      </tr></table></center> 
              
               </tr>
               </table>
                <center>
                    </div>
                </div>
            </div>
            <%
            
          if(i%3==0 ){
           out.println("<br>");
          
          }
            i++;
            
         }
                
        
       
        %>
            
        </div>

    </div>

</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.8.1/baguetteBox.min.js"></script>
<script>
    baguetteBox.run('.tz-gallery');
</script>



</body>
</html>