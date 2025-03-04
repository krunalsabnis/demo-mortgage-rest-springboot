package org.demo.mortgage;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MortgageServiceTest {
    @Test
    void testLoadingMortgageRatesFromResource() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource("mortgage-rates.json").getInputStream();
        assertNotNull(inputStream, "Resource file not found");
        List<?> rates = mapper.readValue(inputStream, new TypeReference<>() {});
        assertFalse(rates.isEmpty(), "Mortgage rates should not be empty");
    }


}
