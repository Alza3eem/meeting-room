/**
 * 
 */
package com.ps.induction.meeting.room.web.controllers.usermanagement;

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

import com.ps.induction.meeting.room.domain.entity.Role;
import com.ps.induction.meeting.room.domain.repository.FunctionRepository;
import com.ps.induction.meeting.room.domain.repository.RoleRepository;
import com.ps.induction.meeting.room.web.forms.usermanagement.DeleteRoleForm;

/**
 * 
 * @author Loai AlTamimi
 *
 */
@Controller
@RequestMapping("/deleterole")
public class DeleteRoleController {
	@Autowired
	private FunctionRepository functionRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@RequestMapping(method = RequestMethod.POST)
	@Transactional
	public ModelAndView deleteRole(@ModelAttribute("deleteRoleForm") DeleteRoleForm form, Map<String, Object> model) {
		String roleId = form.getId();
		
		roleRepository.delete(Long.parseLong(roleId));

		List<Role> list = IterableUtils.toList(roleRepository.findAll());
		
		// return back to index.jsp
		ModelAndView model2 = new ModelAndView("/UsersManagement/ListRoles");
		model2.addObject("rolelst", list);

		return model2;
	}
}
