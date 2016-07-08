package com.ps.induction.meeting.room.web.controllers.meeting;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ps.induction.meeting.room.Constants;
import com.ps.induction.meeting.room.domain.entity.Room;
import com.ps.induction.meeting.room.domain.entity.User;
import com.ps.induction.meeting.room.facade.MeetingFacade;
import com.ps.induction.meeting.room.facade.RoomFacade;
import com.ps.induction.meeting.room.facade.UserFacade;
import com.ps.induction.meeting.room.facade.exceptions.FacadeException;
import com.ps.induction.meeting.room.web.MeetingForm;

/**
 * @author Mohammad Hussein
 *
 */
@Controller
@RequestMapping("/book-meeting")
public class CreateMeetingController {

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

		model.put(Constants.ROOM_LIST, rooms);
		model.put(Constants.USER_LIST, users);
		return "meetings/createMeeting";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createMeeting(@Valid @ModelAttribute("meeting") MeetingForm meeting, BindingResult result,
			Map<String, Object> model, HttpSession session) {
		if (result.hasErrors()) {
			model.put(Constants.MODEL_KEY_MESSEGE, result.getFieldError());
			return "meetings/createMeeting";
		}
		try {
			meetingFacade.createMeeting(meeting, (User) session.getAttribute(Constants.LOGGED_USER_SESSION));
			model.put(Constants.MODEL_KEY_MESSEGE, "Meeting Created Successfully");
			return "meetings/createMeeting";
		} catch (FacadeException e) {
			model.put(Constants.MODEL_KEY_MESSEGE, e.getMessage());
			return "meetings/createMeeting";
		}
	}
}
