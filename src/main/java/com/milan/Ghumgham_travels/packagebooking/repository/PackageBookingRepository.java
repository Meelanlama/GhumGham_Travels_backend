package com.milan.Ghumgham_travels.packagebooking.repository;

import com.milan.Ghumgham_travels.hotelpackage.model.entity.Package;
import com.milan.Ghumgham_travels.packagebooking.model.entity.PackageBooking;
import com.milan.Ghumgham_travels.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageBookingRepository extends JpaRepository<PackageBooking,Integer> {

    List<PackageBooking> findByBookedBy(User user);

    @Query("From PackageBooking p where p.aPackages=:packages")
    List<PackageBooking> findByAPackages(@Param("packages") Package packagea);
}
