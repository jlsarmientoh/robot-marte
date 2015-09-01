package com.seven4n.prueba.excepciones;

public class EntradaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8307885981296484817L;

	/**
	 * @param message
	 * @param cause
	 */
	public EntradaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public EntradaException(String message) {
		super(message);
	}
}
