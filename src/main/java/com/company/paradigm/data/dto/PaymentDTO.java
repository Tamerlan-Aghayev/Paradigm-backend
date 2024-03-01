package com.company.paradigm.data.dto;

import com.company.paradigm.data.entity.InsuranceEntity;
import com.company.paradigm.data.enums.PaymentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Long id;
    private LocalDate paymentDate;
    private BigDecimal paymentAmount;

    private PaymentStatus paymentStatus;

    private InsuranceDTO insurance;
}
