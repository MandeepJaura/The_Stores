package com.fdmgroup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import com.fdmgroup.businessLogic.UserBusinessLogic;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.jpaDao.UserJpaDao;
import com.fdmgroup.model.User;

@Controller
public class AuthenticationController {
		
	private IUserDao userDao;
	private UserBusinessLogic userBusinessLogic;
	@RequestMapping(value = "/userLogin")
	public String processLogin(HttpServletRequest request, @RequestParam String userName, @RequestParam String userPassword) {
		userBusinessLogic = new UserBusinessLogic();
		HttpSession session = request.getSession();
		System.out.println(userName + " " + userPassword +"from controller");
		User user=null;
		try {
			 user = userBusinessLogic.doLogin(userName, userPassword);
			}catch(IllegalArgumentException e) {
				request.setAttribute("error", e.getMessage());
				return "/LoginPage";
			}
		String uName = user.getUserName();
		session.setAttribute("loggInUser", user);
		session.setAttribute("name", uName);
		System.out.println("Log in");
		return "redirect:/UserStorePage";		
	}
	
	@RequestMapping(value = "/updateUserInfo")
	public String userInformationUpdate(HttpServletRequest request,Model model, @RequestParam String oldPassword, @RequestParam String newPassword,@RequestParam String email) {
		System.out.println("userDetails");
		userDao = new UserJpaDao();
		User user = (User) request.getSession().getAttribute("loggInUser");
		System.out.println(user.getUserName()+" Password"+user.getPassword() + " old" + oldPassword );
		if(user != null && user.getPassword().equals(oldPassword)) {
			userDao.update(user.getUserName(), oldPassword, newPassword, email);
			model.addAttribute("userInfo", "Password is Updated");
			return "redirect:/UserStorePage";
		}
		return "redirect:/UserStorePage";
	}
	
	@RequestMapping(value = "/RegisterUser")
	public String insertUser(HttpServletRequest request,Model model, @RequestParam String userName, @RequestParam String userPassword,@RequestParam String userEmail) {		
		userDao = new UserJpaDao();
		User user = new User().setUserName(userName).setPassword(userPassword).setEmail(userEmail);
		if(userDao.create(user) != false ) {
			model.addAttribute("RegisterConfirmation", "Registeration is completed");
			return "redirect:/Login";
		}else {
			model.addAttribute("RegisterConfirmation", "Registeration is not completed");
			return "RegisterPage";
		}
	}
	
	@RequestMapping(value="/logout")
	  public String logout(HttpSession session, SessionStatus sessionStatus, Model model) {
		model.asMap().clear();
	    session.invalidate();
	    sessionStatus.setComplete();
	    return "redirect:/";
	  }
}
