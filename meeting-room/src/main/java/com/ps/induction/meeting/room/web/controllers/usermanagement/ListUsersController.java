/**
 * 
 */
package com.ps.induction.meeting.room.web.controllers.usermanagement;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ps.induction.meeting.room.domain.entity.User;
import com.ps.induction.meeting.room.facade.UserFacade;

/**
 * 
 * @author Loai AlTamimi
 *
 */
@Controller
@RequestMapping("/listusers")
public class ListUsersController {
	
	@Autowired
	private UserFacade userFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getdata() {

		List<User> list = IterableUtils.toList(userFacade.getAllUsers());

		// return back to index.jsp
		ModelAndView model = new ModelAndView("/UsersManagement/ListUsers");
		model.addObject("userslst", list);

		return model;

	}

}
