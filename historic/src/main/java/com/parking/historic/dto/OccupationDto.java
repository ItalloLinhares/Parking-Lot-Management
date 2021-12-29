package com.parking.historic.dto;

import javax.persistence.OneToOne;


public class OccupationDto {

    private Long id;
    @OneToOne
    private CarDto car;
    private Long clientCpf;
    private int hourEntry;
    private int minuteEntry;
    private int hourExit;
    private int minuteExit;
    private float price;
}
