package org.demo.mortgage.service;

import org.demo.mortgage.model.InterestRate;

import java.util.List;

public interface InterestRateService {

    List<InterestRate> getInterestRates();
    void setInterestRates(List<InterestRate> rates);
}
