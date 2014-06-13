package com.scc.app.exception;

/**
 * {@link LoginException} for {@link User#getLogin()} not found.
 */
public class LoginNotFoundException extends LoginException {

	private static final long serialVersionUID = 1L;

	public LoginNotFoundException() {
		super();
	}

	public LoginNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public LoginNotFoundException(final String message) {
		super(message);
	}

	public LoginNotFoundException(final Throwable cause) {
		super(cause);
	}

}