package com.example.currency_app;

import com.example.currency_app.service.RateService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CurrencyAppApplication {

	@Autowired
	private RateService rateService;

	@PostConstruct
	public void initRateData() {
		rateService.syncRates();
	}
	public static void main(String[] args) {

		SpringApplication.run(CurrencyAppApplication.class, args);
	}

}
