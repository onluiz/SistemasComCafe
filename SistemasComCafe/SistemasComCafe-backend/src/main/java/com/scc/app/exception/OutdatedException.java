package com.scc.app.exception;

public class OutdatedException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public OutdatedException() {
		super("Este estudo foi alterado por um outro médico e não poderá ser alterado.");
	}

}
