package com.company.paradigm.service.inter;

import com.company.paradigm.data.dto.InsuranceDTO;
import com.company.paradigm.data.dto.PaymentDTO;

import java.util.List;

public interface PaymentInter {
    List<PaymentDTO> getPaymentsByInsurance(InsuranceDTO insuranceDTO);

    void addOrUpdatePayment(PaymentDTO paymentDTO, Long insuranceId);

    void deletePaymentById(Long id);
}
