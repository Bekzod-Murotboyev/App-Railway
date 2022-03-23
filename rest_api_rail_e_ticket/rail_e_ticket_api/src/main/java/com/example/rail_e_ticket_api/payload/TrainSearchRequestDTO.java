package com.example.rail_e_ticket_api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrainSearchRequestDTO {

    @NotNull
    private int fromDestinationCode;

    @NotNull
    private int toDestinationCode;

    @NotNull
    private LocalDate date;
}
