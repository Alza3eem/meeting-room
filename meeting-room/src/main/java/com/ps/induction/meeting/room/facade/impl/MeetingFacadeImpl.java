package com.ps.induction.meeting.room.facade.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ps.induction.meeting.room.domain.entity.Meeting;
import com.ps.induction.meeting.room.domain.repository.MeetingRepository;
import com.ps.induction.meeting.room.facade.MeetingFacade;

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

	}

	@Override
	public Meeting getMeetingById(int id) {
		
		return meetingRepository.findOneById(id);
	}

}
