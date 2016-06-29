package com.ps.induction.meeting.room.web.controlers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ps.induction.meeting.room.domain.entity.Meeting;
import com.ps.induction.meeting.room.facade.MeetingFacade;

/**
 * @author Mohammad Hussein
 *
 */
@Controller
@RequestMapping("/book-meeting")
public class CreateMeetingControler {

	@Autowired
	private MeetingFacade meetingFacade;

	@RequestMapping(method = RequestMethod.GET)
	public String view() {
		return "CreateMeeting";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createMeeting(@Valid @ModelAttribute Meeting meeting, BindingResult result,
			Map<String, Object> model) {
		
		return "redired:/book-meeting";
	}
}
