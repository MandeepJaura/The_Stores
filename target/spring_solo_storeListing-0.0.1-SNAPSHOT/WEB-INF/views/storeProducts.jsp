<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${ error }</h1>

 <div id = "createProductDiv">
	        <form action = "${storeId}/insertProduct" method = "POST">
	        Product Name:<br>
	        <input type = "text"  name = "createProductName" >
	        <br>
	        Product Description:<br>
	         <textarea name="createDesc" rows="10" cols="30">
	         <br>
	         Quantity:<br>
	         <input type = "text"  name = "createProductQuantity" >
	         <br>
	         Price:<br>
	         <input type = "text"  name = "createProductPrice" >
	         <br>
	          <br><br>
	          <input type = "submit" value= "submit">
	        </form>
        </div>
        
<button>Delete</button>
<button>Update</button>
<table>
<tr>
<th>Product Name</th>
<th>Product Description</th>
<th>Product Quantity</th>
<th>Product Price</th>
<th>Product Added date</th>


</tr>
		
		<c:forEach items="${ listOfProducts }" var="productList">
    	<tr>
    		<td>${productList.name }</td>
			<td>${productList.description}</td>
    		<td>${productList.quantity}</td>
    		<td>${productList.price}</td>
    		<td>${productList.dateTime}</td>
    		
    	</tr>
    	</c:forEach>
    	
</table>
<a href = "<%= request.getContextPath() %>/stores" class = "button">Back</a>
</body>
</html>