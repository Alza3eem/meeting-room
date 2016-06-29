/**
 * 
 */
package com.ps.induction.meeting.room.facade.impl;

import com.ps.induction.meeting.room.domain.entity.Room;
import com.ps.induction.meeting.room.domain.repository.RoomRepository;
import com.ps.induction.meeting.room.facade.RoomFacade;

/**
 * @author u592
 *
 */
public class RoomFacadeImpl implements RoomFacade{
	
	RoomRepository roomRepository;

	@Override
	public Room getRoom(String roomName) {

		return roomRepository.findOneByRoomName(roomName);
	}

	@Override
	public Iterable<Room> getAllRooms() {
		
		return roomRepository.findAll();
	}

	@Override
	public void deleteRoomById(int id) {

		roomRepository.deleteById(id);
		
	}

	@Override
	public void addRoom(Room room) {

		roomRepository.save(room);
	}

	@Override
	public boolean roomNameExists(String roomName) {
		
		Room room = roomRepository.findOneByRoomName(roomName);
		if(room!=null)
		return true;
		else
			return false;
	}

	@Override
	public void updateRoom(Room room) {

		roomRepository.save(room);
	}


}