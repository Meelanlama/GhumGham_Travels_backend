package com.milan.Ghumgham_travels.packagebooking.service.impl;

import com.milan.Ghumgham_travels.hotelpackage.model.entity.Package;
import com.milan.Ghumgham_travels.hotelpackage.repository.PackageRepository;
import com.milan.Ghumgham_travels.packagebooking.model.dto.PackageBookingDto;
import com.milan.Ghumgham_travels.packagebooking.model.entity.PackageBooking;
import com.milan.Ghumgham_travels.packagebooking.repository.PackageBookingRepository;
import com.milan.Ghumgham_travels.packagebooking.service.PackageBookingInterface;
import com.milan.Ghumgham_travels.roombooking.model.entity.RoomBookingStatus;
import com.milan.Ghumgham_travels.security.MyUserDetails;
import com.milan.Ghumgham_travels.user.model.entity.User;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.exceptions.SendErrorMessageCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageBookingImpl implements PackageBookingInterface {

    @Autowired
    PackageBookingRepository repo;

    @Autowired
    PackageRepository packageRepository;

    @Override
    public PackageBooking savePackageBooking(PackageBookingDto dto){
        PackageBooking packageBooking = DtoConverter.convert(dto);
        packageBooking.setStatus(RoomBookingStatus.Pending);
        packageBooking.setBookedBy(getLoggedInUser());
        packageBooking.setAPackages(packageRepository.findById(dto.getPackageId()).orElseThrow(()->new SendErrorMessageCustom("No Room Of Such")));
        return repo.save(packageBooking);
    }

    @Override
    public List<PackageBooking> getByLoggedInUser(){

            User loggedInUser = getLoggedInUser();
            return repo.findByBookedBy(loggedInUser);

    }

    @Override
    public PackageBooking changeStatus(int packageId, RoomBookingStatus status){
        PackageBooking packageBooking = repo.findById(packageId).orElseThrow(()-> new SendErrorMessageCustom("No Room Of Such Id"));
        packageBooking.setStatus(status);
        return repo.save(packageBooking);
    }

    @Override
    public List<PackageBooking> getByPackageId(int packagesId){
        Package packages = new Package();
        packages.setId(packagesId);
        return repo.findByAPackages(packages);
    }

    @Override
    public List<PackageBooking> getAll(){
        return repo.findAll();
    }

    @Override
    public PackageBooking getById(int id){
        return repo.findById(id).orElse(null);
    }


    public User getLoggedInUser(){
        try {
            return ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getUser();
        }catch (Exception ex){
            throw new SendErrorMessageCustom("User is not logged in ");
        }
    }
}
