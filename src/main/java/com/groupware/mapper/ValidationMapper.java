package com.groupware.mapper;

import com.groupware.dto.Employee;
import com.groupware.dto.LoginDTO;
import com.groupware.dto.ValidationDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ValidationMapper {
    ValidationDTO selectEmployeeById(ValidationDTO validationDTO);

    Integer getEmployeeState(LoginDTO loginDTO);
}
