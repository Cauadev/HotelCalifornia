package com.cauadev.hotelcalifornia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cauadev.hotelcalifornia.dto.ClienteDTO;
import com.cauadev.hotelcalifornia.exception.RegraDeNegocioException;
import com.cauadev.hotelcalifornia.model.Cliente;
import com.cauadev.hotelcalifornia.model.Hotel;
import com.cauadev.hotelcalifornia.repository.ClienteRepository;
import com.cauadev.hotelcalifornia.repository.HotelRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	ClienteRepository repository;

	@Override
	@Transactional
	public Cliente save(ClienteDTO dto) {
		int ID_HOTEL = dto.getHotel();
		Hotel hotel = hotelRepository.findById(ID_HOTEL)
				.orElseThrow(() -> new RegraDeNegocioException("Matricula de hotel invalida."));
		
		Cliente CLIENTE = Cliente.builder()
				     		.cpf(dto.getCpf())
				     		.nome(dto.getNome())
				     		.email(dto.getEmail())
				     		.fone(dto.getFone())
				     		.hotel(hotel)
				     		.build();
		
		return repository.save(CLIENTE);
	}

}
