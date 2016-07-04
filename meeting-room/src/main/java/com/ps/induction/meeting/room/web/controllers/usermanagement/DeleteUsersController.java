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

import com.ps.induction.meeting.room.domain.entity.User;
import com.ps.induction.meeting.room.facade.UserFacade;
import com.ps.induction.meeting.room.web.forms.usermanagement.DeleteUserForm;

/**
 * 
 * @author Loai AlTamimi
 *
 */
@Controller
@RequestMapping("/deleteuser")
public class DeleteUsersController {
	@Autowired
	private UserFacade userFacade;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView deleteUser(@ModelAttribute("deleteUserForm") DeleteUserForm form, Map<String, Object> model) {
		String userId = form.getId();

		userFacade.removeUserById(Long.parseLong(userId));

		List<User> list = IterableUtils.toList(userFacade.getAllUsers());

		ModelAndView model2 = new ModelAndView("/UsersManagement/ListUsers");
		model2.addObject("userslst", list);

		return model2;
	}
}
