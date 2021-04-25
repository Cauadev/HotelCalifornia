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


/**
 * 
 * @author CAUADEV
 *
 */

//define controlador como rest
@RestController
//seta o endpoint principal da aplicacao ex: http://localhost:8080/cliente
@RequestMapping("/cliente")
public class ClienteController {
	
	/*
	 * utilizando a anotacao @autowired para criar pontos de injecao de dependencia
	 * e o spring assumir o controle da instancia.
	 */
	@Autowired
	ClienteService service;
	
	@Autowired
	ClienteRepository repository;
	
	
	//endpoint para retornar lista de clientes
	@GetMapping
	public List<Cliente> getAll(){
		return repository.findAll();
	}
	
	//endpoint achar cliente por cpf
	@GetMapping("{cpf}")
	public Cliente getById(@PathVariable String cpf){
		
	   /*
	    * puxa o cliente por cpf e verifica se ele existe
	    * se existir lanca o code 200 OK
	    * se nao lanca uma exception e o code 404
	    */
		
	   Cliente Cliente = repository.findById(cpf)
	   .orElseThrow
	   (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente com este cpf nao encontrado."));
		
		return Cliente;
	}
	
	
	   /*
	    * Cria um cliente puxando os dados do body da requisicao
	    * e valida os dados conforme as anotacoes passadas na entidade
	    */
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cliente save(@RequestBody @Valid ClienteDTO cliente) {
		return service.save(cliente);
	}
	
	   /*
	    * Atualiza o cliente
	    */
	
	@PutMapping
	public Cliente update(@RequestBody @Valid Cliente cliente) {
		return repository.save(cliente);
	}
	
	
	   /*
	    * Deleta o cliente buscando por cpf
	    */
	
	@DeleteMapping("{cpf}")
	public Cliente delete(@PathVariable String cpf) {
		/*
		 *Verifica se o cliente existe e depois deleta 
		 */
		Cliente cliente = repository.findById(cpf).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente com este cpf nao encontrado."));
		repository.delete(cliente);
		return cliente;
	}
	
}
