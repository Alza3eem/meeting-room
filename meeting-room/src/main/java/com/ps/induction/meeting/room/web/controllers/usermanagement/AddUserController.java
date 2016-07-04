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
import org.springframework.web.servlet.ModelAndView;

import com.ps.induction.meeting.room.domain.entity.Role;
import com.ps.induction.meeting.room.domain.entity.User;
import com.ps.induction.meeting.room.facade.RoleFacade;
import com.ps.induction.meeting.room.facade.UserFacade;
import com.ps.induction.meeting.room.web.forms.usermanagement.AddUserForm;

/**
 * 
 * @author Loai AlTamimi
 *
 */
@Controller
@RequestMapping("/adduser")
public class AddUserController {
	
	@Autowired
	private UserFacade userFacade;
	
	@Autowired
	private RoleFacade roleFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getdata() {
		
		List<Role> rolsLst = IterableUtils.toList(roleFacade.getAllRoles());

		ModelAndView model = new ModelAndView("/UsersManagement/AddUser");

		model.addObject("rolsLst", rolsLst);
		return model;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("addUserForm") AddUserForm form, Map<String, Object> model) {
		Role role = roleFacade.getRoleById(Long.parseLong(form.getRoleId()));
		
		User user = new User();
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
		user.setTitle(form.getTitle());
		user.setUsername(form.getUsername());
		user.setPassword(form.getPassword());
		user.setRole(role);
		
		userFacade.addUser(user);
		

		List<User> list = IterableUtils.toList(userFacade.getAllUsers());

		ModelAndView model2 = new ModelAndView("/UsersManagement/ListUsers");
		model2.addObject("userslst", list);
		

		return model2;
	}
}
