package com.ps.induction.meeting.room.web.controllers.meeting;

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
import com.ps.induction.meeting.room.domain.entity.User;
import com.ps.induction.meeting.room.facade.MeetingFacade;
import com.ps.induction.meeting.room.facade.RoomFacade;
import com.ps.induction.meeting.room.facade.UserFacade;
import com.ps.induction.meeting.room.facade.exceptions.FacadeException;

/**
 * @author Mohammad Hussein
 *
 */
@Controller
@RequestMapping("/book-meeting")
public class CreateMeetingController {

	public static final String MODEL_KEY_MESSEGE = "msg";

	@Autowired
	private MeetingFacade meetingFacade;

	@Autowired
	private RoomFacade roomFacade;

	@Autowired
	private UserFacade userFacade;

	@RequestMapping(method = RequestMethod.GET)
	public String view(Map<String, Object> model) {
		Iterable<Room> rooms = roomFacade.getAllRooms();
		Iterable<User> users = userFacade.getAllUsers();
		// TODO Don't show the the reserved times

		model.put("rooms", rooms);
		model.put("users", users);
		return "meetings/CreateMeeting";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createMeeting(@Valid @ModelAttribute("meeting") Meeting meeting, BindingResult result,
			Map<String, Object> model) {
		if (result.hasErrors()) {
			model.put(MODEL_KEY_MESSEGE, result.getFieldError());
			return "meetings/createMeeting";
		}
		try {
			meetingFacade.createMeeting(meeting);
			return "redired:/book-meeting";
		} catch (FacadeException e) {
			model.put(MODEL_KEY_MESSEGE, e.getMessage());
			return "meetings/createMeeting";
		}
	}
}
