package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import com.service.*;
import com.model.*;

@SpringBootApplication
public class PlayerApp {

    @Bean
    public CommandLineRunner runner(PlayerService service) {
        return (args) ->{
            //service.addPlayer(new Player("Alen Talis", 88));
            List<Player> players = service.players();

            players.forEach(p -> System.out.println(p));
        };
    }
}
