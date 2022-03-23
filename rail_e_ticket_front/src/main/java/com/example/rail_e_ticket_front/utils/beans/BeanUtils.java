package com.example.rail_e_ticket_front.utils.beans;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanUtils {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
