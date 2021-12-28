package com.parking.management.model;

import com.parking.management.status.ParkingSpaceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
public class Occupation {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Car car;
    private Long clientCpf;
    private int hourEntry;
    private int minuteEntry;
    private int hourExit;
    private int minuteExit;
    private float price;
}
