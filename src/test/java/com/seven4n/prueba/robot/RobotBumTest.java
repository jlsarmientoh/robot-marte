package com.seven4n.prueba.robot;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.seven4n.prueba.excepciones.MapaException;
import com.seven4n.prueba.excepciones.RobotException;
import com.seven4n.prueba.mapa.Mapa;
import com.seven4n.prueba.mapa.MapaMarte;

public class RobotBumTest {
	
	private Robot robot;
	
	@Before
	public void setUp() throws MapaException{
		Mapa mapa = new MapaMarte(5,5);
		mapa.setAmenaza(1, 2, '*');
		mapa.setAmenaza(2, 1, '*');
		mapa.setAmenaza(5, 5, '*');
		mapa.setAmenaza(3, 3, '*');
		mapa.setAmenaza(2, 4, '%');
		this.robot = new RobotBum(mapa);
	}

	@Test
	public void testMoverse() throws RobotException {
		this.robot.setPosicionInicial(1, 2, 'N');
		this.robot.moverse('I');
		this.robot.moverse('A');
		this.robot.moverse('I');
		this.robot.moverse('A');
		this.robot.moverse('I');
		this.robot.moverse('A');
		this.robot.moverse('I');
		this.robot.moverse('A');
		this.robot.moverse('A');
		
		System.out.println(this.robot.getPosicion());
		assertTrue("Posición no coincide", "1 3 N".equals(this.robot.getPosicion()));
		
		this.robot.setPosicionInicial(3, 3, 'E');
		this.robot.moverse('A');
		this.robot.moverse('A');
		this.robot.moverse('D');
		this.robot.moverse('A');
		this.robot.moverse('A');
		this.robot.moverse('D');
		this.robot.moverse('A');
		this.robot.moverse('D');
		this.robot.moverse('D');
		this.robot.moverse('A');
		
		System.out.println(this.robot.getPosicion());
		assertTrue("Posición no coincide", "5 1 E".equals(this.robot.getPosicion()));
	}
	
	@Test(expected = RobotException.class)
	public void testMoverseSinInicializar() throws RobotException {
		this.robot.moverse('I');
	}

	@Test
	public void testSetPosicionInicial() throws RobotException {
		this.robot.setPosicionInicial(3, 1, 'W');
		
		assertTrue("Posición no coincide", "3 1 W".equals(this.robot.getPosicion()));
	}
	
	@Test(expected = RobotException.class)
	public void testSetPosicionInicialFueraDeLimite() throws RobotException {
		this.robot.setPosicionInicial(7, 9, 'N');
	}
	
	@Test(expected = RobotException.class)
	public void testSetPosicionInicialOrientactionInvalida() throws RobotException {
		this.robot.setPosicionInicial(3, 1, 'X');
	}

	@Test
	public void testGetPosicion() throws RobotException {
		this.robot.setPosicionInicial(0, 0, 'S');
		assertTrue("Posición no coincide", "0 0 S".equals(this.robot.getPosicion()));
	}
	
	@Test(expected = RobotException.class)
	public void testGetPosicionSinInicializar() throws RobotException {
		assertTrue("Posición no coincide", "0 0 S".equals(this.robot.getPosicion()));
	}

	@Test
	public void testDetectarAmenaza() throws RobotException {
		this.robot.setPosicionInicial(1, 2, 'N');
		this.robot.setPosicionInicial(3, 3, 'E');
		
		assertTrue("Amenazas no coinciden", "(1,2)(3,3)".equals(this.robot.getAmenazas()));
	}

}
