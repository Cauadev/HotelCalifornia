package com.cauadev.hotelcalifornia.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClienteDTO {
	
	@CPF(message = "Este cpf é inválido.")
	@NotEmpty(message = "Campo cpf obrigatorio")
	private String cpf;
	
	@NotEmpty(message = "Campo nome obrigatorio")
	private String nome;
	
	@NotEmpty(message = "Campo fone obrigatorio")
	private String fone;
	
	@NotEmpty(message = "Campo email obrigatorio")
	@Email(message = "Email inválido")
	private String email;
	
	@NotNull(message = "Campo hotel obrigatorio")
	private Integer hotel;
	

}
