package com.ps.induction.meeting.room.facade.exceptions;

/**
 * @author Mohammad Hussein
 *
 */
public class RoomNotFoundException extends FacadeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoomNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RoomNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RoomNotFoundException(String message) {
		super(message);
	}

	public RoomNotFoundException(Throwable cause) {
		super(cause);
	}

}
