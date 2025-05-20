package com.milan.Ghumgham_travels.hotel.repository;


import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import com.milan.Ghumgham_travels.hotel.model.entity.HotelReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelReviewRepository extends JpaRepository<HotelReview,Integer> {

    List<HotelReview> findByHotelOrderByIdDesc(Hotel hotel);

}
