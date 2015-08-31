package com.seven4n.prueba.robot;

import com.seven4n.prueba.excepciones.RobotException;

public interface Robot {

	public abstract void moverse(char accion) throws RobotException;

	public abstract void setPosicionInicial(int x, int y, char orientacion)
			throws RobotException;

	public abstract String getPosicion();

}