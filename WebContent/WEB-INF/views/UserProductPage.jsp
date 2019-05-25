<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
    <%@include file= "TopNavigationBar.jsp" %>
    <div id="createProductInStore" class="createProductForm">
        <a href="javascript:void(0)" class="closebtn" onclick="closeProductCreateFormDiv()">&times;</a>
        <div id="storeProductFormDiv">
          <h1 align= "center">Please enter product details</h1>
          <div class="productFormDiv">
              <form class="" action="${ pageContext.request.contextPath }/addProduct/${storeId}" method="post">
                <input type="text" class = "createProductInput" id="createProductName" style = "border-bottom: 2px solid #333" align = "right" name="createProductName" placeholder="Product Name.." required >
            	<textarea name="createDesc" rows="4" cols="40" placeholder= "Please add Prdouct Details" required></textarea>
                <input type="number" class = "createProductInput" id="createProductQuantity" style = "border-bottom: 2px solid #333" align = "right" name="createProductQuantity" min = "1" max = "10000" placeholder=" Quantity.." required>
                <input type="number" class = "createProductInput" id="createProductPrice" style = "border-bottom: 2px solid #333" align = "right" name="createProductPrice" min = "1" placeholder=" Price.." required>
                  <input type="submit" name="" value="CREATE" class= "ButtonForStore">
              </form>
            </div>
        </div>
    </div>

    <div id="updateProductInStore" class="updateProductForm">
        <a href="javascript:void(0)" class="closebtn" onclick="closeProductUpdateFormDiv()">&times;</a>
        <div id="storeProductFormDiv">
          <h1 align= "center">Please enter product details</h1>
          <div class="productFormDiv">
              <form class="" action="${ pageContext.request.contextPath }/productUpdated/${storeId}" method="post">
              	<div class="search_categories">
                	<div class="select">
                   		<select name = "productId"  onchange ="ChangeProduct(this)" id="search_categories1">
                      		<option value = "default" selected>Please select ID</option>
	         			<c:forEach items="${ listOfProducts }" var="productList">
	         				<option value = ${productList.productId } price= '${productList.price}' quantity= '${productList.quantity}' desc = '${productList.description }' name = '${productList.name }'> ${productList.productId }</option>
	        		 	</c:forEach>
                     	</select>
                	 </div>
               </div>
                <input type="text" class = "createProductInput" id="updateProductName" style = "border-bottom: 2px solid #333" align = "right" name="updateProductName" placeholder="Product Name.." >
            	<textarea name="updateCreateDesc" id ="updateCreateDesc" rows="4" cols="40" placeholder= "Please add Prdouct Details"></textarea>
                <input type="number" class = "createProductInput" id="updateProductQuantity" style = "border-bottom: 2px solid #333" align = "right" name="updateProductQuantity" min= "1" max= "100000" placeholder=" Quantity.." required >
                <input type="number" class = "createProductInput" id="updateProductPrice" style = "border-bottom: 2px solid #333" align = "right" name="updateProductPrice" placeholder=" Price.." min = "1" >
                <input type="submit" name="" value="UPDATE" class= "ButtonForStore">
              </form>
            </div>
        </div>
    </div>


    <div id="miniHeaderBar">
      <div id="miniHeaderButtons">
        <input type="submit" name="" value="Create" onclick = "openCreateProductFormDiv()" class = "productButtons" id= "createProductButton">
        <input type="submit" name="" value="Update" onclick = "openUpdateProductFormDiv()" class = "productButtons" id= "updateProductButton">
        <input type="text" id="SearchForProduct" onkeyup="myProduct()" placeholder="Please enter a search term.." >
      </div>
    </div>

    <div class="productMainDiv">
     <div class = "productListing">
	<c:forEach items="${ listOfProducts }" var="productList">
      <div class="product">
        <h1>Name: ${productList.name } </h1>
        <h3>Price: ${productList.price}</h3>
        <h3>Quantity: ${productList.quantity}</h3>
        <h3>Added date: ${productList.dateTime} </h3>
        <h3>Product id: ${productList.productId } </h3>
        <p>Description</p>
        <textarea readonly name="name" rows="4" cols="40">${productList.description}</textarea>
        <form action="${ pageContext.request.contextPath }/deleteProduct/${storeId}/${productList.productId }" method="post">
    		<input type="submit" value="Delete" class= "deleteButton"/>
		</form>
      </div>
	</c:forEach>
        </div>
      </div>

  </body>
</html>
