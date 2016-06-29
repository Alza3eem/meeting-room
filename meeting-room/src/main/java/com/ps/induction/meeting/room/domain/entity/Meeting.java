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
	private Room room;

	@ManyToOne(cascade = CascadeType.ALL)
	@Column(name = "user_create")
	private User userCreate;

	@OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
	private Set<MeetingAttendee> attendees;

	@Column(name = "meet_date")
	@Temporal(TemporalType.DATE)
	private Date meetingDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date")
	private Date startTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time")
	private Date endTime;

	@Column
	@Enumerated
	private Status status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Meeting [id=" + id + ", room=" + room + ", userCreate=" + userCreate + ", attendees=" + attendees
				+ ", meetingDate=" + meetingDate + ", startTime=" + startTime + ", endTime=" + endTime + ", status="
				+ status + "]";
	}

}
