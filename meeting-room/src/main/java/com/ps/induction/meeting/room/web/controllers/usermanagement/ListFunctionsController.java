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
import com.ps.induction.meeting.room.domain.repository.FunctionRepository;
import com.ps.induction.meeting.room.facade.FunctionFacade;
import com.ps.induction.meeting.room.web.forms.usermanagement.DeleteFunctionForm;

/**
 * 
 * @author Loai AlTamimi
 *
 */
@Controller
@RequestMapping("/listfuncs")
public class ListFunctionsController {
	
	@Autowired
	private FunctionFacade functionFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getdata() {

		List<Function> list = IterableUtils.toList(functionFacade.getAllFunctions());

		// return back to index.jsp
		ModelAndView model = new ModelAndView("/UsersManagement/ListFunctions");
		model.addObject("funcslst", list);

		return model;

	}

}
