package com.milan.Ghumgham_travels.hotel.model.entity;

import com.milan.Ghumgham_travels.places.model.entity.Places;
import com.milan.Ghumgham_travels.user.model.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String hotelName;

    private int ratings;

    private String filename;

    @Column(length = 10000)
    private String hotelDesc;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Places places;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User owned_by;



}
