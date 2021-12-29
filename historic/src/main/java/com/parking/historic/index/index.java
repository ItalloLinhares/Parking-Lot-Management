package com.parking.historic.index;

import com.parking.historic.model.Occupation;
import com.parking.historic.service.OccupationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/historic")
@AllArgsConstructor
public class index {
    private final OccupationService occupationService;

    @RequestMapping("/byId")
    public ResponseEntity byId(@RequestBody Long id){
        return occupationService.byId(id);
    }

    @RequestMapping("/byLicensePlate")
    public ResponseEntity byLicensePlate(@RequestBody String licensePlate){
        return occupationService.byLicensePlate(licensePlate);
    }

    @RequestMapping("/byCpf")
    public ResponseEntity byCpf(@RequestBody Long cpf){
        return occupationService.byCpf(cpf);
    }

    @RequestMapping("/listAll")
    public ResponseEntity listAll(){
        return occupationService.listAll();
    }
}
