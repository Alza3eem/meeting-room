/**
 * 
 */
package com.ps.induction.meeting.room.web.controllers.meeting;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.induction.meeting.room.domain.entity.Meeting;
import com.ps.induction.meeting.room.facade.MeetingFacade;

/**
 * @author Eyad Jarrar
 *
 */

@Controller
@RequestMapping("/meeting-info")
public class MeetingInfoController {

	MeetingFacade meetingFacade;

	@RequestMapping(method = RequestMethod.GET)
	public String view(@RequestParam Integer id, Map<String, Object> model) {

		Meeting meeting = meetingFacade.getMeetingById(id);
		model.put("meeting", meeting);
		return "meetings/meetingInfo";
	}
}
