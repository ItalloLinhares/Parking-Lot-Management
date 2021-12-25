package com.parking.management.model;

import com.parking.management.parkingSpaceStatus.ParkingSpaceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity @Data
@AllArgsConstructor
public class ParkingSpaceModel {
    @Id
    private Long id;
    @OneToOne
    private CarModel carro;
    private Long clientCpf;
    private ParkingSpaceStatus parkingSpaceStatus;
    private int hourEntry;
    private int minuteEntry;


}
