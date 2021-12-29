package com.parking.historic.service;

import com.parking.historic.model.Occupation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OccupationService {
    public ResponseEntity byId(Long id);
    public ResponseEntity byLicensePlate(String LicensePlate);
    public ResponseEntity byCpf(Long cpf);
    public ResponseEntity listAll();


    }
