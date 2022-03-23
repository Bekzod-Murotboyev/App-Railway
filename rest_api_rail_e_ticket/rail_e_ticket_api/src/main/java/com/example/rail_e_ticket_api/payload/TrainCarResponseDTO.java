package com.example.rail_e_ticket_api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrainCarResponseDTO {

    private long id;

    @NotNull
    private String type;

    @NotNull
    private int availableSeats;

    @NotNull
    private double price;
}
