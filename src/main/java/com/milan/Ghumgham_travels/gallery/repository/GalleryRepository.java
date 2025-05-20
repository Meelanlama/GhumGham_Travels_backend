package com.milan.Ghumgham_travels.gallery.repository;

import com.milan.Ghumgham_travels.gallery.model.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery,Integer> {
}
