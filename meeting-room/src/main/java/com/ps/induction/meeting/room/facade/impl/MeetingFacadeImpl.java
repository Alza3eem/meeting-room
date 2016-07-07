package com.ps.induction.meeting.room.facade.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ps.induction.meeting.room.domain.entity.Meeting;
import com.ps.induction.meeting.room.domain.entity.MeetingAttendee;
import com.ps.induction.meeting.room.domain.entity.Room;
import com.ps.induction.meeting.room.domain.entity.User;
import com.ps.induction.meeting.room.domain.repository.MeetingRepository;
import com.ps.induction.meeting.room.domain.repository.RoomRepository;
import com.ps.induction.meeting.room.domain.repository.UserRepository;
import com.ps.induction.meeting.room.facade.MeetingFacade;
import com.ps.induction.meeting.room.facade.exceptions.MeetingNotFoundException;
import com.ps.induction.meeting.room.facade.exceptions.RoomNotFoundException;
import com.ps.induction.meeting.room.facade.exceptions.TimeCrossException;
import com.ps.induction.meeting.room.web.MeetingForm;

/**
 * @author Mohammad Hussein
 *
 */
@Transactional
public class MeetingFacadeImpl implements MeetingFacade {

	@Autowired
	private MeetingRepository meetingRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void createMeeting(MeetingForm meetingForm) {
		long startTime = meetingForm.getMeetingStartTime().getTime();
		long endTime = meetingForm.getMeetingEndTime().getTime();

		Iterable<Meeting> meetings = meetingRepository
				.findByMeetingRoomNameAndMeetingDateAndMeetingStartTimeBetweenAndMeetingEndTimeBetween(
						meetingForm.getMeetingRoom(), meetingForm.getMeetingDate(), startTime, endTime, startTime,
						endTime);
		if (meetings.iterator().hasNext())
			throw new TimeCrossException("Meeting interception, Choose another time.");

		Room room = roomRepository.findOneByName(meetingForm.getMeetingRoom());
		if (room == null)
			throw new RoomNotFoundException("Room not found");

		Meeting meeting = new Meeting();

		meeting.setTitle(meetingForm.getTitle());
		meeting.setMeetingRoom(room);
		meeting.setMeetingDate(meetingForm.getMeetingDate());
		meeting.setMeetingStartTime(startTime);
		meeting.setMeetingEndTime(endTime);
		meeting.setUserCreate(userRepository.findOneByUsername("u590"));
		Set<MeetingAttendee> attendees = new HashSet<MeetingAttendee>();
		for (String username : meetingForm.getAttendees()) {
			User user = userRepository.findOneByUsername(username);

			MeetingAttendee attendee = new MeetingAttendee();
			attendee.setAttendee(user);
			attendee.setMeeting(meeting);
			attendees.add(attendee);
		}
		meeting.setAttendees(attendees);
		meetingRepository.save(meeting);
	}

	@Override
	public Iterable<Meeting> myMeetingList(String username) {
		return meetingRepository.findByAttendeesAttendeeUsername(username);
	}

	@Override
	public Meeting getMeetingById(Integer id) {
		Meeting meeting = meetingRepository.findOneById(id);
		if (meeting == null)
			throw new MeetingNotFoundException("Meeting not found, please check again");
		return meeting;
	}
}
