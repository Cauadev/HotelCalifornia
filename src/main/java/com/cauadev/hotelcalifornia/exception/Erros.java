package com.cauadev.hotelcalifornia.exception;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author CAUADEV
 *
 */

/*
 * Class que sera mapeada e transformada em json lancando os erros atribuidos a ela
 */
public class Erros {
	
	public List<String> erros;
	
	public Erros() {}
	
	public Erros(String... message) {
		this.erros = Arrays.asList(message);
	}
	
	public Erros(List<String> message) {
		this.erros = message;
	}

}
