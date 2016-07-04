package com.ps.induction.meeting.room.facade.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ps.induction.meeting.room.domain.entity.Meeting;
import com.ps.induction.meeting.room.domain.repository.MeetingRepository;
import com.ps.induction.meeting.room.facade.MeetingFacade;
import com.ps.induction.meeting.room.facade.exceptions.MeetingNotFoundException;
import com.ps.induction.meeting.room.facade.exceptions.TimeCrossException;

/**
 * @author Mohammad Hussein
 *
 */
@Transactional
public class MeetingFacadeImpl implements MeetingFacade {

	@Autowired
	private MeetingRepository meetingRepository;

	@Override
	public void createMeeting(Meeting meeting) {
		Date meetingStartTime = meeting.getMeetingStartTime();
		Date meetingEndTime = meeting.getMeetingEndTime();

		Iterable<Meeting> meetings = meetingRepository
				.findByMeetingRoomAndMeetingDateAndMeetingStartTimeBetweenOrMeetingEndTimeBetween(
						meeting.getMeetingRoom(), meeting.getMeetingDate(), meetingStartTime, meetingEndTime,
						meetingEndTime, meetingStartTime);
		if (meetings != null)
			throw new TimeCrossException("Meeting interception, Choose another time.");
	}

	@Override
	public Iterable<Meeting> myMeetingList(String username) {
		return meetingRepository.findByAttendeesAttendeeUsername(username);
	}

	@Override
	public Meeting getMeetingById(int id) {
		Meeting meeting = meetingRepository.findOneById(id);
		if (meeting == null)
			throw new MeetingNotFoundException("Meeting not found, please check again");
		return meeting;
	}
}
