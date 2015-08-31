package com.seven4n.prueba.mapa;

import com.seven4n.prueba.excepciones.MapaException;

public interface Mapa {

	public abstract void setAmenaza(int x, int y, char amenaza)
			throws MapaException;

	public abstract char getAmenaza(int x, int y) throws MapaException;

	public abstract boolean coordenadaValida(int x, int y) throws MapaException;

}