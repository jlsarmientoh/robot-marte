/**
 * 
 */
package com.seven4n.prueba.entrada;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seven4n.prueba.excepciones.EntradaException;
import com.seven4n.prueba.excepciones.MapaException;
import com.seven4n.prueba.mapa.Mapa;
import com.seven4n.prueba.mapa.MapaMarte;

/**
 * @author Jorge
 *
 */
public class EntradaAmenazas extends BaseEntrada implements EntradaDatos<Mapa> {
	
	private static final Logger logger = LoggerFactory.getLogger(EntradaAmenazas.class);
	
	private static final String PATRON_ENTRADA = "\\([0-9],[0-9]\\).";
	
	private final Mapa mapa;

	/**
	 * @param mapa
	 */
	public EntradaAmenazas(int x, int y) {
		super();
		this.mapa = new MapaMarte(y, x);
	}

	/* (non-Javadoc)
	 * @see com.seven4n.prueba.entrada.EntradaDatos#procesarEntrada(java.lang.String)
	 */
	public Mapa procesarEntrada(String file) throws EntradaException {
		File archivoEntrada = new File(file);
		Scanner scanner = null;
		
		if(!archivoEntrada.exists())
			throw new EntradaException("Archivo de amenazas no existe: " + file);
		
		try {
			scanner = new Scanner(archivoEntrada);
			scanner.useDelimiter("line.separator");
			
			while(scanner.hasNext()){
				String linea = scanner.nextLine();
				if(validarLinea(PATRON_ENTRADA, linea)){
					int x = Integer.parseInt(linea.substring(1, 2));
					int y = Integer.parseInt(linea.substring(3,4));
					char amenaza = linea.charAt(5);
					
					this.mapa.setAmenaza(x, y, amenaza);
				}else{
					logger.error("La línea ingresada no es válida: " + linea);
					throw new EntradaException("La línea ingresada no es válida: " + linea);
				}
			}
		} catch (FileNotFoundException e) {
			throw new EntradaException("No se pudo cargar el archivo de amenazas: " + e.getMessage());
		} catch (MapaException e) {
			throw new EntradaException("Datos de entrada inválidos: " + e.getMessage());
		} finally{
			if(scanner != null)
				scanner.close();
		}
		
		return mapa;
	}

}
