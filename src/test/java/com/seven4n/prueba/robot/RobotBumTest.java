package com.seven4n.prueba.robot;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.seven4n.prueba.mapa.MapaMarte;

public class RobotBumTest {
	
	private Robot robot;
	
	@Before
	public void setUp(){
		this.robot = new RobotBum(new MapaMarte(5,5));
	}

	@Test
	public void testMoverse() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPosicionInicial() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPosicion() {
		fail("Not yet implemented");
	}

	@Test
	public void testDetectarAmenaza() {
		fail("Not yet implemented");
	}

}
