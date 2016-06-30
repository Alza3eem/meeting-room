package com.ps.induction.meeting.room.domain.repository;

import org.springframework.data.repository.Repository;

import com.ps.induction.meeting.room.domain.entity.Meeting;

/**
 * @author Mohammad Hussein
 *
 */
@org.springframework.stereotype.Repository
public interface MeetingRepository extends Repository<Meeting, Integer> {

	void save(Meeting booking);

}
