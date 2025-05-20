package com.milan.Ghumgham_travels.places.service.impl;

import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import com.milan.Ghumgham_travels.hotel.repository.HotelRepository;
import com.milan.Ghumgham_travels.hotel.service.HotelInterface;
import com.milan.Ghumgham_travels.places.model.dto.PlacesDto;
import com.milan.Ghumgham_travels.places.model.entity.Places;
import com.milan.Ghumgham_travels.places.repository.PlacesRepository;
import com.milan.Ghumgham_travels.places.service.PlacesInterface;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacesImpl implements PlacesInterface {

    @Autowired
    PlacesRepository repo;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelInterface hotelInterface;

    @Override
    public Places savePlaces(PlacesDto dto){
        Places places = DtoConverter.convert(dto);
        return repo.save(places);
    }

    @Override
    public List<Places> getPlaces(){
        return repo.findAll();
    }

    @Override
    public Places getById(int id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id){
        Places places = new Places();
        places.setId(id);
        List<Hotel> hotels = hotelRepository.findByPlaces(places);
        for (Hotel hotel: hotels){
            hotelInterface.hotelDelete(hotel.getId());
        }
        repo.delete(places);
    }
}
