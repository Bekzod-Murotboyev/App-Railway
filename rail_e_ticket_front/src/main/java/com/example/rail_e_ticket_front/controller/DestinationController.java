package com.example.rail_e_ticket_front.controller;

import com.example.rail_e_ticket_front.feign.RailwayFeign;
import com.example.rail_e_ticket_front.model.Destination;
import com.example.rail_e_ticket_front.payload.ApiResponse;
import com.example.rail_e_ticket_front.payload.LoginDto;
import com.example.rail_e_ticket_front.payload.OwnerDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.rail_e_ticket_front.utils.interfaces.Page.DESTINATION;
import static com.example.rail_e_ticket_front.utils.interfaces.Url.URL_DESTINATION;

@Controller
@RequiredArgsConstructor
@RequestMapping(URL_DESTINATION)
public class DestinationController {

    private final RailwayFeign railwayFeign;

    private final ModelMapper modelMapper;

    @GetMapping("/{token}")
    public String getDestinations(Model model, @PathVariable String token) {
        model.addAttribute("destinations",railwayFeign.getDestinations(token).getData());
        return DESTINATION;
    }

    @ResponseBody
    @PutMapping
    public ApiResponse updateDestination(@RequestParam Long id, @RequestParam String name, @RequestParam int code,@RequestParam String token) {
        return id < 0 ? railwayFeign.addDestination(new Destination(null, name, code),token) :
                railwayFeign.editDestination(id, new Destination(id, name, code),token);
    }

    @ResponseBody
    @DeleteMapping
    public void deleteDestination(@RequestParam Long id,@RequestParam String token) {
        railwayFeign.deleteDestination(id,token);
    }

    @ResponseBody
    @GetMapping
    public ApiResponse getDestinations(@RequestParam String token){
        return railwayFeign.getDestinations(token);
    }
}
