package com.company.paradigm.service.inter;

import com.company.paradigm.data.dto.InsuranceDTO;
import com.company.paradigm.data.dto.UserDTO;

import java.util.List;

public interface InsuranceInter {
    List<InsuranceDTO> getInsurancesByUser(UserDTO userDTO);

    void addOrUpdateCheckupToUser(InsuranceDTO insuranceDTO, Long userId);

    void deleteById(Long id);
}
