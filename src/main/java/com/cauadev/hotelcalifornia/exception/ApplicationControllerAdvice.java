package com.cauadev.hotelcalifornia.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Erros handleMethodValidException(MethodArgumentNotValidException argumentNotValidException) {
		
		List<String> errors = argumentNotValidException.getBindingResult().getAllErrors().stream()
		.map(erro -> erro.getDefaultMessage()).collect(Collectors.toList());
		
		return new Erros(errors);
	}
	
	@ExceptionHandler(RegraDeNegocioException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Erros handlePostException(RegraDeNegocioException postException) {
		return new Erros(postException.getMessage());
	}
	
}
