package com.company.paradigm.data.dto;

import com.company.paradigm.data.enums.InsuranceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDTO {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal duePayment;

    private InsuranceType insuranceType;
}
