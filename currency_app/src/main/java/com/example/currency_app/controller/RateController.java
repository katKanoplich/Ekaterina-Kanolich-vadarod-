package com.example.currency_app.controller;

import com.example.currency_app.dto.RateInfo;
import com.example.currency_app.dto.RateLoadingResult;
import com.example.currency_app.model.Rate;
import com.example.currency_app.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rates")
public class RateController {

    private final RateService rateService;

    @GetMapping("/{date}")
    public ResponseEntity<RateLoadingResult> getRatesByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime date) {
        List<Rate> rates = rateService.getRatesByDate(date);
        boolean isLoaded = !rates.isEmpty();
        RateLoadingResult result = new RateLoadingResult(date, isLoaded);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{date}/{currency}")
    public ResponseEntity<RateInfo> getRateByDateAndCurName(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime date, @PathVariable String currency) {
        Rate rate = rateService.getRateByDateAndCurName(date, currency);
        RateInfo rateInfo = new RateInfo(rate.getDate(), rate.getCurName(), rate.getCurOfficialRate());
        return ResponseEntity.ok(rateInfo);
    }

    @PostMapping
    public ResponseEntity<Rate> createRate(@RequestBody Rate rate) {
        rateService.saveRate(rate);
        return ResponseEntity.status(HttpStatus.CREATED).body(rate);
    }


}