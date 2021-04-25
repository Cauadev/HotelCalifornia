package com.cauadev.hotelcalifornia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cauadev.hotelcalifornia.model.Hotel;
import com.cauadev.hotelcalifornia.repository.HotelRepository;

/**
 * 
 * @author CAUADEV
 *
 */

//define controlador como rest
@RestController
//seta o endpoint principal da aplicacao ex: http://localhost:8080/hotel
@RequestMapping("/hotel")
public class HotelController {
	
	/*
	 * utilizando a anotacao @autowired para criar pontos de injecao de dependencia
	 * e o spring assumir o controle da instancia.
	 */
	
	@Autowired
	HotelRepository repository;
	
	
	//endpoint para retornar lista de hotel
	@GetMapping
	public List<Hotel> getAll(){
		return repository.findAll();
	}
	
	//endpoint achar hotel por matricula
	@GetMapping("{matricula}")
	public Hotel getById(@PathVariable Integer matricula){
		
		   /*
		    * puxa o hotel por matricula e verifica se ele existe
		    * se existir lanca o code 200 OK
		    * se nao lanca uma exception e o code 404
		    */
		
	   Hotel hotel = repository.findById(matricula)
	   .orElseThrow
	   (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel com esta matricula nao encontrado."));
		
		return hotel;
	}
	
	
	   /*
	    * Cria um hotel puxando os dados do body da requisicao
	    * e valida os dados conforme as anotacoes passadas na entidade
	    */
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Hotel save(@RequestBody @Valid Hotel hotel) {
		return repository.save(hotel);
	}
	
	   /*
	    * Atualiza o cliente
	    */
	
	@PutMapping
	public Hotel update(@RequestBody @Valid Hotel hotel) {
		return repository.save(hotel);
	}
	
	   /*
	    * Deleta o hotel buscando por matricula
	    */
	
	
	@DeleteMapping("{matricula}")
	public Hotel delete(@PathVariable Integer matricula) {
		
		/*
		 *Verifica se o hotel existe e depois deleta 
		 */
		
		Hotel hotel = repository.findById(matricula).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel com esta matricula nao encontrado."));
		repository.delete(hotel);
		return hotel;
	}
	
	
	
}
