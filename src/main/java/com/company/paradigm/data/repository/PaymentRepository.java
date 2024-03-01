package com.company.paradigm.data.repository;

import com.company.paradigm.data.entity.InsuranceEntity;
import com.company.paradigm.data.entity.PaymentEntity;
import com.company.paradigm.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    List<PaymentEntity> findPaymentEntitiesByInsurance(InsuranceEntity insurance);
}
