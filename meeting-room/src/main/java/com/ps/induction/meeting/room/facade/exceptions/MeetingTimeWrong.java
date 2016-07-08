package com.ps.induction.meeting.room.facade.exceptions;

/**
 * @author Mohammad Hussein
 *
 */
public class MeetingTimeWrong extends FacadeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MeetingTimeWrong(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MeetingTimeWrong(String message, Throwable cause) {
		super(message, cause);
	}

	public MeetingTimeWrong(String message) {
		super(message);
	}

	public MeetingTimeWrong(Throwable cause) {
		super(cause);
	}

}
