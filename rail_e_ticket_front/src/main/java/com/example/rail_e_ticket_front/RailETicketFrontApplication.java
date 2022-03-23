package com.example.rail_e_ticket_front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RailETicketFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(RailETicketFrontApplication.class, args);
    }

}
