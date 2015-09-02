package com.seven4n.prueba.entrada;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seven4n.prueba.excepciones.EntradaException;
import com.seven4n.prueba.excepciones.RobotException;
import com.seven4n.prueba.mapa.Mapa;
import com.seven4n.prueba.mapa.MapaMarte;
import com.seven4n.prueba.robot.Robot;
import com.seven4n.prueba.robot.RobotBum;

public class EntradaMovimientos extends BaseEntrada implements EntradaDatos<List<Robot>> {
	
	private static final Logger logger = LoggerFactory.getLogger(EntradaMovimientos.class);
	
	private static final String PATRON_ENTRADA_LIMITES = "[0-9] [0-9]";
	private static final String PATRON_ENTRADA_POSICION_INICIAL = "[0-9] [0-9] [NSEW]";
	private static final String PATRON_ENTRADA_MOVIMIENTOS = "[IDA]+";

	private EntradaDatos<Mapa> entradaAmenazas;
	
	private final String pathToAmenazas;

	/**
	 * @param pathToAmenazas
	 */
	public EntradaMovimientos(String pathToAmenazas) {
		super();
		this.pathToAmenazas = pathToAmenazas;
	}

	public List<Robot> procesarEntrada(String file) throws EntradaException {
		List<Robot> robots = new ArrayList<Robot>();
		Robot tmpRobot = null;
		Mapa mapa = null;
		File archivoEntrada = new File(file);
		Scanner scanner = null;
		
		if(!archivoEntrada.exists())
			throw new EntradaException("Archivo de amenazas no existe: " + file);
		
		try {
			scanner = new Scanner(archivoEntrada);
			scanner.useDelimiter("line.separator");
			
			for(int i = 0; scanner.hasNext(); i++){
				String linea = scanner.nextLine();
				if(i == 0){
					if(!validarLinea(PATRON_ENTRADA_LIMITES, linea))
						throw new EntradaException("La línea de limites no es válida: " + linea);
					
					int x = Integer.parseInt(linea.substring(0, 1));
					int y = Integer.parseInt(linea.substring(2, linea.length()));
					
					this.entradaAmenazas = new EntradaAmenazas(x,y);
					mapa = this.entradaAmenazas.procesarEntrada(this.pathToAmenazas);
					continue;
				}
				if((i % 2) != 0){
					if(!validarLinea(PATRON_ENTRADA_POSICION_INICIAL, linea))
						throw new EntradaException("La línea de posición inicial no es válida: " + linea);
					
					int x = Integer.parseInt(linea.substring(0, 1));
					int y = Integer.parseInt(linea.substring(2,3));
					char orientacion = linea.charAt(4);
					
					tmpRobot = new RobotBum(mapa);
					tmpRobot.setPosicionInicial(x, y, orientacion);
					
					robots.add(tmpRobot);
					continue;
				}
				if((i % 2) == 0){
					if(!validarLinea(PATRON_ENTRADA_MOVIMIENTOS, linea))
						throw new EntradaException("La línea de movimientos no es válida: " + linea);
					
					char[] acciones = linea.toCharArray();
					
					for(char accion : acciones){
						tmpRobot.moverse(accion);
					}
					continue;
				}
			}
		} catch (FileNotFoundException e) {
			throw new EntradaException("No se pudo cargar el archivo de movimientos: " + e.getMessage());
		} catch (RobotException e) {
			throw new EntradaException("Datos de entrada inválidos: " + e.getMessage());
		} finally{
			if(scanner != null)
				scanner.close();
		}
		
		return robots;
	}
}
