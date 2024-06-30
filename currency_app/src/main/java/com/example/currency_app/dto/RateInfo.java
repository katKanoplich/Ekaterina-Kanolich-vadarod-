package com.example.currency_app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RateInfo {

    @JsonProperty("Cur_ID")
    private int curID;

    @JsonProperty("Date")
    private LocalDateTime date;

    @JsonProperty("Cur_Abbreviation")
    private String curAbbreviation;

    @JsonProperty("Cur_Scale")
    private int curScale;

    @JsonProperty("Cur_Name")
    private String curName;

    @JsonProperty("Cur_OfficialRate")
    private double curOfficialRate;
    public RateInfo(LocalDateTime date, String curName, double curOfficialRate) {
        this.date = date;
        this.curName = curName;
        this.curOfficialRate = curOfficialRate;
    }
}
