package com.company.paradigm.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate checkupDate;
    private String heartRate;
    private String cholesterol;
    private String obesityPercent;
    private String cancerProbability;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}

