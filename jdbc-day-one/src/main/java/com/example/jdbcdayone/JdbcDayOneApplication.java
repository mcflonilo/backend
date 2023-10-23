package com.example.jdbcdayone;

import com.example.jdbcdayone.model.Part;
import com.example.jdbcdayone.repository.PartRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JdbcDayOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcDayOneApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PartRepository parts) {
        return args -> {
            parts.save(new Part(25, "flywheel"));
            parts.save(new Part(10, "cog"));
        };
    }
}

