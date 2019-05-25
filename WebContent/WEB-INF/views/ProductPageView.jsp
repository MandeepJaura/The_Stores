<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${ pageContext.request.contextPath }/resources/javascript/javascriptStyling.js"></script>
</head>
<body>
<%@include file= "TopNavigationBar.jsp" %>
	<div id="miniHeaderBar">
      <div id="miniHeaderButtons">
        <input type="text" id="SearchForProduct2" class = "searchBar" onkeyup="mySearch()" placeholder="Please enter a search term.." >
      </div>
    </div>
	<div class="productMainDiv">
	 <div id = "productListViewForClient">
      <c:forEach items="${ listOfProducts }" var="productList">
	      <div class="productForClient">
	        <h1>Name: ${productList.name } </h1>
	        <h3>Price: ${productList.price}</h3>
	        <h3>Quantity: ${productList.quantity}</h3>
	        <h3>Added date: ${productList.dateTime} </h3>
	        <h3>Product id: ${productList.productId } </h3>
	        <p>Description</p>
	        <textarea readonly name="name" rows="4" cols="40">${productList.description}</textarea>
	      </div>
      </c:forEach>
      </div>
     </div>
</body>
</html>