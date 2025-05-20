package com.milan.Ghumgham_travels.hotelpackage.service.impl;

import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import com.milan.Ghumgham_travels.hotel.repository.HotelRepository;
import com.milan.Ghumgham_travels.hotelpackage.model.dto.PackageDto;
import com.milan.Ghumgham_travels.hotelpackage.model.entity.Package;
import com.milan.Ghumgham_travels.hotelpackage.repository.PackageRepository;
import com.milan.Ghumgham_travels.hotelpackage.service.PackageInterface;
import com.milan.Ghumgham_travels.packagebooking.repository.PackageBookingRepository;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageImpl implements PackageInterface {

@Autowired
    PackageRepository repository;

@Autowired
    HotelRepository hotelRepository;

@Autowired
    PackageBookingRepository packageBookingRepository;

public Package savePackage(PackageDto dto){
    Package packagess = DtoConverter.convert(dto);
    packagess.setHotel(hotelRepository.findById(dto.getHotelId()).orElse(null));
    return repository.save(packagess);
}

@Override
    public void deleteById( int id){
    Package packages = repository.findById(id).orElse(null);
        packageBookingRepository.deleteAll(packageBookingRepository.findByAPackages(packages));
        repository.delete(packages);
    }

    @Override
public List<Package> getByHotelId(int hotelId){
    Hotel hotel = hotelRepository.findById(hotelId).orElse(null);
    return repository.findByHotel(hotel);
}

@Override
public Package getById(int id){
    return repository.findById(id).orElse(null);
}




}
