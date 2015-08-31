package com.seven4n.prueba.robot;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seven4n.prueba.excepciones.MapaException;
import com.seven4n.prueba.excepciones.RobotException;
import com.seven4n.prueba.mapa.Mapa;

public class RobotBum implements Robot {
	
	private static final Logger logger = LoggerFactory.getLogger(RobotBum.class);
	
	private int actualX;
	
	private int actualY;
	
	private int actualOrientacion;
	
	private char[] orientaciones;
	
	private List<String> amenazas;
	
	private Mapa mapa;

	public RobotBum(Mapa mapa) {
		this.mapa = mapa;
		this.orientaciones = new char[]{'S', 'W', 'N', 'E'};
		this.amenazas = new ArrayList<String>();
	}
	
	/* (non-Javadoc)
	 * @see com.seven4n.prueba.robot.Robot#moverse(char)
	 */
	@Override
	public void moverse(char accion) throws RobotException{
		switch(accion){
			case 'I' :{
				if(this.actualOrientacion == 0){
					this.actualOrientacion = (this.orientaciones.length - 1);
				}else{
					this.actualOrientacion--;
				}
				break;
			}
			case 'D' :{
				if(this.actualOrientacion == (this.orientaciones.length - 1)){
					this.actualOrientacion = 0;
				}else{
					this.actualOrientacion++;
				}
				break;
			}
			case 'A' :{
				char orientacion = this.orientaciones[this.actualOrientacion];
				
				switch(orientacion){
					case 'S' : {
						this.actualY--;
						detectarAmenaza(this.actualX, this.actualY);
						break;
					}
					case 'W' : {
						this.actualX++;
						detectarAmenaza(this.actualX, this.actualY);
						break;
					}
					case 'N' : {
						this.actualY++;
						detectarAmenaza(this.actualX, this.actualY);
						break;
					}
					case 'E' : {
						this.actualX--;
						detectarAmenaza(this.actualX, this.actualY);
						break;
					}
				}
				
				break;
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.seven4n.prueba.robot.Robot#setPosicionInicial(int, int, char)
	 */
	@Override
	public void setPosicionInicial(int x, int y, char orientacion) throws RobotException{
		try{
			
			if(!this.mapa.coordenadaValida(x, y))
				throw new RobotException(String.format("Coordenada no válida [%d,%d]", x, y));
			
			this.actualX = x;
			this.actualY = y;
			this.actualOrientacion = getOrientacionIndice(orientacion);
		}catch(MapaException ex){
			logger.error("No se puede establecer la posición inicial: " + ex.getMessage());
			throw new RobotException("No se puede establecer la posición inicial: " + ex.getMessage(), ex);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.seven4n.prueba.robot.Robot#getPosicion()
	 */
	@Override
	public String getPosicion(){
		return String.format("%d %d %s", 
				this.actualX, 
				this.actualY, 
				this.orientaciones[this.actualOrientacion]);
	}
	
	protected boolean detectarAmenaza(int x, int y) throws RobotException{
		try {
			char amenaza = this.mapa.getAmenaza(x, y);
			
			if(amenaza == '*'){
				this.amenazas.add(String.format("(%d,%d)", x,y));
				return true;
			}else{
				return false;
			}
		} catch (MapaException e) {
			logger.error("No se puede obtener información del sensor: " + e.getMessage());
			throw new RobotException("No se puede obtener información del sensor: " + e.getMessage());
		}
		
	}
	
	private int getOrientacionIndice(char orientacion){
		int indice = 0;
		for(int i = 0; i < this.orientaciones.length; i++){
			if(this.orientaciones[i] == orientacion){
				indice = i;
				break;
			}
		}
		return indice;
	}

}
