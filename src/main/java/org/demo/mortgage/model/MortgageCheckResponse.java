package org.demo.mortgage.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class MortgageCheckResponse {
    private boolean feasible;
    private BigDecimal monthlyCost;

    public MortgageCheckResponse(boolean feasible, BigDecimal monthlyCost) {
        this.feasible = feasible;
        this.monthlyCost = monthlyCost;
    }

}