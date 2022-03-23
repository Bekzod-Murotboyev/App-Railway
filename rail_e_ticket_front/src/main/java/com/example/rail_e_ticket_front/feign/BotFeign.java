package com.example.rail_e_ticket_front.feign;

import com.example.rail_e_ticket_front.payload.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.rail_e_ticket_front.utils.interfaces.Url.URL_GLOBAL_BOT;
import static com.example.rail_e_ticket_front.utils.interfaces.Url.URL_USER;

@FeignClient(url = URL_GLOBAL_BOT,name = "botFeign")
public interface BotFeign {

    @GetMapping(URL_USER)
    ApiResponse getUsers();

    @PutMapping(URL_USER)
    ApiResponse editUser(@RequestParam String chatId);
}
