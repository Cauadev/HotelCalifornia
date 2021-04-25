package com.cauadev.hotelcalifornia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class Hotel {
	
	/*
	 * Especifica a chave primaria 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer matricula;
	
	@NotEmpty(message = "Campo nome obrigatorio")
	private String nome;
	
	@NotNull(message = "Campo valor_Diaria obrigatorio")
	private Float valorDiaria;
	
	@NotEmpty(message = "Campo cidade obrigatorio")
	private String cidade;
	
	
	//define o valor maximo e min de estrelas
	@NotNull(message = "Campo estrelas obrigatorio")
	@Min(value = 0, message = "Valor minimo de estrelas é 0")
	@Max(value = 10, message = "Valor máximo de estrelas é 10")
	private Float estrelas;
	
}
