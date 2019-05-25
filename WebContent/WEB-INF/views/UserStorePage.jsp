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
    <div id="storeMaindiv">

      <div id="createStore" class="createStoreForm">
          <a href="javascript:void(0)" class="closebtn" onclick="closeStoreFormDiv()">&times;</a>
          <div id="storeCreateFormDiv">
            <h1 align= "center">Please Enter Store Details</h1>
            <form class="" action="storeCreated" method="post">
                <input type="text" id="createStoreName" style = "border-bottom: 2px solid #333" align = "right" name = "createStoreName" placeholder="Store Name.." required >
                <input type="text" id="createStoreAddress" style = "border-bottom: 2px solid #333" align = "right" name = "createStoreAddress" placeholder=" Address.." required >
                <input type="submit" name="" value="Create" class= "ButtonForStore">
            </form>
          </div>
      </div>

      <div id="updateStore" class="updateStoreForm">
          <a href="javascript:void(0)" class="closebtn" onclick="closeStoreUpdateFormDiv()">&times;</a>
          <div id="storeUpdateFormDiv">
            <h1 align= "center">Update Store details</h1>
            <form id="updateStoreForm" action="storeUpdated" method="post">
            	<div class="search_categories">
                	<div class="select">
                   		<select name = "storeId"  onchange="ChangeStore(this)" id="search_categories">
                      		<option value = "default" selected>Please select ID</option>
	         			<c:forEach items="${ listOfStores }" var="storeList">
	         				<option value = ${storeList.storeId } addr = '${storeList.storeAddress }' name = '${storeList.storeName }'> ${storeList.storeId }</option>
	        		 	</c:forEach>
                     	</select>
                	 </div>
               </div>
              <input type="text" id="updateStoreName" style = "border-bottom: 2px solid #333" align = "right" name="updateStoreName" placeholder="Store Name.." value = "" required >
              <input type="text" id="updateStoreAddress" style = "border-bottom: 2px solid #333" align = "right" name="updateStoreAddress" placeholder=" Address.." value = ""  required>
                <input type="submit" name="" value="Update" class= "ButtonForStore">
            </form>
          </div>
      </div>

        <div id ="storeDetailDiv">
          <h1 id = "StoreHeading">The Stores</h1>
          <h2 id = "welcomeNote">Welcome to your Home</h2>
          <p id = "welcomePara">You are currently owner of <Strong>${ listOfStores.size() } </Strong>stores<br> These store are working hard for you
          Keep working hard to build your stores<br> and update them in proper manner so that<br>
        your clients stay updated in regards to your product</p>
          <a id ="createButton" href="#" onclick ="showCreateStoreForm()">Create Store</a>
          <a id = "updateButton" href="#" onclick ="showUpdateStoreForm()">Update Store</a>
        </div>
        <div id="storeListing">
          <div class="spacing"></div>
          <div id = "fixedSearchBare">
	          <div id="serachBox">
	            <span>&#128270;</span>
	            <input type="text" id="Search" onkeyup="myFunction()" placeholder="Please enter a search term.." >
	          </div>
		  </div>
		<div id = "storeContainingDiv">
		<c:forEach items="${ listOfStores }" var="storeList">
          <div class="stores">
            <h1>Name: ${storeList.storeName}</h1>
            <h3>Store No: ${storeList.storeId }</h3>
            <h3>Address: ${storeList.storeAddress}</h3>
            <h3>Last Updated: ${storeList.storeStartDate}</h3>
            <h3>Total Product: ${storeList.product.size()} </h3>
            <a id ="ViewButton" href="${ pageContext.request.contextPath }/productList/${storeList.storeId }" >View</a>
          </div>
		</c:forEach>
		</div>
    </div>


    </body>
  </html>
