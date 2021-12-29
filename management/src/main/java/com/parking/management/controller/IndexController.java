package com.parking.management.controller;

import com.parking.management.dto.ParkingSpaceAvailableDTO;
import com.parking.management.dto.ParkingSpaceUnavailableDTO;
import com.parking.management.model.Occupation;
import com.parking.management.model.ParkingSpace;
import com.parking.management.repository.ParkingSpaceRepository;
import com.parking.management.service.OccupationService;
import com.parking.management.service.ParkingSpaceService;
import com.parking.management.status.ParkingSpaceStatus;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;
//ESSE AQUI PELO AMOR DE DEUS

@RestController
@RequestMapping("/management") @AllArgsConstructor @Transactional
public class IndexController {
    private final ParkingSpaceService parkingSpaceService;
    private final ParkingSpaceRepository parkingSpaceRepository;
    private final OccupationService occupationService;
    private final RestTemplate restTemplate;


    @RequestMapping("/create/parkingspaces")
    public void createParkingSpaces() {
        parkingSpaceService.createParkingSpace();
    }

    @RequestMapping("/listOccupation")
    public ResponseEntity listOccupation(@RequestBody String findBy){
        ResponseEntity response = restTemplate.getForEntity("http://localhost:8081/"+findBy, Occupation[].class);
        return response;
    }

    @GetMapping("/listParkingSpace")
    public List<ParkingSpace> listParkingSpace() {
        List<ParkingSpace> listParkingSpace = parkingSpaceService.listParkingSpace();
        return listParkingSpace;
    }

    @GetMapping("/listParkingSpaceAvailable")
    public List<ParkingSpaceAvailableDTO> listParkingSpaceAvailable() {
        List<ParkingSpaceAvailableDTO> listParkingSpace = parkingSpaceService.listParkingSpaceAvailable();
        return listParkingSpace;
    }

    @GetMapping("/listParkingSpaceUnavailable")
    public List<ParkingSpaceUnavailableDTO> listParkingSpaceUnavailable() {
        List<ParkingSpaceUnavailableDTO> listParkingSpace = parkingSpaceService.listParkingSpaceUnavailable();
        return listParkingSpace;
    }

    @RequestMapping("/fillParkingSpace")
    public ResponseEntity fillParkingSpace(@RequestBody ParkingSpaceUnavailableDTO parkingSpace) {
        return parkingSpaceService.fillParkingSpace(parkingSpace);
    }

    @RequestMapping("/vacateParkingSpcae")
    public ResponseEntity vacateParkingSpcae(@RequestBody ParkingSpaceAvailableDTO parkingSpace) {
        return parkingSpaceService.vacateParkingSpcae(parkingSpace);
    }

    @RequestMapping("/saveOccupation")
    public ResponseEntity saveOccupation (@RequestBody ParkingSpaceAvailableDTO parkingSpace){
        return occupationService.saveOccupation(parkingSpace);
    }


}
