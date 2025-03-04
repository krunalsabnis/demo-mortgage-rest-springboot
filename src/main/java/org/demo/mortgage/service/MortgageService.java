package org.demo.mortgage.service;

import org.demo.mortgage.model.MortgageCheckRequest;
import org.demo.mortgage.model.MortgageCheckResponse;

import java.math.BigDecimal;

public interface MortgageService {

    MortgageCheckResponse checkMortgage(MortgageCheckRequest request);

    BigDecimal calculateMonthlyPayment(MortgageCheckRequest request);
}
