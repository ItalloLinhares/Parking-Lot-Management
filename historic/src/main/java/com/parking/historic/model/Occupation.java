package com.parking.historic.model;

import com.parking.historic.dto.CarDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
