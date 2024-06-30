package com.example.currency_app.service;

import com.example.currency_app.dto.RateInfo;
import com.example.currency_app.model.Rate;
import com.example.currency_app.repository.RateRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class RateServiceImpl implements RateService {
    private final WebClient webClient;
    private final RateRepository rateRepository;

    public RateServiceImpl(WebClient.Builder webClientBuilder, RateRepository rateRepository) {
        this.webClient = webClientBuilder.baseUrl("https://api.nbrb.by").build();
        this.rateRepository = rateRepository;
    }

    @Override
    public void syncRates() {
        List<RateInfo> rateInfos = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/exrates/rates")
                        .queryParam("ondate", LocalDate.now()) // or any specific date
                        .queryParam("periodicity", 0) // daily rates
                        .build())
                .retrieve()
                .bodyToFlux(RateInfo.class)
                .collectList()
                .block();

        if (rateInfos != null && !rateInfos.isEmpty()) {
            rateInfos.forEach(rateInfo -> {
                Rate rate = new Rate(
                        rateInfo.getCurID(),
                        rateInfo.getDate(),
                        rateInfo.getCurAbbreviation(),
                        rateInfo.getCurScale(),
                        rateInfo.getCurName(),
                        rateInfo.getCurOfficialRate()
                );
                rateRepository.save(rate);
            });
        } else {
            System.err.println("No rates found");
        }
    }

    public List<Rate> getRatesByDate(LocalDateTime date) {
        return rateRepository.findByDate(date);
    }

    public Rate getRateByDateAndCurName(LocalDateTime date, String currency) {
        return rateRepository.findByDateAndCurName(date, currency)
                .orElseThrow();
    }

    public void saveRate(Rate rate) {
        rateRepository.save(rate);
    }
}