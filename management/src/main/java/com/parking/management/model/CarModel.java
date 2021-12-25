package com.parking.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data @Entity @AllArgsConstructor
public class CarModel {
    @Id
    private String carLicensePlate;
    private String carModelName;

}
