/**
 * 
 */
package com.ps.induction.meeting.room.web.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ps.induction.meeting.room.domain.entity.User;
import com.ps.induction.meeting.room.facade.UserFacade;
import com.ps.induction.meeting.room.web.forms.usermanagement.LoginForm;

/**
 * @author Loai AlTamimi
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserFacade userFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getdata() {

		ModelAndView model = new ModelAndView("/login");

		return model;

	}

	@RequestMapping(method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("loginForm") LoginForm form, Map<String, Object> model,HttpServletRequest request) {
		String username = form.getUsername();
		String password = form.getPassword();
		
		User user = userFacade.getUserByUsernameAndPassword(username, password);
		
		
		if(user != null){
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedUser", user);
			return "redirect:/listusers";
		}else{
			return "/login";
		}

	}
}
