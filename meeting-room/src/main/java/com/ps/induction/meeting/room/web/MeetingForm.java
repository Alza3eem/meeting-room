package com.ps.induction.meeting.room.web;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Mohammad Hussein
 *
 */
public class MeetingForm {
	@NotNull
	private String title;

	@NotNull
	private String meetingRoom;

	@NotNull
	private Set<String> attendees;

	@NotNull
	private String notes;

	@NotNull
	private Date meetingDate;

	@NotNull
	@DateTimeFormat(pattern = "hh:mm a")
	private Date meetingStartTime;

	@NotNull
	@DateTimeFormat(pattern = "hh:mm a")
	private Date meetingEndTime;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(String meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public Set<String> getAttendees() {
		return attendees;
	}

	public void setAttendees(Set<String> attendees) {
		this.attendees = attendees;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	@Override
	public String toString() {
		return "MeetingForm [meetingRoom=" + meetingRoom + ", attendees=" + attendees + ", notes=" + notes
				+ ", meetingDate=" + meetingDate + ", meetingStartTime=" + meetingStartTime + ", meetingEndTime="
				+ meetingEndTime + "]";
	}

}
