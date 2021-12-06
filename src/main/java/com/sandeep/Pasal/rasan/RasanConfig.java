package com.sandeep.Pasal.rasan;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RasanConfig {

    @Bean
    CommandLineRunner commandLineRunner(RasanRepository repository){
        return args -> {
            Rasan Chamal = new Rasan(
                       "Chamal",
                        20,
                       10
               );

            Rasan Daal= new Rasan(
                    "Daal",
                    30,
                    15
            );

            repository.saveAll(
                    List.of(Chamal, Daal)
            );


        };
    }
}
