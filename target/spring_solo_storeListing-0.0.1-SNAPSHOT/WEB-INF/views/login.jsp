<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="utf-8">
  <title>Mega Malls</title>
    <link rel="stylesheet" type="text/css" href="resources/css/styleSheet.css">

    <script
src="https://code.jquery.com/jquery-3.1.1.min.js"
integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
crossorigin="anonymous"></script>
<script type="text/javascript" src="resources/javascript/jsFiles.js"></script>
</head>
<body>


  <nav id="navigation2">
    <ul>
      <li><a href="#registerPart">Register</a></li>
      <li><a href="<%= request.getContextPath() %>/userStores">Stores</a></li>
      <li><a href="#">Products</a></li>
      <li><a href="#">Login</a></li>
      <li><a href="#Header">Home</a></li>
    </ul>
  </nav>

<div class="mainHeader">
    <div class="LoginHeader"> </div>
    <div class="formDiv">
      <div class="formDivLeftSide" class= "panel">

        <div class="imageOverDiv">
          <h1>Welcome Back to Mega Malls</h1>
          <p>Sign in to continue to your account</p>
        </div>

        <div class = "imageDiv">
          <img src="resources/images/w3.jpg" alt="logIn" id= "logInId">
        </div>

      </div>

      <div class="formDivRightSide" class= "panel">
        <div class="spacing"></div>
          <form class="userLogin" action = "login" method="POST">
            <label>
              <input type="text" name = "userName" style="border-bottom: 2px solid #659dbd" required >
                <div class="label-text">User Name</div>
              </label>

              <label>
                <input type="password" name = "userPassword" style="border-bottom: 2px solid #659dbd" required>
                  <div class="label-text">Password</div>
              </label>
                 <input type = "submit" value="Submit" class = "button"></input>
              </form>
              <div class="spacing"></div>
              <div class="spacing"></div>
          </div>
        </div>
        <div class="footer"></div>
</div>

  </body>
</html>
