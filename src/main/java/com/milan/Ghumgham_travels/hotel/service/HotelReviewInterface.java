package com.milan.Ghumgham_travels.hotel.service;

import com.milan.Ghumgham_travels.hotel.model.dto.HotelReviewDto;
import com.milan.Ghumgham_travels.hotel.model.entity.HotelReview;

import java.util.List;

public interface HotelReviewInterface {

    List<HotelReview> getByHotelId(int id);

    HotelReview saveHotelReview(HotelReviewDto dto);

    void deleteHotelReview(int id);
}
