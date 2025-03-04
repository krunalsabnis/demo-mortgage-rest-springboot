package org.demo.mortgage;

import org.demo.mortgage.model.MortgageCheckRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Map;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"spring.profiles.active=test"})
class RequestValidationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String getBaseUrl() {
        return "http://localhost:" + port + "/v1/api/mortgage-check";
    }

    @Test
    void testValidationFailure_NegativeLoanValue() {
        MortgageCheckRequest request = new MortgageCheckRequest();
        request.setIncome(BigDecimal.valueOf(50000));
        request.setMaturityPeriod(30);
        request.setLoanValue(BigDecimal.valueOf(-150000));  // Invalid input
        request.setHomeValue(BigDecimal.valueOf(200000));

        ResponseEntity<Map> response = testRestTemplate.postForEntity(getBaseUrl(), request, Map.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().containsKey("loanValue"));
        assertEquals("Loan value must be greater than zero", response.getBody().get("loanValue"));
    }

    @Test
    void testValidationFailure_NullIncome() {
        MortgageCheckRequest request = new MortgageCheckRequest();
        request.setMaturityPeriod(30);
        request.setLoanValue(BigDecimal.valueOf(150000));
        request.setHomeValue(BigDecimal.valueOf(200000));

        ResponseEntity<Map> response = testRestTemplate.postForEntity(getBaseUrl(), request, Map.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().containsKey("income"));
        assertEquals("Income cannot be null", response.getBody().get("income"));
    }
}


