<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="css/payment-form.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <center> <h2><a href="index.jsp" >Home</a></h2></center>

<center><h1 style="color:green"> You have to pay  $ <%= request.getParameter("Id") %> for this particular Product</h1> </center>
<%= request.getParameter("Id1") %>


 <form method="post" action="BuyProduct_Process">
        <h1>Payment form</h1>
        <p>Required fields are followed by <strong><abbr title="required">*</abbr></strong>.</p>
        <section>
            <h2>Contact information</h2>
            <fieldset>
              <legend>Title</legend>
              <ul>
                  <li>
                    <label for="title_1">
                      <input type="radio" id="title_1" name="title" value="M." >
                      Mister
                    </label>
                  </li>
                  <li>
                    <label for="title_2">
                      <input type="radio" id="title_2" name="title" value="Ms.">
                      Miss
                    </label>
                  </li>
              </ul>
            </fieldset>
            <p>
              <label for="name">
                <span>Name: </span>
                <strong><abbr title="required">*</abbr></strong>
              </label>
              <input type="text" id="name" name="username">
            </p>
            <p>
              <label for="mail">
                <span>E-mail: </span>
                <strong><abbr title="required">*</abbr></strong>
              </label>
              <input type="email" id="mail" name="usermail">
            </p>
            <p>
              <label for="pwd">
                <span>Password: </span>
                <strong><abbr title="required">*</abbr></strong>
              </label>
              <input type="password" id="pwd" name="password">
            </p>
        </section>
        <section>
            <h2>Payment information</h2>
            <p>
              <label for="card">
                <span>Card type:</span>
              </label>
              <select id="card" name="usercard">
                <option value="visa">Visa</option>
                <option value="amexx">DBBL</option>
                <option value="amex">BKash</option>
                <option value="mc">Mastercard</option>
                <option value="amex">American Express</option>
              </select>
            </p>
            <p>
              <label for="number">
                <span>Account number:</span>
                <strong><abbr title="required">*</abbr></strong>
              </label>
                <input type="text" id="number" name="cardnumber">
            </p>
            <p>
              <label for="date">
                <span>Expiration date:</span>
                <strong><abbr title="required">*</abbr></strong>
               
              </label>
              <input type="Date" id="date" name="expiration">
            </p>
        </section>
        <section>
         <input type="hidden" value=<%=request.getParameter("Id1") %> name="Id" />
            <p> <button type="submit">Validate the payment</button> </p>
        </section>
    </form>
</body>
</html>