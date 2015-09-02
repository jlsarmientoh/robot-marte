package com.seven4n.prueba.entrada;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.seven4n.prueba.excepciones.EntradaException;
import com.seven4n.prueba.robot.Robot;

public class EntradaMovimientosTest {
	
	private static final String FILE_PATH_AMENAZAS = "amenazas.txt";
	
	private static final String FILE_PATH_MOVIMIENTOS = "movimientos.txt";
	
	private static final String FILE_PATH_MOVIMIENTOS_FAIL = "movimientos_fail.txt";
	
	private EntradaDatos<List<Robot>> entradaMovimientos;

	@Before
	public void setUp() throws Exception {
		String ruta = getClass().getClassLoader().getResource(FILE_PATH_AMENAZAS).toURI().getPath();
		this.entradaMovimientos = new EntradaMovimientos(ruta);
	}

	@Test
	public void testProcesarEntrada() throws Exception {
		List<Robot> robots = null;
		String ruta = getClass().getClassLoader().getResource(FILE_PATH_MOVIMIENTOS).toURI().getPath();
		
		robots = this.entradaMovimientos.procesarEntrada(ruta);
		
		assertNotNull(robots);
		assertTrue(robots.size() == 2);
	}
	
	@Test(expected = EntradaException.class)
	public void testProcesarEntradaFail() throws Exception {
		
		String ruta = getClass().getClassLoader().getResource(FILE_PATH_MOVIMIENTOS_FAIL).toURI().getPath();
		List<Robot> robots = this.entradaMovimientos.procesarEntrada(ruta);
	}

}
