package com.example.rail_e_ticket_front.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destination {

    private Long id;

    private String name;

    private int code;

    public Destination(Long id) {
        this.id = id;
    }
}
