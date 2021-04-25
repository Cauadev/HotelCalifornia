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

import com.cauadev.hotelcalifornia.dto.ClienteDTO;
import com.cauadev.hotelcalifornia.model.Cliente;
import com.cauadev.hotelcalifornia.repository.ClienteRepository;
import com.cauadev.hotelcalifornia.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService service;
	
	@Autowired
	ClienteRepository repository;
	
	@GetMapping
	public List<Cliente> getAll(){
		return repository.findAll();
	}
	
	@GetMapping("{cpf}")
	public Cliente getById(@PathVariable String cpf){
	   Cliente Cliente = repository.findById(cpf)
	   .orElseThrow
	   (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente com este cpf nao encontrado."));
		
		return Cliente;
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cliente save(@RequestBody @Valid ClienteDTO cliente) {
		return service.save(cliente);
	}
	
	@PutMapping
	public Cliente update(@RequestBody @Valid Cliente cliente) {
		return repository.save(cliente);
	}
	
	@DeleteMapping("{cpf}")
	public Cliente delete(@PathVariable String cpf) {
		Cliente cliente = repository.findById(cpf).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente com este cpf nao encontrado."));
		repository.delete(cliente);
		return cliente;
	}
	
}
