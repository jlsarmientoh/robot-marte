package com.seven4n.prueba.robot;

import com.seven4n.prueba.excepciones.RobotException;

public interface Robot {

	public void moverse(char accion) throws RobotException;

	public void setPosicionInicial(int x, int y, char orientacion)
			throws RobotException;

	public String getPosicion() throws RobotException;
	
	public String getAmenazas();

}