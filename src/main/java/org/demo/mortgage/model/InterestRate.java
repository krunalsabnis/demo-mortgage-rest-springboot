package org.demo.mortgage.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor
public class InterestRate {
    @JsonProperty("maturityPeriod")
    private int maturityPeriod;

    @JsonProperty("interestRate")
    private BigDecimal interestRate;

    @JsonProperty("lastUpdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING) // Ensure correct date format
    private Instant lastUpdate;

}

