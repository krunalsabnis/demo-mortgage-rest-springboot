package org.demo.mortgage.config;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.demo.mortgage.model.InterestRate;
import org.demo.mortgage.service.InterestRateService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.List;

@Configuration
public class InterestRateConfig {


    @Bean
    CommandLineRunner interestRateData(InterestRateService interestRateService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule()); // Register JavaTimeModule for Instant support

            InputStream inputStream = new ClassPathResource("mortgage-rates.json").getInputStream();
            List<InterestRate> rates = mapper.readValue(inputStream, new TypeReference<>() {});
            interestRateService.setInterestRates(rates);
        };
    }
}
