package com.seven4n.prueba.robot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seven4n.prueba.excepciones.MapaException;
import com.seven4n.prueba.excepciones.RobotException;
import com.seven4n.prueba.mapa.Mapa;

public class RobotBum {
	
	private static final Logger logger = LoggerFactory.getLogger(RobotBum.class);
	
	private int actualX;
	
	private int actualY;
	
	private int actualOrientacion;
	
	private char[] orientaciones;
	
	private Mapa mapa;

	public RobotBum(Mapa mapa) {
		this.mapa = mapa;
		this.orientaciones = new char[]{'S', 'W', 'N', 'E'};
	}
	
	public void moverse(char accion) throws RobotException{
		switch(accion){
			case 'I' :{
				break;
			}
			case 'D' :{
				break;
			}
			case 'A' :{
				break;
			}
		}
	}
	
	public void setPosicionInicial(int x, int y, char orientacion) throws RobotException{
		try{
			
			if(!this.mapa.coordenadaValida(x, y))
				throw new RobotException(String.format("Coordenada no válida [%d,%d]", x, y));
			
			this.actualX = x;
			this.actualY = y;
			
		}catch(MapaException ex){
			
		}
	}

}
