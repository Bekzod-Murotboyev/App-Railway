package com.example.rail_e_ticket_front.controller;

import com.example.rail_e_ticket_front.feign.RailwayFeign;
import com.example.rail_e_ticket_front.model.Car;
import com.example.rail_e_ticket_front.model.Train;
import com.example.rail_e_ticket_front.payload.ApiResponse;
import com.example.rail_e_ticket_front.payload.LoginDto;
import com.example.rail_e_ticket_front.payload.OwnerDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.example.rail_e_ticket_front.utils.interfaces.Page.CAR;
import static com.example.rail_e_ticket_front.utils.interfaces.Page.RESPONSE;
import static com.example.rail_e_ticket_front.utils.interfaces.Url.URL_CAR;

@Controller
@RequiredArgsConstructor
@RequestMapping(URL_CAR)
public class CarController {

    private final RailwayFeign railwayFeign;


    @GetMapping("/{token}")
    public String getCars(Model model,@PathVariable String token) {
        model.addAttribute("cars",railwayFeign.getCars(token).getData());
        model.addAttribute("trains",railwayFeign.getTrains(token).getData());
        return CAR;
    }

    @ResponseBody
    @PutMapping
    public ApiResponse updateCar(@RequestParam Long id, @RequestParam Long trainId,
                                 @RequestParam String type,
                                 @RequestParam String code,
                                 @RequestParam double price,
                                 @RequestParam byte numSeats,
                                 @RequestParam String token) {
        return id > 0 ? railwayFeign.editCar(id, new Car(id,trainId, type, code, price, numSeats),token) :
                railwayFeign.addCar(new Car(null,trainId, type, code, price, numSeats),token);
    }

    @ResponseBody
    @DeleteMapping
    public void deleteCar(@RequestParam Long id,@RequestParam String token) {
        railwayFeign.deleteCar(id,token);
    }
}
