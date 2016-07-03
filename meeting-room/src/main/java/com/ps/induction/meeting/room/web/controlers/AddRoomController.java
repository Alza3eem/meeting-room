package com.ps.induction.meeting.room.web.controlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ps.induction.meeting.room.domain.entity.Room;
import com.ps.induction.meeting.room.facade.RoomFacade;
import com.ps.induction.meeting.room.facade.exceptions.FacadeException;

/*
**
* @author Eyad Jarrar
*
*/

@Controller
@RequestMapping("/add-room")
public class AddRoomController {

	@Autowired
	private RoomFacade roomFacade;

	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String view() {
		return "rooms/addRoom";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addRoom(@ModelAttribute("signupForm") Room room, Map<String, Object> model) {
		
		try

		{
			roomFacade.addRoom(room);
			return "redirect:/rooms-list";
		} catch (FacadeException e) {
			model.put("errorMessage", e.getMessage());
		}
		return "redirect:/rooms-list";
	}
}