package com.ps.induction.meeting.room.domain.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mohammad Hussein
 *
 */
@Entity
@Table(name = "meeting")
public class Meeting {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Room meetingRoom;

	@JoinColumn(name = "user_create")
	@ManyToOne(cascade = CascadeType.ALL)
	private User userCreate;

	@OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
	private Set<MeetingAttendee> attendees;

	@Column(name = "meet_date")
	@Temporal(TemporalType.DATE)
	private Date meetingDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date")
	private Date meetingStartTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time")
	private Date meetingEndTime;

	@Column
	@Enumerated
	private MeetingStatus status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Room getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(Room meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public User getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(User userCreate) {
		this.userCreate = userCreate;
	}

	public Set<MeetingAttendee> getAttendees() {
		return attendees;
	}

	public void setAttendees(Set<MeetingAttendee> attendees) {
		this.attendees = attendees;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public Date getMeetingStartTime() {
		return meetingStartTime;
	}

	public void setMeetingStartTime(Date meetingStartTime) {
		this.meetingStartTime = meetingStartTime;
	}

	public Date getMeetingEndTime() {
		return meetingEndTime;
	}

	public void setMeetingEndTime(Date meetingEndTime) {
		this.meetingEndTime = meetingEndTime;
	}

	public MeetingStatus getStatus() {
		return status;
	}

	public void setStatus(MeetingStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Meeting [id=" + id + ", room=" + meetingRoom + ", userCreate=" + userCreate + ", attendees=" + attendees
				+ ", meetingDate=" + meetingDate + ", startTime=" + meetingStartTime + ", endTime=" + meetingEndTime
				+ ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Meeting other = (Meeting) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
