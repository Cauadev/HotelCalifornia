package com.cauadev.hotelcalifornia.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;


/**
 * 
 * @author CAUADEV
 *
 */

//anotacao para definir esta class como gerenciador das exceptions registradas
@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	//definindo qual a exception capturar
	@ExceptionHandler(MethodArgumentNotValidException.class)
	//status retornado
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Erros handleMethodValidException(MethodArgumentNotValidException argumentNotValidException) {
		
		//iterando lista de erros utilizando o StreamAPI e retornando
		List<String> errors = argumentNotValidException.getBindingResult().getAllErrors().stream()
		.map(erro -> erro.getDefaultMessage()).collect(Collectors.toList());
		
		return new Erros(errors);
	}
	
	@ExceptionHandler(RegraDeNegocioException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Erros handlePostException(RegraDeNegocioException postException) {
		return new Erros(postException.getMessage());
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public Erros handlePostException(ResponseStatusException exception) {
		return new Erros(exception.getReason(), exception.getStatus().toString());
	}
}
