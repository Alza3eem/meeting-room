package com.ps.induction.meeting.room.domain.repository;

import java.util.Date;

import org.springframework.data.repository.Repository;

import com.ps.induction.meeting.room.domain.entity.Meeting;

/**
 * @author Mohammad Hussein
 *
 */
@org.springframework.stereotype.Repository
public interface MeetingRepository extends Repository<Meeting, Integer> {

	void save(Meeting meeting);

	void deleteById(Integer id);

	Meeting findOneById(Integer id);

	Iterable<Meeting> findByMeetingRoomNameAndMeetingDateAndMeetingStartTimeBetweenAndMeetingEndTimeBetween(String room,
			Date meetingDate, long startTime, long endTime, long endTime2, long startTime2);

	Iterable<Meeting> findByAttendeesAttendeeUsername(String username);
}
