package org.demo.mortgage.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class MortgageCheckRequest {

    @NotNull(message = "Income cannot be null")
    @Min(value = 1, message = "Income must be greater than zero")
    private BigDecimal income;

    @NotNull(message = "Maturity period cannot be null")
    @Min(value = 1, message = "Maturity period must be at least 1 year")
    private int maturityPeriod;

    @NotNull(message = "Loan value cannot be null")
    @Min(value = 1, message = "Loan value must be greater than zero")
    private BigDecimal loanValue;

    @NotNull(message = "Home value cannot be null")
    @Min(value = 1, message = "Home value must be greater than zero")
    private BigDecimal homeValue;
}
