<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.fdmgroup.model.User"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/resources/css/stylesForPages.css">

    <script type="text/javascript" src="${ pageContext.request.contextPath }/resources/javascript/javascriptStyling.js"></script>
  </head>
  <body>

    <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a> 
        <% User user = (User) request.getSession().getAttribute("loggInUser");
        
        if(user != null){%>
        <a href="${ pageContext.request.contextPath }/">Home</a>
        <a href="${ pageContext.request.contextPath }/UserStorePage">Stores</a>	
        <a href="${ pageContext.request.contextPath }/logout">Logout</a>
        <%}else{ %>
        <a href="${ pageContext.request.contextPath }/">Home</a>
        <a href="${ pageContext.request.contextPath }/Stores">Stores</a>
        <a href="${ pageContext.request.contextPath }/Register">Register</a>
        <a href="${ pageContext.request.contextPath }/Login">Login</a>
        <%} %>
    </div>

    <div id="myUserFormDiv" class="userForm">
        <a href="javascript:void(0)" class="closebtn" onclick="closeUserFormDiv()">&times;</a>
        <div id="userUpdateFormDiv">
          <h1 align= "center">Update User details</h1>
          <form class="" action="updateUserInfo" method="post">
              <input type="password" id="oPass" align = "right" name="oldPassword" placeholder="Old Password.." required>
              <input type="password" id="nPass" align = "right" name="newPassword" placeholder=" New Password.." required>
              <input type="email" id="eEmail" align = "right" name="email" placeholder="Your Email.." required>
              <input type="submit" name="" value="Update" class= "updateButtonForUser">
          </form>
        </div>
    </div>

    <div class="navaigationbar">
      <span onclick="openNav()">&#9776; Menu</span>
      <%if(user != null){ %>
        <div id = "userNameDiv"  onclick = "openUserFormDiv()"><i class="material-icons" style="font-size:48px;color:#333">account_box</i>
            <h1 id = "userName">${ name }</h1>
        </div>
        <%} %>
    </div>

</body>
</html>