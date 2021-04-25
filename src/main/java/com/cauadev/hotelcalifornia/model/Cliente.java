package com.cauadev.hotelcalifornia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
	
	@Id
	@CPF(message = "Este cpf é inválido.")
	private String cpf;
	
	@NotEmpty(message = "Campo nome obrigatorio")
	private String nome;
	
	@NotEmpty(message = "Campo fone obrigatorio")
	private String fone;
	
	@NotEmpty(message = "Campo email obrigatorio")
	private String email;
	
	@OneToOne
	@JoinColumn(name = "hotel_matricula")
	private Hotel hotel;
	
	
}
