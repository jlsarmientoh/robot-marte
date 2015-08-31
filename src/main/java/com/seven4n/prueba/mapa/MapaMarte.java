package com.seven4n.prueba.mapa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seven4n.prueba.excepciones.MapaException;

public class MapaMarte implements Mapa {
	
	private static final Logger logger = LoggerFactory.getLogger(MapaMarte.class); 
	
	private char[][] terreno;
	
	private boolean inicializado;
	
	public MapaMarte(int maxY, int maxX){
		this.terreno = new char[maxY][maxX];
		this.inicializado = true;
	}
	
	/* (non-Javadoc)
	 * @see com.seven4n.prueba.mapa.Mapa#setAmenaza(int, int, char)
	 */
	@Override
	public void setAmenaza(int x, int y, char amenaza) throws MapaException{
		try{
			if(!this.inicializado)
				throw new MapaException("El mapa no ha sido inicializado");
			
			this.terreno[y][x] = amenaza;
		}catch(IndexOutOfBoundsException ex){
			logger.error("Coordenada está fuera de los límites del mapa");
			throw new MapaException("Coordenada está fuera de los límites del mapa");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.seven4n.prueba.mapa.Mapa#getAmenaza(int, int)
	 */
	@Override
	public char getAmenaza(int x, int y) throws MapaException{
		try{
			if(!this.inicializado)
				throw new MapaException("El mapa no ha sido inicializado");
			
			return this.terreno[y][x];	
		}catch(IndexOutOfBoundsException ex){
			logger.error("Coordenada está fuera de los límites del mapa");
			throw new MapaException("Coordenada está fuera de los límites del mapa");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.seven4n.prueba.mapa.Mapa#coordenadaValida(int, int)
	 */
	@Override
	public boolean coordenadaValida(int x, int y) throws MapaException{
		
		try{
			if(!this.inicializado)
				throw new MapaException("El mapa no ha sido inicializado");
			
			char c = this.terreno[y][x];
			return true;
		}catch(IndexOutOfBoundsException ex){
			logger.error("Coordenada está fuera de los límites del mapa");
			return false;
		}
	}

}
