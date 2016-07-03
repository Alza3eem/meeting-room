/**
 * 
 */
package com.ps.induction.meeting.room.web.controllers.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.induction.meeting.room.facade.RoomFacade;

/**
 * @author Eyad Jarrar
 *
 */

@Controller
@RequestMapping("/delete-room")
public class DeleteRoomController{

	@Autowired
	private RoomFacade roomFacade;

	@RequestMapping(method = RequestMethod.GET)
	public String view(@RequestParam String roomName) {

		roomFacade.deleteRoomByName(roomName);
		
		return "redirect:/rooms-list";
	}
}