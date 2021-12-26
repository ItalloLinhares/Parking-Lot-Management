package com.parking.management.model;

import com.parking.management.status.ParkingSpaceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
public class ParkingSpace {
    @Id
    private Long id;
    @OneToOne
    private Car carro;
    private Long clientCpf;
    private ParkingSpaceStatus parkingSpaceStatus;
    private int hourEntry;
    private int minuteEntry;


}
