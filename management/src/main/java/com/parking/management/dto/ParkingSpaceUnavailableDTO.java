package com.parking.management.dto;

import com.parking.management.model.Car;
import com.parking.management.status.ParkingSpaceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;

@Data @AllArgsConstructor @NoArgsConstructor
public class ParkingSpaceUnavailableDTO {
    private Long id;
    private ParkingSpaceStatus parkingSpaceStatus;
    @OneToOne
    private Car carro;
    private Long clientCpf;
    private int hourEntry;
    private int minuteEntry;
}
