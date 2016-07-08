package com.ps.induction.meeting.room.web.controllers.meeting;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ps.induction.meeting.room.Constants;
import com.ps.induction.meeting.room.domain.entity.Meeting;
import com.ps.induction.meeting.room.domain.entity.User;
import com.ps.induction.meeting.room.facade.MeetingFacade;

/**
 * @author Mohammad Hussein
 *
 */
@Controller
@RequestMapping("/my-meetings")
public class MyMeetingListController {

	@Autowired
	private MeetingFacade meetingFacade;

	@RequestMapping(method = RequestMethod.GET)
	public String view(HttpServletRequest req, Map<String, Object> model) {

		User user = (User) req.getSession().getAttribute(Constants.LOGGED_USER_SESSION);
		Iterable<Meeting> myMeetingList = meetingFacade.myMeetingList(user.getUsername());
		model.put(Constants.MEETING_LIST, myMeetingList);
		return "meetings/myMeetingList";
	}
}
