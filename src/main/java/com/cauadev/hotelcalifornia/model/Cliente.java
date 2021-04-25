package com.cauadev.hotelcalifornia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 
 * @author CAUADEV
 * 
 */

//define como uma entidade a ser espelhada com a tabela do DB
@Entity
//da algumas coisas como toString,getters,setters...
@Data
//cria um construtor com todos os argumentos
@AllArgsConstructor
//cria um construtor vazio
@NoArgsConstructor
@Builder
public class Cliente {
	
	/*
	 * Especifica a chave primaria 
	 */
	@Id
	private String cpf;
	
	private String nome;
	
	private String fone;
	
	private String email;
	
	/*
	 * Utilizando anotacao para relacionamentos entre objetos e deixar no DB como uma chave estrangeira
	 */
	@OneToOne
	@JoinColumn(name = "hotel_matricula")
	private Hotel hotel;
	
	
}
