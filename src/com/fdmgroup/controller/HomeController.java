package com.fdmgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String showHome() {
		return "HomePage";
	}
	
	@RequestMapping(value = "/Register")
	public String showRegisterPage() {
		return "RegisterPage";
	}
	
	@RequestMapping(value = "/Login")
	public String showLoginPage() {
		return "LoginPage";
	}
	
	
//	@RequestMapping(value = "/Stores")
//	public String showStorePage() {
//		return "StorePageView";
//	}
}
