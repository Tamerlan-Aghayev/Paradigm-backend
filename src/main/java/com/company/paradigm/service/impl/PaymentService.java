package com.company.paradigm.service.impl;

import com.company.paradigm.data.dto.InsuranceDTO;
import com.company.paradigm.data.dto.PaymentDTO;
import com.company.paradigm.data.entity.InsuranceEntity;
import com.company.paradigm.data.entity.PaymentEntity;
import com.company.paradigm.data.repository.InsuranceRepository;
import com.company.paradigm.data.repository.PaymentRepository;
import com.company.paradigm.service.inter.PaymentInter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentInter {
    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;
    private final InsuranceRepository insuranceRepository;

    public List<PaymentDTO> getPaymentsByInsurance(InsuranceDTO insuranceDTO){
        InsuranceEntity insurance=modelMapper.map(insuranceDTO, InsuranceEntity.class);
        List<PaymentEntity> paymentEntities=paymentRepository.findPaymentEntitiesByInsurance(insurance);
        return paymentEntities.stream().map(i->modelMapper.map(i,PaymentDTO.class)).sorted(Comparator.comparing(PaymentDTO::getPaymentDate).reversed()).toList();
    }
    public void addOrUpdatePayment(PaymentDTO paymentDTO, Long insuranceId){
        PaymentEntity paymentEntity=modelMapper.map(paymentDTO, PaymentEntity.class);
        InsuranceEntity insurance=insuranceRepository.getReferenceById(insuranceId);
        paymentEntity.setInsurance(insurance);
        paymentRepository.save(paymentEntity);
    }
    public void deletePaymentById(Long id){
        paymentRepository.deleteById(id);
    }
}
