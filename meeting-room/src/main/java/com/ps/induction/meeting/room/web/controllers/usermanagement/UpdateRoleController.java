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

import com.ps.induction.meeting.room.domain.entity.Function;
import com.ps.induction.meeting.room.domain.entity.Role;
import com.ps.induction.meeting.room.facade.FunctionFacade;
import com.ps.induction.meeting.room.facade.RoleFacade;
import com.ps.induction.meeting.room.web.forms.usermanagement.AddRoleForm;

/**
 * 
 * @author Loai AlTamimi
 *
 */
@Controller
@RequestMapping("/updaterole")
public class UpdateRoleController {

	
	
	@Autowired
	private RoleFacade roleFacade;
	
	@Autowired
	private FunctionFacade functionFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getdata(@RequestParam String id) {

		Role updateRole = roleFacade.getRoleById(Long.parseLong(id));
		Function updateRoleFunc = functionFacade.getFunctionById(Long.parseLong(id));
		List<Function> allFunction = IterableUtils.toList(functionFacade.getAllFunctions());

		ModelAndView model = new ModelAndView("/UsersManagement/UpdateRole");
//		allFunction.removeAll(updateRoleFunc);
		model.addObject("updateRole", updateRole);
		model.addObject("updateRoleFunc", updateRoleFunc);
		model.addObject("allFunc", allFunction);

		return model;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("addRoleForm") AddRoleForm form, @RequestParam String id,
			Map<String, Object> model) {

		Role role = new Role();
		role.setRoleId(Long.parseLong(id));
		role.setRoleName(form.getRoleName());
		roleFacade.addRole(role);

		List<Role> list = IterableUtils.toList(roleFacade.getAllRoles());

		// return back to index.jsp
		ModelAndView model2 = new ModelAndView("/UsersManagement/ListRoles");
		model2.addObject("rolelst", list);

		return model2;
	}

}
