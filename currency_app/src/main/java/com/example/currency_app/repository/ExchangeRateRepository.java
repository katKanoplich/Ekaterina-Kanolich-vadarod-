package com.example.currency_app.repository;

import com.example.currency_app.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    List<ExchangeRate> findByCurrencyIdAndDate(Long currencyId, LocalDate date);
    boolean existsByDate(LocalDate date);
}