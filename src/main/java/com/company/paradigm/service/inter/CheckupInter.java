package com.company.paradigm.service.inter;

import com.company.paradigm.data.dto.CheckupDTO;
import com.company.paradigm.data.dto.UserDTO;

import java.util.List;

public interface CheckupInter {
    List<CheckupDTO> getCheckupsByUser(UserDTO userDTO);

    void addOrUpdateCheckupToUser(CheckupDTO checkupDTO, Long userId);

    void deleteById(Long id);
}
