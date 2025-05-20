package com.milan.Ghumgham_travels.user.repository;

import com.milan.Ghumgham_travels.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
