/**
 * 
 */
package com.ps.induction.meeting.room.facade;

import com.ps.induction.meeting.room.domain.entity.Room;

/**
 * @author u592
 *
 */
public interface RoomFacade {
	
	
	public Room getRoom(String roomName);
	
	public Iterable<Room> getAllRooms();
	
	public void deleteRoomById(int id);
	
	public void addRoom(Room room);

	public boolean roomNameExists(String name);
	
	public void updateRoom(Room room);
	

}
