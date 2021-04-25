package com.cauadev.hotelcalifornia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Cliente save(Cliente cliente) {
		int ID_HOTEL = cliente.getHotel().getMatricula();
		Hotel hotel = hotelRepository.findById(ID_HOTEL)
				.orElseThrow(() -> new RegraDeNegocioException("Matricula de hotel invalida."));
		
		Cliente CLIENTE = Cliente.builder()
				     		.cpf(cliente.getCpf())
				     		.nome(cliente.getNome())
				     		.email(cliente.getEmail())
				     		.fone(cliente.getFone())
				     		.hotel(hotel)
				     		.build();
		
		return repository.save(CLIENTE);
	}

}
