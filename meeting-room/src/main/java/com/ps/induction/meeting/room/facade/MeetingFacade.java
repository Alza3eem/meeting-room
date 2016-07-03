package com.ps.induction.meeting.room.facade;

import com.ps.induction.meeting.room.domain.entity.Meeting;

/**
 * @author Mohammad Hussein
 *
 */
public interface MeetingFacade {

	void createMeeting(Meeting meeting);

	Iterable<Meeting> myMeetingList(String username);

	Meeting getMeetingById(int id);
}
