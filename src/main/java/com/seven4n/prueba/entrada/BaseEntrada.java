package com.seven4n.prueba.entrada;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseEntrada {
	
	/**
	 * Valida si la l&iacute;nea conincide con el patr&oacute;n dado
	 * @param regex
	 * @param linea
	 * @return
	 */
	protected boolean validarLinea(String regex, String linea){
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(linea);
		
		return m.matches();
	}
}
