package com.example.rail_e_ticket_front.controller;

import com.example.rail_e_ticket_front.feign.AuthFeign;
import com.example.rail_e_ticket_front.payload.ApiResponse;
import com.example.rail_e_ticket_front.payload.LoginDto;
import com.example.rail_e_ticket_front.payload.OwnerDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import static com.example.rail_e_ticket_front.utils.interfaces.Page.*;
import static com.example.rail_e_ticket_front.utils.interfaces.Url.URL_AUTH;

@Controller
@RequiredArgsConstructor
@RequestMapping(URL_AUTH)
public class AuthController {

    private final AuthFeign authFeign;

    private final ModelMapper modelMapper;

    @GetMapping("/login")
    public String getLoginPage() {
        return LOGIN;
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return REGISTER;
    }


    @PostMapping("/register")
    public String getRegister(@ModelAttribute OwnerDto ownerDto, Model model) {
        ApiResponse response = authFeign.check(ownerDto);
        model.addAttribute(RESPONSE, response);
        return LOGIN;
    }


    @PostMapping("/login")
    public String getLogin(@ModelAttribute LoginDto loginDto, Model model) {
        ResponseEntity<?> response= authFeign.login(loginDto);
        String token = "Bearer "+response.getHeaders().get("token").get(0);
        if (response.getStatusCodeValue()!=200) {
            model.addAttribute(RESPONSE, response);
            return LOGIN;
        }
        model.addAttribute("owner", modelMapper.map(authFeign.getOwner(loginDto.getUsername(),token).getData(), OwnerDto.class));
        model.addAttribute("token",token);
        return CABINET;
    }


    @GetMapping("/verify/{email}")
    public String verifyEmail(@PathVariable String email, Model model) {
        ApiResponse response = authFeign.verify(email);
        model.addAttribute(RESPONSE, response);
        return RESPONSE;
    }

    @GetMapping("/logOut")
    public String logOut(HttpServletResponse response) {
        return LOGIN;
    }

    @GetMapping("/cabinet/{token}")
    public String getCabinet(@PathVariable String token,Model model){
        return CABINET;
    }


}
