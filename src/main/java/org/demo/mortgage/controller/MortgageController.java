package org.demo.mortgage.controller;


import org.demo.mortgage.model.InterestRate;
import org.demo.mortgage.model.MortgageCheckRequest;
import org.demo.mortgage.model.MortgageCheckResponse;
import org.demo.mortgage.service.InterestRateService;
import org.demo.mortgage.service.MortgageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")

public class MortgageController {

    private final InterestRateService interestRateService;
    private final MortgageService mortgageService;

    public MortgageController(InterestRateService interestRateService, MortgageService mortgageService) {
        this.interestRateService = interestRateService;
        this.mortgageService = mortgageService;
    }

    @GetMapping("/interest-rates")
    public List<InterestRate> getInterestRates() {
        return interestRateService.getInterestRates();
    }

    @PostMapping("/mortgage-check")
    public MortgageCheckResponse checkMortgage(@RequestBody MortgageCheckRequest request) {
        return mortgageService.checkMortgage(request);
    }


}
