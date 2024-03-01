package com.company.paradigm.service.impl;

import com.company.paradigm.data.dto.CheckupDTO;
import com.company.paradigm.data.dto.InsuranceDTO;
import com.company.paradigm.data.dto.UserDTO;
import com.company.paradigm.data.entity.CheckupEntity;
import com.company.paradigm.data.entity.InsuranceEntity;
import com.company.paradigm.data.entity.UserEntity;
import com.company.paradigm.data.repository.CheckupRepository;
import com.company.paradigm.data.repository.InsuranceRepository;
import com.company.paradigm.data.repository.UserRepository;
import com.company.paradigm.service.inter.InsuranceInter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceService implements InsuranceInter {
    private final InsuranceRepository insuranceRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public List<InsuranceDTO> getInsurancesByUser(UserDTO userDTO){
        UserEntity user=modelMapper.map(userDTO, UserEntity.class);
        List<InsuranceEntity> insuranceEntities=insuranceRepository.getInsuranceEntitiesByUser(user);
        return insuranceEntities.stream().map(i->modelMapper.map(i, InsuranceDTO.class)).sorted(Comparator.comparing(InsuranceDTO::getStartDate).reversed()).toList();
    }
    public void addOrUpdateCheckupToUser(InsuranceDTO insuranceDTO, Long userId){
        InsuranceEntity insurance=modelMapper.map(insuranceDTO, InsuranceEntity.class);
        UserEntity user=userRepository.getReferenceById(userId);
        insurance.setUser(user);
        insuranceRepository.save(insurance);
    }
    public void deleteById(Long id){
        insuranceRepository.deleteById(id);
    }

}
