package com.ps.induction.meeting.room.facade.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ps.induction.meeting.room.domain.entity.AttedanceStatus;
import com.ps.induction.meeting.room.domain.entity.Meeting;
import com.ps.induction.meeting.room.domain.entity.MeetingAttendee;
import com.ps.induction.meeting.room.domain.entity.Room;
import com.ps.induction.meeting.room.domain.entity.User;
import com.ps.induction.meeting.room.domain.repository.MeetingRepository;
import com.ps.induction.meeting.room.domain.repository.RoomRepository;
import com.ps.induction.meeting.room.domain.repository.UserRepository;
import com.ps.induction.meeting.room.facade.MeetingFacade;
import com.ps.induction.meeting.room.facade.exceptions.MeetingDateWrong;
import com.ps.induction.meeting.room.facade.exceptions.MeetingNotFoundException;
import com.ps.induction.meeting.room.facade.exceptions.MeetingTimeWrong;
import com.ps.induction.meeting.room.facade.exceptions.RoomNotFoundException;
import com.ps.induction.meeting.room.facade.exceptions.TimeCrossException;
import com.ps.induction.meeting.room.facade.exceptions.UsersNotFoundException;
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
	public void createMeeting(MeetingForm meetingForm, User userCreate) {
		validateDateAndTime(meetingForm);

		Room room = roomRepository.findOneByName(meetingForm.getMeetingRoom());

		validateRoomAndAttendees(meetingForm, room);

		Meeting meeting = fillMeetingEntity(meetingForm, userCreate, room);
		meetingRepository.save(meeting);
	}

	private void validateRoomAndAttendees(MeetingForm meetingForm, Room room) {
		if (room == null)
			throw new RoomNotFoundException("Room not found");

		if (meetingForm.getAttendees() == null || meetingForm.getAttendees().size() == 0)
			throw new UsersNotFoundException("Please select users to attend");

	}

	private Meeting fillMeetingEntity(MeetingForm meetingForm, User userCreate, Room room) {
		Meeting meeting = new Meeting();
		meeting.setTitle(meetingForm.getTitle());
		meeting.setMeetingRoom(room);
		meeting.setMeetingDate(meetingForm.getMeetingDate());
		meeting.setMeetingStartTime(meetingForm.getMeetingStartTime().getTime());
		meeting.setMeetingEndTime(meetingForm.getMeetingEndTime().getTime());
		meeting.setUserCreate(userRepository.findOneByUsername(userCreate.getUsername()));

		Set<MeetingAttendee> attendees = new HashSet<MeetingAttendee>();

		// Add user who create the meeting to the attendees
		meetingForm.getAttendees().add(userCreate.getUsername());

		for (String username : meetingForm.getAttendees()) {
			User user = userRepository.findOneByUsername(username);
			if (user == null)
				continue;
			MeetingAttendee attendee = new MeetingAttendee();
			attendee.setAttendee(user);
			attendee.setMeeting(meeting);
			attendees.add(attendee);
		}

		meeting.setAttendees(attendees);
		return meeting;
	}

	private void validateDateAndTime(MeetingForm meetingForm) {
		long startTime = meetingForm.getMeetingStartTime().getTime();
		long endTime = meetingForm.getMeetingEndTime().getTime();
		Date meetingDate = meetingForm.getMeetingDate();
		Date today = new Date();
		String meetingRoom = meetingForm.getMeetingRoom();

		if (meetingDate.before(today) || (meetingDate.equals(today) && today.getTime() > startTime))
			throw new MeetingDateWrong("Are you gonna back to the past !!!!");

		if (endTime < startTime)
			throw new MeetingTimeWrong("Choose a correct end time, don't go to the past");

		Iterable<Meeting> meetings = meetingRepository
				.findByMeetingRoomNameAndMeetingDateAndMeetingStartTimeBetweenAndMeetingEndTimeBetween(meetingRoom,
						meetingDate, startTime, endTime, startTime, endTime);
		if (meetings.iterator().hasNext())
			throw new TimeCrossException("Meeting interception, Choose another time.");

	}

	@Override
	public Iterable<Meeting> myMeetingList(String username) {
		return meetingRepository.findByAttendeesAttendeeUsernameOrderByMeetingDateAscMeetingStartTimeAsc(username);
	}

	@Override
	public Meeting getMeeting(Integer id) {
		Meeting meeting = meetingRepository.findOneById(id);
		if (meeting == null)
			throw new MeetingNotFoundException("Meeting not found, please check again");
		return meeting;
	}

	@Override
	public void setResponse(AttedanceStatus response, Integer meetingId, String username) {
		Meeting meeting = validateMeetingExist(meetingId);

		boolean isStillInvited = false;
		for (MeetingAttendee attendee : meeting.getAttendees()) {
			if (attendee.getAttendee().getUsername().equals(username)) {
				attendee.setResponse(response);
				isStillInvited = true;
				break;
			}
		}
		if (!isStillInvited)
			throw new UsersNotFoundException("Opps, you are not invited any more");
		meetingRepository.save(meeting);
	}

	@Override
	public void deleteMeeting(Integer meetingId) {
		validateMeetingExist(meetingId);
		meetingRepository.deleteById(meetingId);
	}

	private Meeting validateMeetingExist(Integer meetingId) {
		Meeting meeting = meetingRepository.findOneById(meetingId);
		if (meeting == null)
			throw new MeetingNotFoundException("Seems that meeting get canceled");
		return meeting;
	}
}
