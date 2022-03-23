package com.example.rail_e_ticket_front.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto {

    private Long id;

    private String name;

    private String username;

    private String email;

    private String password;

    private int permissions;
}
