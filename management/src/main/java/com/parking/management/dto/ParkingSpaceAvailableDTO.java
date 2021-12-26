package com.parking.management.dto;

import com.parking.management.status.ParkingSpaceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ParkingSpaceAvailableDTO {
    private Long id;
    private ParkingSpaceStatus parkingSpaceStatus;
}
