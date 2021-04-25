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

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	HotelRepository repository;
	
	@GetMapping
	public List<Hotel> getAll(){
		return repository.findAll();
	}
	
	@GetMapping("{matricula}")
	public Hotel getById(@PathVariable Integer matricula){
	   Hotel hotel = repository.findById(matricula)
	   .orElseThrow
	   (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel com esta matricula nao encontrado."));
		
		return hotel;
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Hotel save(@RequestBody @Valid Hotel hotel) {
		return repository.save(hotel);
	}
	
	@PutMapping
	public Hotel update(@RequestBody @Valid Hotel hotel) {
		return repository.save(hotel);
	}
	
	@DeleteMapping("{matricula}")
	public Hotel delete(@PathVariable Integer matricula) {
		Hotel hotel = repository.findById(matricula).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel com esta matricula nao encontrado."));
		repository.delete(hotel);
		return hotel;
	}
	
	
	
}
