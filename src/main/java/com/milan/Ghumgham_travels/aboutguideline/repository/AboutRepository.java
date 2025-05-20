package com.milan.Ghumgham_travels.aboutguideline.repository;

import com.milan.Ghumgham_travels.aboutguideline.model.entity.AboutUsManage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<AboutUsManage,Integer> {
}
