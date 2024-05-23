<head>
<link href="bootstrap.css" type="text/css" rel="stylesheet">
<link href="login.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
 $(document).ready(function () {
    $('.forgot-pass').click(function(event) {
      $(".pr-wrap").toggleClass("show-pass-reset");
    }); 
    
    $('.pass-reset-submit').click(function(event) {
      $(".pr-wrap").removeClass("show-pass-reset");
    }); 
});
</script>
</head>
<body>
<div class="container" style="margin-top:100px">
    <div class="row">
	<div class="col-md-6">
				<h3 class="dark-grey"style="color:white">Terms and Conditions</h3>
				<p style="color:white">
					By clicking on "Register" you agree to The Company's' Terms and Conditions
				</p>
				<p style="color:white">
					While rare, prices are subject to change based on exchange rate fluctuations - 
					should such a fluctuation happen, we may request an additional payment. You have the option to request a full refund or to pay the new price. (Paragraph 13.5.8)
				</p>
				<p style="color:white">
					Should there be an error in the description or pricing of a product, we will provide you with a full refund (Paragraph 13.5.6)
				</p>
				<p style="color:white">
					Acceptance of an order by us is dependent on our suppliers ability to provide the product. (Paragraph 13.5.6)
				</p>
				<a href="#" class="btn btn-primary">Register</a>
			</div>
<%String name = (String)request.getAttribute("name"); %>
<h2 style="color:white"><%if(name=="value"){ %>
Your  password or email is not correct
</h2>
<%
}
%>
	
        <div class="col-md-6">
            <div class="pr-wrap">
                <div class="pass-reset">
                    <label>
                        Enter the email you signed up with</label>
                    <input type="email"  placeholder="Email" />
                    <input type="submit" value="Submit" class="pass-reset-submit btn btn-success btn-sm" />
                </div>
            </div>
            <div class="wrap">
                <p class="form-title">
                    Sign In</p>
                <form class="login" action="Userlogin_process" method="post" >
                <input type="text" name="email" placeholder="Enter your Email" required/>
                <input type="password" name="password" placeholder="Enter your Password" required />
                <input type="submit" value="Sign In" class="btn btn-success btn-sm" />
                <div class="remember-forgot">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" />
                                    Remember Me
                                </label>
                            </div>
                        </div>
                        <div class="col-md-6 forgot-pass-content">
                            <a href="javascript:void(0)" class="forgot-pass">Forgot Password</a>
                        </div>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>
   </div>
</body>