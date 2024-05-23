<%@ page import="java.util.ArrayList" %>
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

            function convertToStringAndShow(data) {
                var reader = new FileReader();
                reader.readAsDataURL(data.files[0]);
                reader.onload = function () {
                    // fetch imsge as Base64 String
                    var imageAsString = reader.result;
                    // Show into Image-tag
                    $('#imageTag').attr('src', imageAsString);

                    // Insert into Hidden field, will be get into Server(saveAction.jsp): On form-submit
                    $('#strImage').val(imageAsString);
                }
                //alert( reader.onload);
            }
        </script>
     

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
								<h3>Update Product</h3>
							</div>
							<div class="module-body">

<%
ArrayList <String> str1=new ArrayList <String>();

if (request.getSession().getAttribute("str1") != null) {
str1 = (ArrayList ) request.getSession().getAttribute("str1");


}

%>

<form class="form-horizontal row-fluid" action="Update_process" method="post" >
<input type="hidden" name="id" value="${str1[0]}"/>
<div class="control-group">
<label class="control-label" for="basicinput">Category</label>
<div class="controls">
<select name="category" class="span8 tip" onChange="getSubcat(this.value);"  required>
<option value="${str1[1]}">${str1[1]}</option> 
<option value="Fashion">Fashion</option>
<option value="Electronics">Electronics</option>
</select>
</div>
</div>								
<div class="control-group">
<label class="control-label" for="basicinput">Sub Category</label>
<div class="controls">
<select   name="subcategory"  id="subcategory" class="span8 tip" required>
<option value="${str1[2]}">${str1[2]}</option> 
<option value="Fashion">Fashion</option>
<option value="Electronics">Electronics</option>
</select>
</div>
</div>


<div class="control-group">
<label class="control-label" for="basicinput">Product Name</label>
<div class="controls">
<input type="text"  value="${str1[3]}"  name="productName"  placeholder="${str1[3]}" class="span8 tip" required>
</div>
</div>

<div class="control-group">
<label class="control-label" for="basicinput">Product Company</label>
<div class="controls">
<input type="text" value="${str1[4]}"   name="productCompany"  placeholder="${str1[4]}" class="span8 tip" required>
</div>
</div>
<div class="control-group">
<label class="control-label" for="basicinput">Product Price Before Discount</label>
<div class="controls">
<input type="text"  value="${str1[5]}"  name="productpricebd"  placeholder="${str1[5]}" class="span8 tip" required>
</div>
</div>

<div class="control-group">
<label class="control-label" for="basicinput">Product Price After Discount(Selling Price)</label>
<div class="controls">
<input type="text"  value="${str1[6]}"  name="productprice"  placeholder="${str1[6]}" class="span8 tip" required>
</div>
</div>

<div class="control-group">
<label class="control-label" for="basicinput">Product Description</label>
<div class="controls">
<textarea  name="productDescription" rows="6" class="span8 tip">${str1[7]}
</textarea>  
</div>
</div>

<div class="control-group">
<label class="control-label" for="basicinput">Product Shipping Charge</label>
<div class="controls">
<input type="text"  value="${str1[8]}" name="productShippingcharge"  placeholder="${str1[8]}" class="span8 tip" required>
</div>
</div>

<div class="control-group">
<label class="control-label" for="basicinput">Product Availability</label>
<div class="controls">
<select   name="productAvailability"  id="productAvailability" class="span8 tip" required>
<option value="${str1[9]}">${str1[9]}</option>
<option value="In Stock">In Stock</option>
<option value="Out of Stock">Out of Stock</option>
</select>
</div>
</div>



<div class="control-group">
<label class="control-label" for="basicinput">Product Image1</label>
<div class="controls">
<input type="file" class="span8 tip"onchange="convertToStringAndShow(this);"   />
<img src="" id="imageTag"/>
<input type="hidden" value="${str1[10]}" name="productimage1" id="strImage" />         
</div>
</div>


	<div class="control-group">
											<div class="controls">
												<button type="submit" name="submit" class="btn btn-primary">Update</button>
											</div>
										</div>
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