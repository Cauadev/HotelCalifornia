package com.cauadev.hotelcalifornia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cauadev.hotelcalifornia.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
