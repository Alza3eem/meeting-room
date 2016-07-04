/**
 * 
 */
package com.ps.induction.meeting.room.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Loai AlTamimi
 *
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getdata(HttpServletRequest request) {

		request.getSession().invalidate();
		ModelAndView model = new ModelAndView("/login");

		return model;

	}

}
