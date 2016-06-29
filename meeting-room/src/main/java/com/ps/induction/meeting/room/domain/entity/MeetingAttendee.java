package com.ps.induction.meeting.room.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Mohammad Hussein
 *
 */
@Entity
public class MeetingAttendee {

	@Id
	@ManyToOne
	@JoinColumn(name = "meeting_id")
	private Meeting meeting;

	@Id
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User attendee;

	@Column
	private Response response;

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public User getAttendee() {
		return attendee;
	}

	public void setAttendee(User attendee) {
		this.attendee = attendee;
	}

	public User getUser() {
		return attendee;
	}

	public void setUser(User user) {
		this.attendee = user;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "MeetingAttendee [meeting=" + meeting + ", attendee=" + attendee + ", response=" + response + "]";
	}

}
