package com.ps.induction.meeting.room.facade;

import com.ps.induction.meeting.room.domain.entity.Meeting;
import com.ps.induction.meeting.room.domain.entity.User;
import com.ps.induction.meeting.room.web.MeetingForm;

/**
 * @author Mohammad Hussein
 *
 */
public interface MeetingFacade {

	void createMeeting(MeetingForm meeting, User user);

	Iterable<Meeting> myMeetingList(String username);

	Meeting getMeeting(Integer id);
}
