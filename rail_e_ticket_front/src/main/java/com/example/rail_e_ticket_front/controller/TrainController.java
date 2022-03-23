package com.example.rail_e_ticket_front.controller;

import com.example.rail_e_ticket_front.feign.RailwayFeign;
import com.example.rail_e_ticket_front.model.Destination;
import com.example.rail_e_ticket_front.model.Train;
import com.example.rail_e_ticket_front.payload.ApiResponse;
import com.example.rail_e_ticket_front.payload.LoginDto;
import com.example.rail_e_ticket_front.payload.OwnerDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.example.rail_e_ticket_front.utils.interfaces.Page.DESTINATION;
import static com.example.rail_e_ticket_front.utils.interfaces.Page.TRAIN;
import static com.example.rail_e_ticket_front.utils.interfaces.Url.URL_DESTINATION;
import static com.example.rail_e_ticket_front.utils.interfaces.Url.URL_TRAIN;

@Controller
@RequiredArgsConstructor
@RequestMapping(URL_TRAIN)
public class TrainController {

    private final RailwayFeign railwayFeign;

    private final ModelMapper modelMapper;

    @GetMapping("/{token}")
    public String getTrains(Model model, @PathVariable String token) {
        model.addAttribute("trains",railwayFeign.getTrains(token).getData());
        return TRAIN;
    }

    @ResponseBody
    @PutMapping
    public ApiResponse updateTrain(@RequestParam Long id, @RequestParam String type, @RequestParam String code,@RequestParam String token) {
        return id>0?railwayFeign.editTrain(id, new Train(id, type, code),token):
                railwayFeign.addTrain(new Train(null,type,code),token);
    }

    @ResponseBody
    @DeleteMapping
    public void deleteTrain(@RequestParam Long id,@RequestParam String token) {
        railwayFeign.deleteTrain(id,token);
    }

    @ResponseBody
    @GetMapping
    public ApiResponse getTrains(@RequestParam String token){
        return railwayFeign.getTrains(token);
    }
}
