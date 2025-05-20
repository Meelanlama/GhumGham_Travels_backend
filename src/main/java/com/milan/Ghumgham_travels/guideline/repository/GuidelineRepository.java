package com.milan.Ghumgham_travels.guideline.repository;

import com.milan.Ghumgham_travels.guideline.model.entity.Guideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuidelineRepository extends JpaRepository<Guideline,Integer> {
}
