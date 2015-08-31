package com.seven4n.prueba.mapa;

import static org.junit.Assert.*;

import org.junit.Test;

import com.seven4n.prueba.excepciones.MapaException;

public class MapaMarteTest {
	
	private Mapa mapa = new MapaMarte(5,5);

	@Test
	public void testSetAmenaza() throws Exception{
		this.mapa.setAmenaza(3, 2, '*');
		this.mapa.setAmenaza(2, 1, '*');
		this.mapa.setAmenaza(4, 0, '*');
		
		assertTrue("No es una amenaza",this.mapa.getAmenaza(3, 2) == '*');
		assertTrue("No es una amenaza",this.mapa.getAmenaza(2, 1) == '*');
		assertTrue("No es una amenaza",this.mapa.getAmenaza(4, 0) == '*');
	}
	
	@Test(expected = MapaException.class)
	public void testSetAmenazaCoordenadaInvalida() throws Exception{
		this.mapa.setAmenaza(8, 2, '*');
	}

	@Test
	public void testGetAmenaza() throws Exception{
		this.mapa.setAmenaza(2, 1, '*');
		
		assertTrue("No es una amenaza",this.mapa.getAmenaza(2, 1) == '*');
	}
	
	@Test(expected = MapaException.class)
	public void testGetAmenazaCoordenadaInvalida() throws Exception{
		this.mapa.getAmenaza(2, 9);
	}

	@Test
	public void testCoordenadaValida() throws Exception{
		//Coordenadas validas
		assertTrue("Coordenada inválida",this.mapa.coordenadaValida(2, 3));
		assertTrue("Coordenada inválida",this.mapa.coordenadaValida(2, 3));
		//Coordenadas inválidas
		assertFalse("Coordenada válida", this.mapa.coordenadaValida(6, 0));
		assertFalse("Coordenada válida", this.mapa.coordenadaValida(0, 6));
	}

}
