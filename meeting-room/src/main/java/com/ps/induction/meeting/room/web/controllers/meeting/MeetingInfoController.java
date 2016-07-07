/**
 * 
 */
package com.ps.induction.meeting.room.web.controllers.meeting;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.induction.meeting.room.Constants;
import com.ps.induction.meeting.room.domain.entity.Meeting;
import com.ps.induction.meeting.room.facade.MeetingFacade;
import com.ps.induction.meeting.room.facade.exceptions.FacadeException;

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
	public String view(@RequestParam Integer id, Map<String, Object> model) {
		try {
			Meeting meeting = meetingFacade.getMeetingById(id);
			model.put("meeting", meeting);
		} catch (FacadeException e) {
			model.put(Constants.ERROR_MESSAGE, "Meeting not Found");
		}
		return "meetings/meetingInfo";
	}
}
