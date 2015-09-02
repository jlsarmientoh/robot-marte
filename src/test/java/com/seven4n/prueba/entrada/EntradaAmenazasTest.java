package com.seven4n.prueba.entrada;

import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

import com.seven4n.prueba.excepciones.EntradaException;
import com.seven4n.prueba.mapa.Mapa;
import com.seven4n.prueba.mapa.MapaMarte;

public class EntradaAmenazasTest {
	
	private static final String FILE_PATH = "amenazas.txt";
	
	private static final String FILE_PATH_FAIL = "amenazas_fail.txt";
	
	private EntradaDatos entradaDatos;
	
	@Before
	public void setUp(){
		this.entradaDatos = new EntradaAmenazas(5,5);
	}

	@Test
	public void testProcesarEntrada() throws EntradaException, URISyntaxException {
		String ruta = getClass().getClassLoader().getResource(FILE_PATH).toURI().getPath();
		this.entradaDatos.procesarEntrada(ruta);
	}
	
	@Test(expected = EntradaException.class)
	public void testProcesarEntradaInvalida() throws EntradaException, URISyntaxException {
		String ruta = getClass().getClassLoader().getResource(FILE_PATH_FAIL).toURI().getPath();
		this.entradaDatos.procesarEntrada(ruta);
	}

}
