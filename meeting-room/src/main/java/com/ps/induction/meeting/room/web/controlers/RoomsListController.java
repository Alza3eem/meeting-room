/**
 * 
 */
package com.ps.induction.meeting.room.web.controlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ps.induction.meeting.room.domain.entity.Room;
import com.ps.induction.meeting.room.facade.RoomFacade;

/**
 * @author Eyad Jarrar
 *
 */

@Controller
@RequestMapping("/rooms-list")
public class RoomsListController {

	@Autowired
	private RoomFacade roomFacade;
	
	// Add this in deleteControler
	//@RequestParam String roomName
	
	@RequestMapping(method = RequestMethod.GET)
	public String view(Map<String, Object> model) {

		Iterable<Room> rooms = roomFacade.getAllRooms();
		model.put("rooms", rooms);
		return "rooms/roomsList";
	}
}