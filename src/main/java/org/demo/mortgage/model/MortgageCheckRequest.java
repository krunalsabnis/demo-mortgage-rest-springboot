package org.demo.mortgage.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
public class MortgageCheckRequest {
    private BigDecimal income;
    private int maturityPeriod;
    private BigDecimal loanValue;
    private BigDecimal homeValue;
}