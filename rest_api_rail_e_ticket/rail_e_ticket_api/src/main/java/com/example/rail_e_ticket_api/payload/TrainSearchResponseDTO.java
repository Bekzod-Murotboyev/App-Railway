package com.example.rail_e_ticket_api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrainSearchResponseDTO {
    private long id;

    @NotNull
    private String trainCode;

    @NotNull
    private String trainType;

    @NotNull
    private String fromDestination;

    @NotNull
    private String toDestination;

    @NotNull
    private String fromStation;

    @NotNull
    private LocalDateTime departureTime;

    @NotNull
    private String toStation;

    @NotNull
    private LocalDateTime arrivalTime;

    @NotNull
    private long differenceTimeInMinutes;
}
