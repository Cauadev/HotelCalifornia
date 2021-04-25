package com.cauadev.hotelcalifornia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cauadev.hotelcalifornia.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
