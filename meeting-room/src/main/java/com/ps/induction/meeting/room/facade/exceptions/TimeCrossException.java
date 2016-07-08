package com.ps.induction.meeting.room.facade.exceptions;

/**
 * @author Mohammad Hussein
 *
 */
public class TimeCrossException extends FacadeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TimeCrossException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TimeCrossException(String message, Throwable cause) {
		super(message, cause);
	}

	public TimeCrossException(String message) {
		super(message);
	}

	public TimeCrossException(Throwable cause) {
		super(cause);
	}

}
