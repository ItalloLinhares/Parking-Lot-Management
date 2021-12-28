package com.parking.management.model;

import com.parking.management.annotation.CarLicensePlate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data @Entity @AllArgsConstructor @NoArgsConstructor
public class Car {
    @Id @CarLicensePlate
    private String carLicensePlate;
    private String carModelName;
}
