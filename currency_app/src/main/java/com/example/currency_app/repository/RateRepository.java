package com.example.currency_app.repository;

import com.example.currency_app.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RateRepository extends JpaRepository<Rate, Long> {
    List<Rate> findAllByDateBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);
    Rate findByDateBetweenAndCurAbbreviation(LocalDateTime startOfDay, LocalDateTime endOfDay, String currency);

}
