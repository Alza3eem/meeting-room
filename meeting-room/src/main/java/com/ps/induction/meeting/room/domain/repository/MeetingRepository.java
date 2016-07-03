package com.ps.induction.meeting.room.domain.repository;

import java.util.Date;

import org.springframework.data.repository.Repository;

import com.ps.induction.meeting.room.domain.entity.Meeting;
import com.ps.induction.meeting.room.domain.entity.Room;

/**
 * @author Mohammad Hussein
 *
 */
@org.springframework.stereotype.Repository
public interface MeetingRepository extends Repository<Meeting, Integer> {

	void save(Meeting booking);

	Meeting findOneById(int id);

	Iterable<Meeting> findByMeetingRoomAndMeetingDateAndMeetingStartTimeBetweenOrMeetingEndTimeBetween(Room room,
			Date meetingDate, Date start1, Date end1, Date start2, Date end2);

	Iterable<Meeting> findByAttendeesAttendeeUsername(String username);
}
