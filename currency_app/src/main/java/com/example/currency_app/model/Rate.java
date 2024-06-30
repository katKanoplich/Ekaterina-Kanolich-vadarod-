package com.example.currency_app.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rate {
    @Id
    private int curID; // внутренний код

    private LocalDateTime date; // дата, на которую запрашивается курс

    private String curAbbreviation; // буквенный код

    private int curScale; // количество единиц иностранной валюты

    private String curName; // наименование валюты на русском языке во множественном, либо в единственном числе, в зависимости от количества единиц

    private double curOfficialRate; // курс
}