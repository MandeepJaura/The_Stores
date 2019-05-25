<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
    
  </head>
  <body>

    <%@include file= "TopNavigationBar.jsp" %>

    <div class="mainHeader">
        <div class="LoginHeader"> </div>
        <div class="formDiv">
          <div class="formDivLeftSide" class= "panel">

            <div class="imageOverDiv">
              <h1>Welcome Back to The Stores</h1>
              <p>Sign in to continue to your account</p>
            </div>

            <div class = "imageDiv">
              <img src="resources/images/w3.jpg" alt="logIn" id= "logInId">
            </div>

          </div>

          <div class="formDivRightSide" class= "panel">
            <div class="spacing"></div>
            
              <form class="form" action="userLogin" method="post">
                <label class = "label">
                  <input class = "input" name = "userName" type="text" style="border-bottom: 2px solid #659dbd" required >
                    <div class="label-text">User Name</div>
                  </label>

                  <label class = "label">
                    <input class = "input" name = "userPassword" type="password"  style="border-bottom: 2px solid #659dbd" required>
                      <div class="label-text">Password</div>
                    </label>
                    <input type = "submit" value="Submit" class = "button"></input>
                  </form>
                  <c:if test="${error != null }">
	                  <div class = "error">
		                  	<h3> ${ error }</h3>
		              </div>
                  </c:if>
	                  
                  <div class="spacing"></div>
                  <div class="spacing"></div>
            </div>
          </div>
    </div>
  </body>
</html>
