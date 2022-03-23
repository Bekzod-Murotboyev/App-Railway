package com.example.rail_e_ticket_front.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Station  {

    private Long id;

    private Destination destination;

    private String name;
}
