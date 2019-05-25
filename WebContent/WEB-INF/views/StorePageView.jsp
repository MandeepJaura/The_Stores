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
	<%@include file= "TopNavigationBar.jsp" %>
	<div class="storesMainDivForClient">
        <div class="storeInsideDivForClient">
        <c:forEach items="${ allStores }" var="storeList">
          <div class="clientStoreView">
            <h1>${storeList.storeName}</h1>
            <h3>Address: ${storeList.storeAddress}</h3>
            <h3>Last Updated: ${storeList.storeStartDate}</h3>
            <h3>Total Product: ${storeList.product.size()} </h3>
            <a class ="ViewButtonForClient" href="${ pageContext.request.contextPath }/userViewProductList/${storeList.storeId}" >View</a>          
           </div>
         </c:forEach>
        </div>
     </div>
</body>
</html>