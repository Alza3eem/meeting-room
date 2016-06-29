package com.ps.induction.meeting.room.domain.repository;

import org.springframework.data.repository.Repository;

import com.ps.induction.meeting.room.domain.entity.Room;

/**
 * @author Mohammad Hussein
 *
 */
@org.springframework.stereotype.Repository
public interface RoomRepository extends Repository<Room, Integer> {

	void save(Room room);

	void deleteById(Integer id);

	void deleteByName(String name);
}
