/**
 * 
 */
package com.ps.induction.meeting.room.web.controllers.usermanagement;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ps.induction.meeting.room.domain.entity.User;
import com.ps.induction.meeting.room.facade.UserFacade;
import com.ps.induction.meeting.room.web.forms.usermanagement.AddUserForm;

/**
 * 
 * @author Loai AlTamimi
 *
 */
@Controller
@RequestMapping("/updateuser")
public class UpdateUsersController {
	
	@Autowired
	private UserFacade userFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getdata(@RequestParam String id) {
		
		User updateUser = userFacade.getUserById(Long.parseLong(id));

		ModelAndView model = new ModelAndView("/UsersManagement/UpdateUser");
		
		model.addObject("updateUser", updateUser);
		
		return model;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("addUserForm") AddUserForm form, @RequestParam String id , Map<String, Object> model) {
		
		User userBeforeUpdate = userFacade.getUserById(Long.parseLong(id));
		
		userBeforeUpdate.setFirstName(form.getFirstName());
		userBeforeUpdate.setLastName(form.getLastName());
		userBeforeUpdate.setTitle(form.getTitle());
		userBeforeUpdate.setUsername(form.getUsername());
		
		userFacade.addUser(userBeforeUpdate);
		

		List<User> list = IterableUtils.toList(userFacade.getAllUsers());

		ModelAndView model2 = new ModelAndView("/UsersManagement/ListUsers");
		model2.addObject("userslst", list);
		

		return model2;
	}
	
}
