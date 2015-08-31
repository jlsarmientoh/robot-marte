package com.seven4n.prueba.excepciones;

public class RobotException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6799734212600681914L;

	public RobotException(String message) {
		super(message);
	}

	public RobotException(String message, Throwable cause) {
		super(message, cause);
	}

}
