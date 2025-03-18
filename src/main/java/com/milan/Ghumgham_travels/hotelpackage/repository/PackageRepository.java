package com.milan.Ghumgham_travels.hotelpackage.repository;

import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import com.milan.Ghumgham_travels.hotelpackage.model.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<Package,Integer> {

    List<Package> findByHotel(Hotel hotel);
}
