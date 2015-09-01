package com.seven4n.prueba.mapa;

import com.seven4n.prueba.excepciones.MapaException;

public interface Mapa {

	public void setAmenaza(int x, int y, char amenaza)
			throws MapaException;

	public char getAmenaza(int x, int y) throws MapaException;

	public boolean coordenadaValida(int x, int y) throws MapaException;

}