package com.cauadev.hotelcalifornia.services;

import com.cauadev.hotelcalifornia.dto.ClienteDTO;
import com.cauadev.hotelcalifornia.model.Cliente;

public interface ClienteService {
	
	Cliente save(ClienteDTO dto);
}
