package com.company.paradigm.data.dto;

import com.company.paradigm.data.entity.CheckupEntity;
import com.company.paradigm.data.entity.InsuranceEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;

    private List<CheckupDTO> checkups;

    private List<InsuranceDTO> insurances;
}
