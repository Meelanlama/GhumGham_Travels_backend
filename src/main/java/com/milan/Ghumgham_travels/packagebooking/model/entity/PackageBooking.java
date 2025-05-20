package com.milan.Ghumgham_travels.packagebooking.model.entity;

import com.milan.Ghumgham_travels.hotelpackage.model.entity.Package;
import com.milan.Ghumgham_travels.roombooking.model.entity.RoomBookingStatus;
import com.milan.Ghumgham_travels.user.model.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class PackageBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float payment;

    @Enumerated(EnumType.STRING)
    private RoomBookingStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDate;

    private String additionalRequest;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Package aPackages;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User bookedBy;
}
