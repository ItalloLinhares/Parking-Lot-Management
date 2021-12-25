package com.parking.management.controller;


import com.parking.management.model.ParkingSpaceModel;
import com.parking.management.parkingSpaceStatus.ParkingSpaceStatus;
import com.parking.management.repository.ParkingSpaceRepository;
import com.parking.management.service.ParkingSpaceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/management") @AllArgsConstructor
public class IndexController {

    private final ParkingSpaceService parkingSpaceService;

    @RequestMapping("/create/parkingspaces")
    public void status(){
        parkingSpaceService.createParkingSpace();
    }

    

    @GetMapping("/listParkingSpace")
    public ResponseEntity<String> listParkingSpace(){
        return null;
    }


}
