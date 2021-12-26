package com.parking.management.service;

import com.parking.management.dto.ParkingSpaceAvailableDTO;
import com.parking.management.dto.ParkingSpaceUnavailableDTO;
import com.parking.management.model.ParkingSpace;

import java.util.List;

public interface ParkingSpaceService {
    public void createParkingSpace();
    public List<ParkingSpace> listParkingSpace();
    public List<ParkingSpaceAvailableDTO> listParkingSpaceAvailable();
    public List<ParkingSpaceUnavailableDTO> listParkingSpaceUnavailable();

}
