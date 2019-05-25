<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   <link rel="stylesheet" type="text/css" href="resources/css/stylesForPages.css">

    <script type="text/javascript" src="resources/javascript/javascriptStyling.js"></script>
  </head>
  <body>

    <%@include file= "TopNavigationBar.jsp" %>

    <div id="registerPart">
        <div id="register-me-form">
          <article id="register-me-article">
            <p>If you want to collaborate on crafting amazing experience
                           for people to find out your products  you are very welcome to Register.</p>
                <h1>The Stores</h1>
                  <p>Please fill all details for successfull Registeration</p>
                  <p>${RegisterConfirmation}</p>
                  <div class="spacing">

                  </div>
                    <form class="form" action="RegisterUser" method="post">
                        <label class = "label">
                          <input class = "input" type="text" name = "userName" required>
                            <div class="label-text">User Name</div>
                          </label>

                          <label class = "label">
                            <input class = "input" type="password" name = "userPassword" required>
                              <div class="label-text">Password</div>
                          </label>

                          <label class = "label">
                            <input class = "input" type="email" name = "userEmail" required>
                              <div class="label-text">Email</div>
                          </label>

                            <input type = "submit" value="Submit" class = "button"></input>
                      </form>
                </article>
              </div>

              <div id="register-me-text">
                <article id="register-article">
                    <h1>Get in touch</h1>
                      <p>Yup, We are able to manage your different stores and products
                              efficently. We will provide you free access to create, delete and update your
                              stuff.<br/> Work with our user friendly interface and enjoy while while working on it.
                              We are sure, you will like it<br/>We are excitingly waiting for you to register with us
                            and open new doors to enhance your sales
                      </p>
                  </article>
                </div>
              </div>

  </body>
</html>
