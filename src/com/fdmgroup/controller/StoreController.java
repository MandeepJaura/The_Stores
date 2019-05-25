package com.fdmgroup.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.fdmgroup.businessLogic.StoreBusinessLogin;
import com.fdmgroup.model.Store;
import com.fdmgroup.model.User;

@Controller
public class StoreController {

	private StoreBusinessLogin storeBusinessLogic;
	@RequestMapping(value = "/UserStorePage", method = RequestMethod.GET)
	public void allStores(Model model, HttpServletRequest request ) {
		User user = (User) request.getSession().getAttribute("loggInUser");
		storeBusinessLogic = new StoreBusinessLogin();
		List<Store> storeList  = storeBusinessLogic.getStoresOfLoggedInUser(user);
		model.addAttribute("listOfStores",storeList);
	}
	
	@RequestMapping(value = "/storeCreated", method = RequestMethod.POST)
	public String insertStore(Model model, HttpServletRequest request,@RequestParam String createStoreName, @RequestParam String createStoreAddress) {
		User user = (User) request.getSession().getAttribute("loggInUser");
		if(storeBusinessLogic.insertStore(createStoreName, createStoreAddress, user  ) == true) {
//			model.addAttribute("storeCreated", "congratulation, your store is created!");
			System.out.println("Created");
			
			return "redirect:/UserStorePage";
		}
		else {
//			model.addAttribute("storeCreated", "Failed to create the store");
			System.out.println("Not created");
		}
		return "redirect:/stores";
	}
	
	@RequestMapping(value = "/storeUpdated", method = RequestMethod.POST)
	public String updateStoreInformation(Model model, HttpServletRequest request,@RequestParam String updateStoreName, @RequestParam String updateStoreAddress, @RequestParam String storeId ) {
		storeBusinessLogic.updateStoreInformation(storeId, updateStoreName, updateStoreAddress);
		return "redirect:/UserStorePage";
	}
	
	@RequestMapping(value = "/Stores", method = RequestMethod.GET)
	public String showAllStoresToUser(Model model, HttpServletRequest request ) {
		storeBusinessLogic = new StoreBusinessLogin();
		
		List<Store> allStore = storeBusinessLogic.allStoresForUser();
		System.out.println(allStore);
		model.addAttribute("allStores", allStore);
		return "StorePageView";
	}
}
