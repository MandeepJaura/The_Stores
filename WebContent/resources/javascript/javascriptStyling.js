function openNav() {
document.getElementById("mySidenav").style.width = "250px";
document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

/* Set the width of the side navigation to 0 and the left margin of the page content to 0, and the background color of body to white */
function closeNav() {
document.getElementById("mySidenav").style.width = "0";
document.body.style.backgroundColor = "white";
}

function openUserFormDiv() {
document.getElementById("myUserFormDiv").style.width = "100%";
}

/* Set the width of the side navigation to 0 and the left margin of the page content to 0, and the background color of body to white */
function closeUserFormDiv() {
document.getElementById("myUserFormDiv").style.width = "0";
}

function showCreateStoreForm() {
document.getElementById("createStore").style.width = "50%";
document.body.style.backgroundColor = "rgba(255,255,0,0.4)";
}

/* Set the width of the side navigation to 0 and the left margin of the page content to 0, and the background color of body to white */
function closeStoreFormDiv() {
document.getElementById("createStore").style.width = "0";
document.body.style.backgroundColor = "white";
}

function showUpdateStoreForm() {
document.getElementById("updateStore").style.width = "50%";
document.body.style.backgroundColor = "rgba(255,255,0,0.4)";
}

/* Set the width of the side navigation to 0 and the left margin of the page content to 0, and the background color of body to white */
function closeStoreUpdateFormDiv() {
document.getElementById("updateStore").style.width = "0";
document.body.style.backgroundColor = "white";
}

function openCreateProductFormDiv(){
  document.getElementById("createProductInStore").style.width = "50%";
  document.getElementById("createProductInStore").style.height = "100%";
  document.body.style.backgroundColor = "white";
}

function closeProductCreateFormDiv() {
document.getElementById("createProductInStore").style.width = "0";
document.getElementById("createProductInStore").style.height = "0";
document.body.style.backgroundColor = "white";
}

function openUpdateProductFormDiv(){
  document.getElementById("updateProductInStore").style.width = "50%";
  document.getElementById("updateProductInStore").style.height = "100%";
  document.body.style.backgroundColor = "white";
}

function closeProductUpdateFormDiv() {
document.getElementById("updateProductInStore").style.width = "0";
document.getElementById("updateProductInStore").style.height = "0";
document.body.style.backgroundColor = "white";
}

function ChangeStore(ref)
{
	var e = document.getElementById("search_categories");
	var name = e.options[e.selectedIndex].getAttribute('name');
	var addr = e.options[e.selectedIndex].getAttribute('addr');
	
	document.getElementById("updateStoreName").value = name;
	document.getElementById("updateStoreAddress").value = addr;
	
}

function ChangeProduct(ref){
	var e = document.getElementById("search_categories1");
	var name = e.options[e.selectedIndex].getAttribute('name');
	var desc = e.options[e.selectedIndex].getAttribute('desc');
	var quantity = e.options[e.selectedIndex].getAttribute('quantity');
	var price = e.options[e.selectedIndex].getAttribute('price');
	
	document.getElementById("updateProductName").value = name;
	document.getElementById("updateCreateDesc").value = desc;
	document.getElementById("updateProductQuantity").value = quantity;
	document.getElementById("updateProductPrice").value = price;
	
}

function myFunction(){
  var input = document.getElementById("Search");
  var filter = input.value.toLowerCase();
  var nodes = document.getElementsByClassName('stores');

  for (i = 0; i < nodes.length; i++) {
    if (nodes[i].innerText.toLowerCase().includes(filter)) {
      nodes[i].style.display = "block";
    } else {
      nodes[i].style.display = "none";
    }
  }
}

function myProduct(){
	var input = document.getElementById("SearchForProduct");
	  var filter = input.value.toLowerCase();
	  var nodes = document.getElementsByClassName('product');

	  for (i = 0; i < nodes.length; i++) {
	    if (nodes[i].innerText.toLowerCase().includes(filter)) {
	      nodes[i].style.display = "block";
	    } else {
	      nodes[i].style.display = "none";
	    }
	  }
	}
	  
	  function mySearch(){
			 var input = document.getElementById('SearchForProduct2');
			  var filter = input.value.toLowerCase();
			  var nodes = document.getElementsByClassName('productForClient');

			  for (i = 0; i < nodes.length; i++) {
			    if (nodes[i].innerText.toLowerCase().includes(filter)) {
			      nodes[i].style.display = "block";
			    } else {
			      nodes[i].style.display = "none";
			    }
			  }
	  		}		
