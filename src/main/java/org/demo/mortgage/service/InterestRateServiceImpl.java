package org.demo.mortgage.service;

import org.demo.mortgage.model.InterestRate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InterestRateServiceImpl implements InterestRateService {
    private List<InterestRate> interestRates;

    @Override
    public List<InterestRate> getInterestRates() {
        return interestRates;
    }

    @Override
    public void setInterestRates(List<InterestRate> interestRates) {
        this.interestRates = interestRates;
    }

}
