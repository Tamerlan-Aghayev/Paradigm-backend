package com.company.paradigm.data.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckupDTO {
    private Long id;
    private LocalDate checkupDate;
    private String heartRate;
    private String cholesterol;
    private String obesityPercent;
    private String cancerProbability;
}
