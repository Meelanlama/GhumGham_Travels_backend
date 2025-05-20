package com.milan.Ghumgham_travels.Support.repository;

import com.milan.Ghumgham_travels.Support.model.entity.Support;
import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupportRepository extends JpaRepository<Support,Integer> {

    List<Support> findByHotel(Hotel hotel);
}
