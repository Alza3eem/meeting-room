package com.ps.induction.meeting.room.facade.exceptions;

/**
 * @author Mohammad Hussein
 *
 */
public class MeetingNotFoundException extends FacadeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MeetingNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MeetingNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MeetingNotFoundException(String message) {
		super(message);
	}

	public MeetingNotFoundException(Throwable cause) {
		super(cause);
	}

}
