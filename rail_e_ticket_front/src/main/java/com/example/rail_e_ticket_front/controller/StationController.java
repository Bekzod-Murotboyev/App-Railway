package com.example.rail_e_ticket_front.controller;

import com.example.rail_e_ticket_front.feign.RailwayFeign;
import com.example.rail_e_ticket_front.model.Destination;
import com.example.rail_e_ticket_front.model.Station;
import com.example.rail_e_ticket_front.payload.ApiResponse;
import com.example.rail_e_ticket_front.payload.LoginDto;
import com.example.rail_e_ticket_front.payload.OwnerDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.example.rail_e_ticket_front.utils.interfaces.Page.STATION;
import static com.example.rail_e_ticket_front.utils.interfaces.Url.URL_STATION;

@Controller
@RequiredArgsConstructor
@RequestMapping(URL_STATION)
public class StationController {

    private final RailwayFeign railwayFeign;

    @GetMapping("/{token}")
    public String getStations(Model model, @PathVariable String token) {
        model.addAttribute("stations",railwayFeign.getStations(token).getData());
        model.addAttribute("destinations",railwayFeign.getDestinations(token).getData());
        return STATION;
    }

    @ResponseBody
    @PutMapping
    public ApiResponse updateStation(@RequestParam Long id, @RequestParam String name, @RequestParam Long destinationId,@RequestParam String token) {
        return id>0?railwayFeign.editStation(id, new Station(id, new Destination(destinationId), name),token):
                railwayFeign.addStation(new Station(null,new Destination(destinationId),name),token);
    }

    @ResponseBody
    @DeleteMapping
    public void deleteStation(@RequestParam Long id,@RequestParam String token) {
        railwayFeign.deleteStation(id,token);
    }
}
