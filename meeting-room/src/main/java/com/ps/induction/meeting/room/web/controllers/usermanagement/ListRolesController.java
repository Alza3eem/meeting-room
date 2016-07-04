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

import com.ps.induction.meeting.room.domain.entity.Role;
import com.ps.induction.meeting.room.facade.RoleFacade;

/**
 * 
 * @author Loai AlTamimi
 *
 */
@Controller
@RequestMapping("/listrole")
public class ListRolesController {
	
	@Autowired
	private RoleFacade roleFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getdata() {

		List<Role> list = IterableUtils.toList(roleFacade.getAllRoles());

		// return back to index.jsp
		ModelAndView model = new ModelAndView("/UsersManagement/ListRoles");
		model.addObject("rolelst", list);

		return model;

	}

}
