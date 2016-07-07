package com.ps.induction.meeting.room.domain.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
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
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "meeting_id")
	private Meeting meeting;

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User attendee;

	@Column
	@Enumerated(EnumType.STRING)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attendee == null) ? 0 : attendee.hashCode());
		result = prime * result + ((meeting == null) ? 0 : meeting.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetingAttendee other = (MeetingAttendee) obj;
		if (attendee == null) {
			if (other.attendee != null)
				return false;
		} else if (!attendee.equals(other.attendee))
			return false;
		if (meeting == null) {
			if (other.meeting != null)
				return false;
		} else if (!meeting.equals(other.meeting))
			return false;
		return true;
	}

}
