<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Admin| Insert Product</title>
	<link type="text/css" href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link type="text/css" href="css/theme.css" rel="stylesheet">
	<link type="text/css" href="images/icons/css/font-awesome.css" rel="stylesheet">
	<link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600' rel='stylesheet'>
<script src="http://js.nicedit.com/nicEdit-latest.js" type="text/javascript"></script>
<script type="text/javascript">bkLib.onDomLoaded(nicEditors.allTextAreas);</script>
<script src="jquery.min.js"></script>
          <script>
	function confirmGo(m, u) {
		if (confirm(m)) {
			window.location = u;
		}
	}
</script>

<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    with:300px;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
</style>


</head>
<body>

<%@include file="header.jsp" %>
	<div class="wrapper">
		<div class="container">
			<div class="row">

<%@include file="sidebar.jsp" %>				
			<div class="span9">
					<div class="content">

						<div class="module">
							<div class="module-head">
							<%String name = (String)request.getAttribute("name"); %>
						

<h2><%if(name=="value"){ %>
Password updated successfully
</h2>
<%
}
%>
							
								<h3>Display Product</h3>
							</div>
							<div class="module-body">


			<sql:setDataSource driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/buyme" user="root" password="11111"
		var="mydb" />

	<sql:query dataSource="${mydb}" var="result">
            SELECT * from product;
        </sql:query>
	<form >
	
	<table class="table table-hover table-dark"  id="customers">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Category</th>
				<th scope="col">Sub Category</th>
				<th scope="col">Company</th>
				<th scope="col">Price without Discount</th>
				<th scope="col">Price with discount</th>
				<!-- <th scope="col">Description</th> -->
				<th scope="col">Shipping Charge</th>
				<th scope="col">Availability</th>
				<th colspan="3">Action</th>
			</tr>
		</thead>
		<tbody>
		
		 <c:forEach var="row" items="${result.rows}">
                    <tr>
                    
                        <td><c:out value="${row.productId}"/></td>
                        <td><c:out value="${row.productName}"/></td>
                        <td><c:out value="${row.category}"/></td>
                        <td><c:out value="${row.subcategory}"/></td>
                        <td><c:out value="${row.productCompany}"/></td>
                        <td><c:out value="${row.productpricebd}"/></td>
                        <td><c:out value="${row.productprice}"/></td>
                         <td><c:out value="${row.productShippingcharge}"/></td>
                        <td><c:out value="${row.productAvailability}"/></td>
                        <td><a href="Update?id=<c:out value="${row.productId}"/>">Update</a></td>
                       <td><a href="javascript:confirmGo('Sure to delete this record?','DeleteProduct?productId=<c:out value="${row.productId}"/>')">Delete</a></td>
                         
                        <td><a href="showImage.jsp?Id=<c:out value="${row.productId}"/>">Details</a></td> 
                    </tr>
                </c:forEach>
			
		</tbody>
	</table>
	
	
	</form>
	
	
							</div>
						</div>


	
						
						
					</div><!--/.content-->
				</div><!--/.span9-->
			</div>
		</div><!--/.container-->
	</div><!--/.wrapper-->

<%@include file="footer.jsp" %>

	<script src="scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
	<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="scripts/flot/jquery.flot.js" type="text/javascript"></script>
	<script src="scripts/datatables/jquery.dataTables.js"></script>
	<script>
		$(document).ready(function() {
			$('.datatable-1').dataTable();
			$('.dataTables_paginate').addClass("btn-group datatable-pagination");
			$('.dataTables_paginate > a').wrapInner('<span />');
			$('.dataTables_paginate > a:first-child').append('<i class="icon-chevron-left shaded"></i>');
			$('.dataTables_paginate > a:last-child').append('<i class="icon-chevron-right shaded"></i>');
		} );
	</script>
</body>