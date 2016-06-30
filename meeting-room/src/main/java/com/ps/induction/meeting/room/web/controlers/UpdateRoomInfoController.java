/**
 * 
 */
package com.ps.induction.meeting.room.web.controlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.induction.meeting.room.domain.entity.Room;
import com.ps.induction.meeting.room.facade.RoomFacade;
import com.ps.induction.meeting.room.facade.exceptions.FacadeException;

/**
 * @author Eyad Jarrar
 *
 */

@Controller
@RequestMapping("/update-room")
public class UpdateRoomInfoController {

	@Autowired
	private RoomFacade roomFacade;

	@RequestMapping(method = RequestMethod.GET)
	public String view(@RequestParam String roomName, Map<String, Object> model) {

		Room room = roomFacade.getRoom(roomName);
		
		model.put("room", room);
		return "rooms/addRoom";
			
	}
	@RequestMapping(method =RequestMethod.POST)
	public String updateRoom(Room room, Map<String,Object> model){
		
//		
//		if (roomFacade.roomNameExists(room.getName()))
//			model.put("errormessage", "room name already exists");
		
		try
		{
			roomFacade.addRoom(room);
			return "redirect:/rooms-list";
		} catch (FacadeException e) {
			model.put("errorMessage", e.getMessage());
		}
		return "redirect:/update-room";
	}
}
