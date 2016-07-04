/**
 * 
 */
package com.ps.induction.meeting.room.web.controllers.usermanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.ps.induction.meeting.room.domain.entity.Function;
import com.ps.induction.meeting.room.domain.entity.Role;
import com.ps.induction.meeting.room.domain.repository.FunctionRepository;
import com.ps.induction.meeting.room.domain.repository.RoleRepository;
import com.ps.induction.meeting.room.facade.FunctionFacade;
import com.ps.induction.meeting.room.facade.RoleFacade;
import com.ps.induction.meeting.room.web.forms.usermanagement.AddRoleForm;

/**
 * 
 * @author Loai AlTamimi
 *
 */
@Controller
@RequestMapping("/addrole")
public class AddRoleController {
	
	@Autowired
	private FunctionFacade functionFacade;
	
	@Autowired
	private RoleFacade roleFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getdata() {

		List<Function> list = IterableUtils.toList(functionFacade.getAllFunctions());

		// return back to index.jsp
		ModelAndView model = new ModelAndView("/UsersManagement/AddRole");

		model.addObject("funcslst", list);

		return model;

	}

	@RequestMapping(method = RequestMethod.POST)
	@Transactional
	public ModelAndView addFunction(@ModelAttribute("addRoleForm") AddRoleForm form, Map<String, Object> model) {
		String roleName = form.getRoleName();
		String[] functionsIds = form.getListt().split(",");
		Long[] functionsIdsLong = new Long[functionsIds.length];
		for (int i = 0; i < functionsIds.length; i++) {
			functionsIdsLong[i] = Long.parseLong(functionsIds[i]);
		}
		
		Iterable<Long> funcsIds = Arrays.asList(functionsIdsLong);
		
		
		List<Function> funcLst = new ArrayList<>();
		
		funcLst.addAll(Lists.newArrayList(functionFacade.getAllFunctionsByIds(funcsIds)));
		
		Role role = new Role();
		
		role.setRoleName(roleName);
		role.setFunction(funcLst);
		
		roleFacade.addRole(role);

		List<Role> list = IterableUtils.toList(roleFacade.getAllRoles());

		ModelAndView model2 = new ModelAndView("/UsersManagement/ListRoles");
		model2.addObject("rolelst", list);

		return model2;
	}
}
