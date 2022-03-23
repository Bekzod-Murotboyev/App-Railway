package com.example.rail_e_ticket_front.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class User {

    String id;

    String name;

    String phoneNumber;


    String username;

    String chatId;

    String state;

    String fromRegion;

    String toRegion;

    LocalDate departureDate;

    String trainNumber;

    String carNumber;



    LocalDate createdDate;

    boolean active;


    public User(String name, String phoneNumber, String username, String chatId, String state) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.chatId = chatId;
        this.state = state;
        this.active=true;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public User setState(String state) {
        this.state = state;
        return this;
    }

    public User setFromRegion(String fromRegion) {
        this.fromRegion = fromRegion;
        return this;
    }

    public User setToRegion(String toRegion) {
        this.toRegion = toRegion;
        return this;
    }

    public User setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public User setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
        return this;
    }

    public User setCarNumber(String carNumber) {
        this.carNumber = carNumber;
        return this;
    }
}
