package com.parking.management.service;

import com.parking.management.model.ParkingSpaceModel;
import com.parking.management.parkingSpaceStatus.ParkingSpaceStatus;
import com.parking.management.repository.ParkingSpaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service @AllArgsConstructor
public class ParkingSpaceServiceImplementation implements ParkingSpaceService{
    private final ParkingSpaceRepository parkingSpaceRepository;

    @Override
    public void createParkingSpace() {
        ParkingSpaceModel parkingSpaceModel;
        for (int id = 1; id ==25; id++){
            parkingSpaceModel = new ParkingSpaceModel(Long.valueOf(id), null, null, ParkingSpaceStatus.AVAILABLE, 0, 0);
            //parkingSpaceModel.setParkingSpaceStatus(ParkingSpaceStatus.AVAILABLE);
            parkingSpaceRepository.save(parkingSpaceModel);
        }
    }
}
