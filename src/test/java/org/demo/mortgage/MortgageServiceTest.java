package org.demo.mortgage;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.demo.mortgage.model.MortgageCheckRequest;
import org.demo.mortgage.service.MortgageService;
import org.demo.mortgage.service.MortgageServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MortgageServiceTest {

    private final MortgageService mortgageService = new MortgageServiceImpl();

    @Test
    void testFeasibleMortgage() {
        MortgageCheckRequest request = new MortgageCheckRequest();
        request.setIncome(BigDecimal.valueOf(50000));
        request.setMaturityPeriod(30);
        request.setLoanValue(BigDecimal.valueOf(150000));
        request.setHomeValue(BigDecimal.valueOf(200000));

        var response = mortgageService.checkMortgage(request);

        assertTrue(response.isFeasible());
        assertNotEquals(BigDecimal.ZERO, response.getMonthlyCost());
    }

    @Test
    void testMortgageExceedingIncomeLimit() {
        MortgageCheckRequest request = new MortgageCheckRequest();
        request.setIncome(BigDecimal.valueOf(50000));
        request.setMaturityPeriod(30);
        request.setLoanValue(BigDecimal.valueOf(250000));
        request.setHomeValue(BigDecimal.valueOf(300000));

        var response = mortgageService.checkMortgage(request);

        assertFalse(response.isFeasible());
        assertEquals(BigDecimal.ZERO, response.getMonthlyCost());
    }

    @Test
    void testMortgageExceedingHomeValue() {
        MortgageCheckRequest request = new MortgageCheckRequest();
        request.setIncome(BigDecimal.valueOf(50000));
        request.setMaturityPeriod(30);
        request.setLoanValue(BigDecimal.valueOf(180000));
        request.setHomeValue(BigDecimal.valueOf(150000));

        var response = mortgageService.checkMortgage(request);

        assertFalse(response.isFeasible());
        assertEquals(BigDecimal.ZERO, response.getMonthlyCost());
    }

    @Test
    void testLoadingMortgageRatesFromResource() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource("mortgage-rates.json").getInputStream();
        assertNotNull(inputStream, "Resource file not found");
        List<?> rates = mapper.readValue(inputStream, new TypeReference<>() {});
        assertFalse(rates.isEmpty(), "Mortgage rates should not be empty");
    }


}
