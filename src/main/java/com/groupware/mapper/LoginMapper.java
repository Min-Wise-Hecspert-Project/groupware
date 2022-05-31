package com.groupware.mapper;

import com.groupware.dto.LoginDTO;
import com.groupware.dto.LoginResponseDTO;

public interface LoginMapper {
    LoginResponseDTO getEmployeeOne(LoginDTO loginDTO);
}
