package org.demo.mortgage.controller;


import org.demo.mortgage.model.InterestRate;
import org.demo.mortgage.model.MortgageCheckRequest;
import org.demo.mortgage.model.MortgageCheckResponse;
import org.demo.mortgage.service.InterestRateService;
import org.demo.mortgage.service.MortgageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/api")
@Tag(name = "Mortgage API", description = "Mortgage rate retrieval & feasibility check")
public class MortgageController {

    private final InterestRateService interestRateService;
    private final MortgageService mortgageService;

    public MortgageController(InterestRateService interestRateService, MortgageService mortgageService) {
        this.interestRateService = interestRateService;
        this.mortgageService = mortgageService;
    }


    @Operation(summary = "Get current mortgage interest rates")
    @GetMapping("/interest-rates")
    public List<InterestRate> getInterestRates() {
        return interestRateService.getInterestRates();
    }


    @Operation(summary = "Check mortgage feasibility")
    @PostMapping("/mortgage-check")
    public MortgageCheckResponse checkMortgage(@RequestBody MortgageCheckRequest request) {
        return mortgageService.checkMortgage(request);
    }


}
