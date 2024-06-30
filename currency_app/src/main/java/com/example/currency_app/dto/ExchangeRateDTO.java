package com.example.currency_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateDTO {
    private Long id;
    private String currencyCode;
    private LocalDate date;
    private BigDecimal rate;
}