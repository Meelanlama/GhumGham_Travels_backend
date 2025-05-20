package com.milan.Ghumgham_travels.Support.service;

import com.milan.Ghumgham_travels.Support.model.dto.SupportDto;
import com.milan.Ghumgham_travels.Support.model.entity.Support;

import java.util.List;

public interface SupportInterface {

    Support saveSupport(SupportDto dto);

    List<Support> findByHotelId(int hotelId);

    List<Support> findAll();

    void deleteById( int id);
}
