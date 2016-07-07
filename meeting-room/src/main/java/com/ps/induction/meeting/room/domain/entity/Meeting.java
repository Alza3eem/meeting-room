package com.ps.induction.meeting.room.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Meeting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String title;

	@ManyToOne(cascade = CascadeType.ALL)
	private Room meetingRoom;

	@JoinColumn(name = "user_create")
	@ManyToOne(cascade = CascadeType.ALL)
	private User userCreate;

	@OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<MeetingAttendee> attendees;

	@Column(name = "meet_date")
	@Temporal(TemporalType.DATE)
	// @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
	private Date meetingDate;

	@Column(name = "start_date")
	private Long meetingStartTime;

	@Column(name = "end_time")
	private Long meetingEndTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Long getMeetingStartTime() {
		return meetingStartTime;
	}

	public void setMeetingStartTime(Long meetingStartTime) {
		this.meetingStartTime = meetingStartTime;
	}

	public Long getMeetingEndTime() {
		return meetingEndTime;
	}

	public void setMeetingEndTime(Long meetingEndTime) {
		this.meetingEndTime = meetingEndTime;
	}

	@Override
	public String toString() {
		return "Meeting [id=" + id + ", title=" + title + ", meetingRoom=" + meetingRoom + ", userCreate=" + userCreate
				+ ", attendees=" + attendees + ", meetingDate=" + meetingDate + ", meetingStartTime=" + meetingStartTime
				+ ", meetingEndTime=" + meetingEndTime + "]";
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
