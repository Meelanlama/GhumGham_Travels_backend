package com.milan.Ghumgham_travels.places.service;

import com.milan.Ghumgham_travels.places.model.dto.PlacesDto;
import com.milan.Ghumgham_travels.places.model.entity.Places;

import java.util.List;

public interface PlacesInterface {

    Places savePlaces(PlacesDto dto);

    public List<Places> getPlaces();

    Places getById(int id);

    void deleteById(int id);
}
