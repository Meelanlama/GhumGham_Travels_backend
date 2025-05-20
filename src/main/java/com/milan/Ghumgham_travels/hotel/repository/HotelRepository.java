package com.milan.Ghumgham_travels.hotel.repository;

import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import com.milan.Ghumgham_travels.places.model.entity.Places;
import com.milan.Ghumgham_travels.user.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {


    Page<Hotel> findByPlaces(Places places, Pageable pageable);

    List<Hotel> findByPlaces(Places places);

    @Query("From Hotel h where h.owned_by=:user")
    List<Hotel> findByOwned_by(@Param("user") User user);


}
