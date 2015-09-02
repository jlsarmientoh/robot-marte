package com.seven4n.prueba;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.seven4n.prueba.entrada.EntradaDatos;
import com.seven4n.prueba.entrada.EntradaMovimientos;
import com.seven4n.prueba.excepciones.EntradaException;
import com.seven4n.prueba.excepciones.RobotException;
import com.seven4n.prueba.robot.Robot;

public class MarteEntryPoint implements EntryPoint {
	
	private static final Logger logger = LoggerFactory.getLogger(MarteEntryPoint.class);
	
	private final String pathToAmenazas;
	
	private final String pathToMovimientos;

	/**
	 * @param pathToAmenazas
	 * @param pathToMovimientos
	 */
	public MarteEntryPoint(String pathToAmenazas, String pathToMovimientos) {
		super();
		this.pathToAmenazas = pathToAmenazas;
		this.pathToMovimientos = pathToMovimientos;
	}
	
	/* (non-Javadoc)
	 * @see com.seven4n.prueba.EntryPoint#execute()
	 */
	public void execute(){
		List<Robot> robots = null;
		
		EntradaDatos<List<Robot>> entradaMovimientos = new EntradaMovimientos(this.pathToAmenazas);
		
		try {
			robots = entradaMovimientos.procesarEntrada(this.pathToMovimientos);
			
			for(Robot robot : robots){
				System.out.println(robot.getPosicion());
				System.out.println("Amenazas detectadas: " + robot.getAmenazas());
				logger.info(robot.getPosicion());
				logger.info("Amenazas detectadas: " + robot.getAmenazas());
			}
			
		} catch (EntradaException e) {
			logger.error("No se puede ejecutar la misión, revise los datos de la misión: " + e.getMessage());
			System.out.println("No se puede ejecutar la misión, revise los datos de la misión: " + e.getMessage());
		} catch (RobotException e) {
			logger.error("Algo anda mal con el robot: " + e.getMessage());
			System.out.println("Algo anda mal con el robot: " + e.getMessage());
		}
	}
}
