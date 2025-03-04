package org.demo.mortgage.service;

import org.demo.mortgage.model.MortgageCheckRequest;
import org.demo.mortgage.model.MortgageCheckResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class MortgageServiceImpl implements MortgageService {

    @Override
    public MortgageCheckResponse checkMortgage(MortgageCheckRequest request) {
        boolean feasible = request.getLoanValue().compareTo(request.getIncome().multiply(BigDecimal.valueOf(4))) <= 0 &&
                request.getLoanValue().compareTo(request.getHomeValue()) <= 0;

        BigDecimal monthlyCost = feasible ? calculateMonthlyPayment(request) : BigDecimal.ZERO;
        return new MortgageCheckResponse(feasible, monthlyCost);
    }


    @Override
    public BigDecimal calculateMonthlyPayment(MortgageCheckRequest request) {
        BigDecimal rate = BigDecimal.valueOf(5.0).divide(BigDecimal.valueOf(100), 5, BigDecimal.ROUND_HALF_UP);
        int months = request.getMaturityPeriod() * 12;
        return request.getLoanValue().multiply(rate).divide(BigDecimal.valueOf(months), 2, BigDecimal.ROUND_HALF_UP);
    }
}
