package com.parking.historic.service;

import com.parking.historic.model.Occupation;
import com.parking.historic.repository.OccupationRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class OccupationServiceImplementation implements OccupationService{

    OccupationRepository occupationRepository;

    @Override
    public ResponseEntity byId(Long id) {

        Long n = occupationRepository.count();
        for (int i = 1; i <= n; i++){
            Optional<Occupation> occupation = occupationRepository.findById(Long.valueOf(i));
            if(occupation.get().getId() == id){
                return ResponseEntity.ok(occupation.get());
            }
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity byLicensePlate(String LicensePlate) {
        Long n = occupationRepository.count();
        List<Occupation> occupationList = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            Optional<Occupation> occupation = occupationRepository.findById(Long.valueOf(i));
            if(occupation.get().getCar().getCarLicensePlate() == LicensePlate){
                occupationList.add(occupation.get());
            }
        }
        if (occupationList != null){
            return ResponseEntity.ok(occupationList);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity byCpf(Long cpf) {
        Long n = occupationRepository.count();
        List<Occupation> occupationList = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            Optional<Occupation> occupation = occupationRepository.findById(Long.valueOf(i));
            if(occupation.get().getClientCpf() == cpf){
                occupationList.add(occupation.get());
            }
        }
        if (occupationList != null){
            return ResponseEntity.ok(occupationList);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity listAll() {
        List<Occupation> occupationList = occupationRepository.findAll();
        if (occupationList != null){
            return ResponseEntity.ok(occupationList);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
