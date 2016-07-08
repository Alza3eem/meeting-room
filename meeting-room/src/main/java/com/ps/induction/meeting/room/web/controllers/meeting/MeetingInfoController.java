/**
 * 
 */
package com.ps.induction.meeting.room.web.controllers.meeting;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.induction.meeting.room.Constants;
import com.ps.induction.meeting.room.domain.entity.Meeting;
import com.ps.induction.meeting.room.facade.MeetingFacade;
import com.ps.induction.meeting.room.facade.exceptions.FacadeException;
import com.ps.induction.meeting.room.web.ResponseDeleteMeetingForm;

/**
 * @author Eyad Jarrar
 *
 */

@Controller
@RequestMapping("/meeting-info")
public class MeetingInfoController {

	@Autowired
	MeetingFacade meetingFacade;

	@RequestMapping(method = RequestMethod.GET)
	public String view(@RequestParam Integer id, Map<String, Object> model, HttpServletRequest req) {
		try {
			Meeting meeting = meetingFacade.getMeeting(id);
			model.put(Constants.MEETING_INFO, meeting);
		} catch (FacadeException e) {
			model.put(Constants.ERROR_MESSAGE, "Meeting not Found");
		}
		return "meetings/meetingInfo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handleResponseDeleteRequest(ResponseDeleteMeetingForm form) {
		if (form.getAccept() != null)
			System.out.println("Accept");

		else if (form.getReject() != null)
			System.out.println("Reject");

		else
			System.out.println("Cancel");
		return "meetings/myMeetingList";

	}
}
