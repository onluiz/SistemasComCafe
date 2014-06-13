package com.scc.app.exception;

/**
 * Generic super class for login {@link ServiceException}
 */
public abstract class LoginException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public LoginException() {
		super();
	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginException(String message) {
		super(message);
	}

	public LoginException(Throwable cause) {
		super(cause);
	}

}