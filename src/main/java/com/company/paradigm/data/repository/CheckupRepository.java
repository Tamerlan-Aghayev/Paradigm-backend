package com.company.paradigm.data.repository;

import com.company.paradigm.data.entity.CheckupEntity;
import com.company.paradigm.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckupRepository extends JpaRepository<CheckupEntity, Long> {
    List<CheckupEntity> getCheckupEntitiesByUser(UserEntity user);
}
