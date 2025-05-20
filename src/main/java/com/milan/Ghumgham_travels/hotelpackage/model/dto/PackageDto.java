package com.milan.Ghumgham_travels.hotelpackage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PackageDto {

    private int id;

    private String packageName;

    private String packageDesc;

    private float price;

    private int hotelId;
}
