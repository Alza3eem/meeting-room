package com.ps.induction.meeting.room.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Mohammad Hussein
 *
 */
@Entity
@Table(name = "attendance")
@IdClass(MeetingAttendeeKey.class)
public class MeetingAttendee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "meeting_id")
	private Meeting meeting;

	@Id
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User attendee;

	@Column
	@Enumerated
	private AttedanceStatus response = AttedanceStatus.WAITING;

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

	public AttedanceStatus getResponse() {
		return response;
	}

	public void setResponse(AttedanceStatus response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "MeetingAttendee [meeting=" + meeting + ", attendee=" + attendee + ", response=" + response + "]";
	}

}
