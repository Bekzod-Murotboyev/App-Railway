package com.example.rail_e_ticket_front.controller;

import com.example.rail_e_ticket_front.feign.BotFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.example.rail_e_ticket_front.utils.interfaces.Page.USER;
import static com.example.rail_e_ticket_front.utils.interfaces.Url.URL_USER;

@Controller
@RequiredArgsConstructor
@RequestMapping(URL_USER)
public class UserController {

    private final BotFeign botFeign;

    @GetMapping("/{token}")
    public String getLoginPage(Model model,@PathVariable String token) {
        model.addAttribute("users",botFeign.getUsers().getData());
        return USER;
    }

    @ResponseBody
    @PutMapping
    public void editUser(@RequestParam String chatId,@RequestParam String token){
        botFeign.editUser(chatId);
    }
}
