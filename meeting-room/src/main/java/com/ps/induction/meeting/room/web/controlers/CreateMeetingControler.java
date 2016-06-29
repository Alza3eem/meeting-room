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
import com.ps.induction.meeting.room.domain.entity.Room;
import com.ps.induction.meeting.room.facade.MeetingFacade;
import com.ps.induction.meeting.room.facade.RoomFacade;

/**
 * @author Mohammad Hussein
 *
 */
@Controller
@RequestMapping("/book-meeting")
public class CreateMeetingControler {

	@Autowired
	private MeetingFacade meetingFacade;
	
	@Autowired
	private RoomFacade roomFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public String view(Map<String, Object> model) {
		Iterable<Room> rooms = roomFacade.getAllRooms();
		return "meetings/CreateMeeting";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createMeeting(@Valid @ModelAttribute Meeting meeting, BindingResult result,
			Map<String, Object> model) {
		
		return "redired:/book-meeting";
	}
}
