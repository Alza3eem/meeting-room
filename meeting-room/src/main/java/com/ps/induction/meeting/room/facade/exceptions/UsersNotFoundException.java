package com.ps.induction.meeting.room.facade.exceptions;

public class UsersNotFoundException extends FacadeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsersNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsersNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsersNotFoundException(String message) {
		super(message);
	}

	public UsersNotFoundException(Throwable cause) {
		super(cause);
	}

}
