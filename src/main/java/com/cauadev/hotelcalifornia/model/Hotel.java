package com.cauadev.hotelcalifornia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer matricula;
	
	@NotEmpty(message = "Campo nome obrigatorio")
	private String nome;
	
	@NotNull(message = "Campo valor_Diaria obrigatorio")
	private Float valorDiaria;
	
	@NotEmpty(message = "Campo cidade obrigatorio")
	private String cidade;
	
	@NotNull(message = "Campo estrelas obrigatorio")
	private Float estrelas;
	
}