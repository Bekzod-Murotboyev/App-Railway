package com.example.rail_e_ticket_front.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private Long id;

    private Long trainId;

    private String type;
    private String code;
    private double price;

    @JsonProperty("num_seats")
    private byte numSeats;
}
