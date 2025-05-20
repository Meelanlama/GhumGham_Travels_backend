package com.milan.Ghumgham_travels.hotel.model.entity;

import com.milan.Ghumgham_travels.user.model.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HotelReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int rating;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;

    private String reviewDesc;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User reviewBy;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Hotel hotel;


}
