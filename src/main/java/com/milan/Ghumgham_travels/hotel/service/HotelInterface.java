package com.milan.Ghumgham_travels.hotel.service;

import com.milan.Ghumgham_travels.hotel.model.dto.HotelDto;
import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HotelInterface {

    Hotel save(HotelDto dto);

    Page<Hotel> getHotels(int page, int size, int id);

    List<Hotel> getAll();

    Hotel getHotelById(int id);

    Hotel getHotelByLoggedInUser();

    void hotelDelete(int id);
}
