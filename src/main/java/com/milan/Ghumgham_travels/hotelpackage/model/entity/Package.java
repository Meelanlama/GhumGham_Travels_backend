package com.milan.Ghumgham_travels.hotelpackage.model.entity;

import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String packageName;

    private String packageDesc;

    private float price;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Hotel hotel;

}
