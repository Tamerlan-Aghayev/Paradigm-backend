package com.company.paradigm.service.impl;
import com.company.paradigm.data.dto.CheckupDTO;
import com.company.paradigm.data.dto.UserDTO;
import com.company.paradigm.data.entity.CheckupEntity;
import com.company.paradigm.data.entity.UserEntity;
import com.company.paradigm.data.repository.CheckupRepository;
import com.company.paradigm.data.repository.UserRepository;
import com.company.paradigm.service.inter.CheckupInter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CheckupService implements CheckupInter {
    private final CheckupRepository checkupRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public List<CheckupDTO> getCheckupsByUser(UserDTO userDTO){
        UserEntity user=modelMapper.map(userDTO, UserEntity.class);
        List<CheckupEntity> checkupEntityList=checkupRepository.getCheckupEntitiesByUser(user);
        return checkupEntityList.stream().map(i->modelMapper.map(i, CheckupDTO.class)).sorted(Comparator.comparing(CheckupDTO::getCheckupDate).reversed()).toList();
    }
    public void addOrUpdateCheckupToUser(CheckupDTO checkupDTO, Long userId){
        CheckupEntity checkupEntity=modelMapper.map(checkupDTO, CheckupEntity.class);
        UserEntity user=userRepository.getReferenceById(userId);
        checkupEntity.setUser(user);
        checkupRepository.save(checkupEntity);
    }
    public void deleteById(Long id){
        checkupRepository.deleteById(id);
    }
}
