package com.example.currency_app.service;

import com.example.currency_app.model.Rate;

import java.time.LocalDate;
import java.util.List;

public interface RateService {
    List<Rate> getRatesByDate(LocalDate date);
    Rate getRateByDateAndCurName(LocalDate date, String currency);
    void syncRates();

}