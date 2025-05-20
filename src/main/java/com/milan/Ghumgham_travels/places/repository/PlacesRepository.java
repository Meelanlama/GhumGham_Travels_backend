package com.milan.Ghumgham_travels.places.repository;

import com.milan.Ghumgham_travels.places.model.entity.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacesRepository extends JpaRepository<Places,Integer> {
}
