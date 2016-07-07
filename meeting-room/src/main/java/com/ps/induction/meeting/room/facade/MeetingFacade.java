package com.ps.induction.meeting.room.facade;

import com.ps.induction.meeting.room.domain.entity.Meeting;
import com.ps.induction.meeting.room.web.MeetingForm;

/**
 * @author Mohammad Hussein
 *
 */
public interface MeetingFacade {

	void createMeeting(MeetingForm meeting);

	Iterable<Meeting> myMeetingList(String username);

	Meeting getMeetingById(Integer id);
}
