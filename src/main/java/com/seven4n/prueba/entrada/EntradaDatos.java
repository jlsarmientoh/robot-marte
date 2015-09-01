package com.seven4n.prueba.entrada;

import com.seven4n.prueba.excepciones.EntradaException;

public interface EntradaDatos<T> {

	public T procesarEntrada(String file) throws EntradaException;
}
