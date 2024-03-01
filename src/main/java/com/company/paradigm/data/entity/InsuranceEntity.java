package com.company.paradigm.data.entity;

import com.company.paradigm.data.enums.InsuranceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsuranceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal duePayment;

    @Enumerated(EnumType.STRING)
    private InsuranceType insuranceType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
