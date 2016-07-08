package com.ps.induction.meeting.room.facade.exceptions;

/**
 * @author Mohammad Hussein
 *
 */
public class MeetingDateWrong extends FacadeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MeetingDateWrong(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MeetingDateWrong(String message, Throwable cause) {
		super(message, cause);
	}

	public MeetingDateWrong(String message) {
		super(message);
	}

	public MeetingDateWrong(Throwable cause) {
		super(cause);
	}

}
