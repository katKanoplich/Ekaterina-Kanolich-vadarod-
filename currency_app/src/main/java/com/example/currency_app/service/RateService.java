package com.example.currency_app.service;

import com.example.currency_app.model.Rate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RateService {
    List<Rate> getRatesByDate(LocalDateTime date);
    Rate getRateByDateAndCurName(LocalDateTime date, String currency);
    void saveRate(Rate rate);
    void syncRates();

}