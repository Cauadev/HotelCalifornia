package com.cauadev.hotelcalifornia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	private String cpf;
	
	private String nome;
	
	private String fone;
	
	private String email;
	
	@OneToOne
	@JoinColumn(name = "hotel_matricula")
	private Hotel hotel;
	
	
}
