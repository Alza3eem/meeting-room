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
import com.ps.induction.meeting.room.web.forms.usermanagement.DeleteFunctionForm;

/**
 * 
 * @author Loai AlTamimi
 *
 */
@Controller
@RequestMapping("/deletefunc")
public class DeleteFunctionController {
	
	@Autowired
	private FunctionFacade functionFacade;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView deleteFunction(@ModelAttribute("deleteFunctionForm") DeleteFunctionForm form, Map<String, Object> model) {
		String userId = form.getId();

		functionFacade.removeFunctionById(Long.parseLong(userId));

		List<Function> list = IterableUtils.toList(functionFacade.getAllFunctions());

		// return back to index.jsp
		ModelAndView model2 = new ModelAndView("/UsersManagement/ListFunctions");
		model2.addObject("funcslst", list);

		return model2;
	}
}
