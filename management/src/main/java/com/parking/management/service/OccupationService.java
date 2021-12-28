package com.parking.management.service;

import com.parking.management.dto.ParkingSpaceAvailableDTO;
import org.springframework.http.ResponseEntity;

public interface OccupationService {
    public ResponseEntity saveOccupation(ParkingSpaceAvailableDTO parkingSpaceAvailableDTO);
}
