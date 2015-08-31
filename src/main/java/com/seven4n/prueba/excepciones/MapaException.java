package com.seven4n.prueba.excepciones;

public class MapaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6802535950244068106L;

	public MapaException(String message) {
		super(message);
	}

	public MapaException(String message, Throwable cause) {
		super(message, cause);
	}

}
