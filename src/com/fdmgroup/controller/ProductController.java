package com.fdmgroup.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.businessLogic.ProductBusinessLogin;
import com.fdmgroup.businessLogic.StoreBusinessLogin;
import com.fdmgroup.model.Product;

@Controller
public class ProductController {
	
	private ProductBusinessLogin productBusinessLogic;
	private StoreBusinessLogin storeBusinessLogic;
	@RequestMapping(value  = "/productList/{storeId}", method = RequestMethod.GET)
	public String listProductInformation(Model model, HttpServletRequest request, @PathVariable(value = "storeId") String storeId ) {
		storeBusinessLogic = new StoreBusinessLogin();
		List<Product> productList = storeBusinessLogic.productOfSelectedStore(storeId);
		
		model.addAttribute("storeId", storeId);
		
		if(productList.isEmpty()) {
			model.addAttribute("error", "you don't have any product in this store");
			
		}else
		{
			model.addAttribute("listOfProducts", productList);
		}
		return "UserProductPage";
	}
	
	@RequestMapping(value = "/addProduct/{storeId}", method = RequestMethod.POST)
	public String addProductToStore(Model model, HttpServletRequest request, @PathVariable(value = "storeId") String storeId,
			@RequestParam String createProductName,@RequestParam String createProductQuantity,@RequestParam String createProductPrice,
			@RequestParam String createDesc) {
		productBusinessLogic = new ProductBusinessLogin();		
		productBusinessLogic.insertProduct(createProductName, createProductPrice, createProductQuantity, createDesc	, storeId);
		return "redirect:/productList/"+storeId;
	}
	
	@RequestMapping(value = "/productUpdated/{storeId}", method = RequestMethod.POST)
	public String updateProduct(@RequestParam String productId,@PathVariable(value = "storeId") String storeId,
			@RequestParam String updateProductName,@RequestParam String updateProductQuantity,@RequestParam String updateProductPrice,
			@RequestParam String updateCreateDesc) {
		productBusinessLogic = new ProductBusinessLogin();
		productBusinessLogic.updateProductInformation(updateProductName, updateProductPrice, updateProductQuantity, updateCreateDesc, productId);
		
		return "redirect:/productList/"+storeId;
		
	}
	
	@RequestMapping(value = "/deleteProduct/{storeId}/{productId}", method = RequestMethod.POST)
	public String deleteProductFromStore(@PathVariable(value = "storeId") String storeId, @PathVariable(value = "productId") String productId ) {
		productBusinessLogic = new ProductBusinessLogin();
		productBusinessLogic.deleteProductFromStore(storeId, productId);
		return "redirect:/productList/"+storeId;
		
	}
	@RequestMapping(value  = "userViewProductList/{storeId}", method = RequestMethod.GET)
	public String showProductOfStore(Model model, HttpServletRequest request, @PathVariable(value = "storeId") String storeId) {
		storeBusinessLogic = new StoreBusinessLogin();
		List<Product> productList = storeBusinessLogic.productOfSelectedStore(storeId);
		if(productList.isEmpty()) {
			model.addAttribute("error", "No product in this store");
			
		}else
		{
			model.addAttribute("listOfProducts", productList);
		}
		return "ProductPageView";
	}
}
