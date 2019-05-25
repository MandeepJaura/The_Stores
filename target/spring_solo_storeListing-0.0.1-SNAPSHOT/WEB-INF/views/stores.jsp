
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
<script>
function ChangeStore(ref)
{
	var opt=$(ref).find('option:selected');
	$('#updateStoreName').val($(opt).attr('name'));
	$("input[name='updateStoreAddress']").val($(opt).attr('addr'));
}
</script>
<style type="text/css">

#UserDiv{display:none;}
#UpDateStoreDiv{display:none;}
#createStoreDiv{display:none;}
</style>


</head>
<body>


  <nav id="navigation2">
    <ul id = "nav-ul">
      <li class= "nav-li"><a class = "nav-li-a" href="#registerPart">Register</a></li>
      <li class= "nav-li"><a class = "nav-li-a" href="<%= request.getContextPath() %>/stores.jsp">Stores</a></li>
      <li class= "nav-li"><a  class = "nav-li-a" href="#">Products</a></li>
      <li class= "nav-li"><a  class = "nav-li-a" href="#">Login</a></li>
      <li class= "nav-li"><a  class = "nav-li-a" href="#Header">Home</a></li>
    </ul>
  </nav>

  <div class="storesForUserMainDiv">

    <div class="sfuMainDivLeft">
      <div class="userAndStoreInformation">
        <h1>User Name = Manav</h1>
        <h1>You are owner of 5 stores</h1>
        <h1>${ storeCreated }</h1>
        <!-- Div for Updating user and stores -->
        
        <button n="UserDiv" id = "user" class= "button">Update User</button>
        <button n="createStoreDiv" id = "addStore" class= "button">Create Store</button>
        <button n="UpDateStoreDiv" id = "updateStore" class= "button">Update Store</button>
    
        
        <div class= "updateDiv">
        
        <div id = "UserDiv">
        <form action = "">
        Old Password:<br>
        <input type = "text"  name = "Old" value="">
        <br>
        New Password:<br>
         <input type = "text" name = "new" value="">
         <br><br>
          <input type = "submit" value= "submit">
        </form>
        </div>
        
        
        <div id = "createStoreDiv">
        <form action = "storeCreated" method = "POST">
        Store Name:<br>
        <input type = "text"  name = "createStoreName" >
        <br>
        Store Address:<br>
         <input type = "text" name = "createStoreAddress" >
         <br><br>
          <input type = "submit" value= "submit">
        </form>
        </div>
        
        <div id = "UpDateStoreDiv">
        
        <form action = "storeUpdated" method ="POST">
 
        
        
        
        Store Id:
         <select name = "storeId" onchange="ChangeStore(this)">
         	<option value = "default" selected>Please select ID</option>
	         <c:forEach items="${ listOfStores }" var="storeList">
	         	
	       		 <option value = ${storeList.storeId } addr = '${storeList.storeAddress }' name = '${storeList.storeName }'> ${storeList.storeId }</option>
	         </c:forEach>
        </select>
        <br>
       
        Store Name:<br>
        <input type = "text" id="updateStoreName" name = "updateStoreName" value="">
        <br>
        Store Address:<br>
         <input type = "text" name = "updateStoreAddress" value="">
         <br><br>
          <input type = "submit" value= "submit">
          </form>
          
        </div>
        
        </div>
      </div>
    </div>
	
    <div class="sfuMainDivRight">
    
    <table>
    	<tr>
    	<th>Store Id</th>
    		<th>Store Name</th>
    		<th>Store Address</th>
    		<th>Store Start Date</th>
    	</tr>
    	
    	<c:forEach items="${ listOfStores }" var="storeList">
    	<tr>
    		<td>${storeList.storeId }</td>
			<td>${storeList.storeName}</td>
    		<td>${storeList.storeAddress}</td>
    		<td>${storeList.storeStartDate}</td>
    		<td><a href = "<%= request.getContextPath() %>/productList/${storeList.storeId }" >View Product</a></td>
    	</tr>
    	</c:forEach>
    	
    	
    </table>
    

    </div>

  </div>
</body>
</html>
