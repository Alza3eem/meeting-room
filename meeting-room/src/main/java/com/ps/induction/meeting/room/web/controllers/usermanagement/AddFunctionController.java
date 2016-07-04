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

import com.ps.induction.meeting.room.domain.entity.Function;
import com.ps.induction.meeting.room.facade.FunctionFacade;
import com.ps.induction.meeting.room.web.forms.usermanagement.AddFunctionForm;

/**
 * 
 * @author Loai AlTamimi
 *
 */
@Controller
@RequestMapping("/addfunction")
public class AddFunctionController {
	
	@Autowired
	private FunctionFacade functionFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getdata() {

		ModelAndView model = new ModelAndView("/UsersManagement/AddFunction");

		return model;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addFunction(@ModelAttribute("addFunctionForm") AddFunctionForm form, Map<String, Object> model) {
		String functionName = form.getFunctionName();
		String pageName = form.getPageName();

		Function function = new Function();
		function.setFunctionName(functionName);
		function.setPageName(pageName);
		
		functionFacade.addFuncrion(function);
		
		List<Function> list = IterableUtils.toList(functionFacade.getAllFunctions());

		ModelAndView model2 = new ModelAndView("/UsersManagement/ListFunctions");
		model2.addObject("funcslst", list);

		return model2;
	}
}
