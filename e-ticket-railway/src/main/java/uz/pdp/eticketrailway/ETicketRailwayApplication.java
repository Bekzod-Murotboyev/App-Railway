package uz.pdp.eticketrailway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import uz.pdp.eticketrailway.payload.AuthDTO;

import static uz.pdp.eticketrailway.utils.interfaces.Method.*;
import static uz.pdp.eticketrailway.utils.interfaces.Url.*;

@SpringBootApplication
@EnableFeignClients
public class ETicketRailwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ETicketRailwayApplication.class, args);
        System.out.println(restTemplate().postForObject(FULL_REQUEST + SET_WEBHOOK, new SetWebhook(GLOBAL + BASE_WEBHOOK), AuthDTO.class));
    }
    @Bean
    static RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
