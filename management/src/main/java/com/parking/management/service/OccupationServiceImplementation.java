package com.parking.management.service;

import com.parking.management.dto.ParkingSpaceAvailableDTO;
import com.parking.management.model.Occupation;
import com.parking.management.model.ParkingSpace;
import com.parking.management.repository.OccupationRepository;
import com.parking.management.repository.ParkingSpaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service @Transactional @AllArgsConstructor
public class OccupationServiceImplementation implements OccupationService{
    private final ParkingSpaceRepository parkingSpaceRepository;
    private final OccupationRepository occupationRepository;

    @Override
    public ResponseEntity saveOccupation(ParkingSpaceAvailableDTO parkingSpaceAvailableDTO) {
        Optional<ParkingSpace> parkingSpaceid = parkingSpaceRepository.findById(parkingSpaceAvailableDTO.getId());
        if (parkingSpaceid.isPresent()){
            Occupation occupation = new Occupation();
            occupation.setCar(parkingSpaceid.get().getCar());
            occupation.setClientCpf(parkingSpaceid.get().getClientCpf());
            occupation.setHourEntry(parkingSpaceid.get().getHourEntry());
            occupation.setMinuteEntry(parkingSpaceid.get().getMinuteEntry());
            occupation.setHourExit(parkingSpaceAvailableDTO.getHourExit());
            occupation.setMinuteExit(parkingSpaceAvailableDTO.getMinuteEntry());
            float price = (parkingSpaceAvailableDTO.getHourExit()- parkingSpaceid.get().getHourEntry())*60;
                    //+(parkingSpaceAvailableDTO.getHourExit() - parkingSpaceid.get().getMinuteEntry());
            occupation.setPrice(price);
            occupationRepository.save(occupation);
            return ResponseEntity.ok(occupation);
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Didn't work");
        }
    }



}
