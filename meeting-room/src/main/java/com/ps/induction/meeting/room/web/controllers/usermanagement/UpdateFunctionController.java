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
import com.ps.induction.meeting.room.domain.entity.User;
import com.ps.induction.meeting.room.domain.repository.FunctionRepository;
import com.ps.induction.meeting.room.domain.repository.UserRepository;
import com.ps.induction.meeting.room.facade.FunctionFacade;
import com.ps.induction.meeting.room.web.forms.usermanagement.AddFunctionForm;
import com.ps.induction.meeting.room.web.forms.usermanagement.AddUserForm;
import com.ps.induction.meeting.room.web.forms.usermanagement.DeleteFunctionForm;
import com.ps.induction.meeting.room.web.forms.usermanagement.DeleteUserForm;

/**
 * 
 * @author Loai AlTamimi
 *
 */
@Controller
@RequestMapping("/updatefunc")
public class UpdateFunctionController {
	
	@Autowired
	FunctionFacade functionFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getdata(@RequestParam String id) {

		Function updateFunction = functionFacade.getFunctionById(Long.parseLong(id));

		ModelAndView model = new ModelAndView("/UsersManagement/UpdateFunction");

		model.addObject("updateFunction", updateFunction);

		return model;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("addFunctionForm") AddFunctionForm form, @RequestParam String id,
			Map<String, Object> model) {

		Function function = new Function();
		function.setFunctionId(Long.parseLong(id));
		function.setFunctionName(form.getFunctionName());
		function.setPageName(form.getPageName());

		functionFacade.addFuncrion(function);

		List<Function> list = IterableUtils.toList(functionFacade.getAllFunctions());

		// return back to index.jsp
		ModelAndView model2 = new ModelAndView("/UsersManagement/ListFunctions");
		model2.addObject("funcslst", list);

		return model2;
	}

}
