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
	
	private EntradaDatos entradaDatos;
	
	@Before
	public void setUp(){
		Mapa mapa = new MapaMarte(5,5);
		this.entradaDatos = new EntradaAmenazas(mapa);
	}

	@Test
	public void testProcesarEntrada() throws EntradaException, URISyntaxException {
		String ruta = getClass().getClassLoader().getResource(FILE_PATH).toURI().getPath();
		this.entradaDatos.procesarEntrada(ruta);
	}

}
