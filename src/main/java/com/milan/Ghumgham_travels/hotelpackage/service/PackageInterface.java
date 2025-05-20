package com.milan.Ghumgham_travels.hotelpackage.service;

import com.milan.Ghumgham_travels.hotelpackage.model.dto.PackageDto;
import com.milan.Ghumgham_travels.hotelpackage.model.entity.Package;

import java.util.List;

public interface PackageInterface {

    List<Package> getByHotelId(int hotelId);

    Package savePackage(PackageDto dto);

    void deleteById( int id);

    Package getById(int id);
}
