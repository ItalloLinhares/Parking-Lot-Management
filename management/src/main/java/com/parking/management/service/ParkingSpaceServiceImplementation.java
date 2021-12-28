package com.parking.management.service;

import com.parking.management.dto.ParkingSpaceAvailableDTO;
import com.parking.management.dto.ParkingSpaceUnavailableDTO;
import com.parking.management.model.ParkingSpace;
import com.parking.management.repository.ParkingSpaceRepository;
import com.parking.management.status.ParkingSpaceStatus;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Consumer;

import static com.parking.management.status.ParkingSpaceStatus.AVAILABLE;
import static com.parking.management.status.ParkingSpaceStatus.UNAVAILABLE;

@Transactional @AllArgsConstructor @Service
public class ParkingSpaceServiceImplementation implements ParkingSpaceService{
    ParkingSpaceRepository parkingSpaceRepository;

    @Override
    public void createParkingSpace() {
        for (int id = 1; id <= 25; id++) {
            ParkingSpace parkingSpace = new ParkingSpace(Long.valueOf(id), null, null, AVAILABLE, 0, 0);
            parkingSpaceRepository.save(parkingSpace);
        }

    }

    @Override
    public List<ParkingSpace> listParkingSpace() {
        return parkingSpaceRepository.findAll();
    }

    @Override
    public List<ParkingSpaceAvailableDTO> listParkingSpaceAvailable(){
        Long totalParkingSpaces = parkingSpaceRepository.count();
        List<ParkingSpaceAvailableDTO> listParkingSpaceAvailable = new ArrayList<ParkingSpaceAvailableDTO>();
        for (int i = 1; i <= totalParkingSpaces; i++){
            Optional<ParkingSpace> parkingSpace = parkingSpaceRepository.findById(Long.valueOf(i));
            if (parkingSpace.get().getParkingSpaceStatus() == AVAILABLE){
                parkingSpace.ifPresent(new Consumer<ParkingSpace>() {
                    @Override
                    public void accept(ParkingSpace parkingSpace) {
                        ParkingSpaceAvailableDTO parkingSpaceAvailable = new ParkingSpaceAvailableDTO();
                        parkingSpaceAvailable.setId(parkingSpace.getId());
                        parkingSpaceAvailable.setParkingSpaceStatus(parkingSpace.getParkingSpaceStatus());
                        listParkingSpaceAvailable.add(parkingSpaceAvailable);
                    }
                });
            }
        }
        return listParkingSpaceAvailable;
    }

    @Override
    public List<ParkingSpaceUnavailableDTO> listParkingSpaceUnavailable() {
        Long totalParkingSpaces = parkingSpaceRepository.count();
        List<ParkingSpaceUnavailableDTO> listParkingSpaceUnvailable = new ArrayList<ParkingSpaceUnavailableDTO>();
        for (int i = 1; i <= totalParkingSpaces; i++){
            Optional<ParkingSpace> parkingSpace = parkingSpaceRepository.findById(Long.valueOf(i));
            if (parkingSpace.get().getParkingSpaceStatus() == UNAVAILABLE){
                parkingSpace.ifPresent(parkingSpacePresent -> {
                    ParkingSpaceUnavailableDTO parkingSpaceUnavailable = new ParkingSpaceUnavailableDTO();
                    parkingSpaceUnavailable.setId(parkingSpacePresent.getId());
                    parkingSpaceUnavailable.setParkingSpaceStatus(parkingSpacePresent.getParkingSpaceStatus());
                    parkingSpaceUnavailable.setClientCpf(parkingSpacePresent.getClientCpf());
                    parkingSpacePresent.setCar(parkingSpacePresent.getCar());
                    listParkingSpaceUnvailable.add(parkingSpaceUnavailable);
                });
            }
        }
        return listParkingSpaceUnvailable;
    }

    @Override
    public ResponseEntity fillParkingSpace(ParkingSpaceUnavailableDTO parkingSpaceUnavailableDTO) {
        Optional<ParkingSpace> parkingSpaceid = parkingSpaceRepository.findById(parkingSpaceUnavailableDTO.getId());
        if(parkingSpaceid.isPresent()){
            ParkingSpace parkingSpaceUpdated = new ParkingSpace();
            parkingSpaceUpdated.setId(parkingSpaceUnavailableDTO.getId());
            parkingSpaceUpdated.setCar(parkingSpaceUnavailableDTO.getCar());
            parkingSpaceUpdated.setClientCpf(parkingSpaceUnavailableDTO.getClientCpf());
            parkingSpaceUpdated.setHourEntry(parkingSpaceUnavailableDTO.getHourEntry());
            parkingSpaceUpdated.setMinuteEntry(parkingSpaceUnavailableDTO.getMinuteEntry());
            parkingSpaceUpdated.setParkingSpaceStatus(parkingSpaceUnavailableDTO.getParkingSpaceStatus());
            parkingSpaceRepository.save(parkingSpaceUpdated);
            return ResponseEntity.ok(parkingSpaceUpdated);
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("id not found");
        }

    }

    @Override
    public ResponseEntity vacateParkingSpcae(ParkingSpaceAvailableDTO parkingSpaceAvailableDTO) {
        Optional<ParkingSpace> parkingSpaceid = parkingSpaceRepository.findById(parkingSpaceAvailableDTO.getId());
        if(parkingSpaceid.isPresent()){
            ParkingSpace parkingSpaceUpdated = new ParkingSpace();
            parkingSpaceUpdated.setId(parkingSpaceAvailableDTO.getId());
            parkingSpaceUpdated.setParkingSpaceStatus(parkingSpaceAvailableDTO.getParkingSpaceStatus());
            parkingSpaceRepository.save(parkingSpaceUpdated);
            return ResponseEntity.ok(parkingSpaceUpdated);
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("id not found");
        }
    }


}
