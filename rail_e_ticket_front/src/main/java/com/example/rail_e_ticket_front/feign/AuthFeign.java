package com.example.rail_e_ticket_front.feign;

import com.example.rail_e_ticket_front.payload.ApiResponse;
import com.example.rail_e_ticket_front.payload.LoginDto;
import com.example.rail_e_ticket_front.payload.OwnerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.rail_e_ticket_front.utils.interfaces.Url.URL_GLOBAL;

@FeignClient(url = URL_GLOBAL,name = "AuthFeign")
public interface AuthFeign {


    @PostMapping("/check")
    ApiResponse check(@RequestBody OwnerDto ownerDto);

    @PostMapping("/verify/{email}")
    ApiResponse verify(@PathVariable String email);

    @PostMapping( "/login")
    ResponseEntity<?> login(@RequestBody LoginDto loginDto);

    @GetMapping("/{username}")
    ApiResponse getOwner(@PathVariable String username,@RequestHeader String authorization);

}
