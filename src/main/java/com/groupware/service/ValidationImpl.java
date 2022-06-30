package com.groupware.service;

import com.groupware.dto.Employee;
import com.groupware.dto.LoginDTO;
import com.groupware.dto.ValidationDTO;
import com.groupware.mapper.ValidationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ValidationImpl implements Validation{

    private final ValidationMapper mapper;

    @Override
    public boolean isRightId(ValidationDTO validationDTO) {
        String pattern = "^(?=.*[a-z])(?=.*\\d)[a-z\\d]{3,15}$"; // 3글자 이상, 15글자 이하의 영문, 숫자조합
        String id = validationDTO.getLoginId();

        return Pattern.matches(pattern, id);
    }

    @Override
    public boolean isDupId(ValidationDTO validationDTO) {
        ValidationDTO storedEmployee = mapper.selectEmployeeById(validationDTO);
        if(storedEmployee == null){
            return false;
        } else {
            return storedEmployee.getLoginId().equals(validationDTO.getLoginId());
        }
    }

    @Override
    public boolean isWithdrawalId(ValidationDTO validationDTO) {
        ValidationDTO storedEmployee = mapper.selectEmployeeById(validationDTO);

        if(storedEmployee == null){
            return false;
        }
        return storedEmployee.getState() == 5 || storedEmployee.getState() == 0;
    }

    @Override
    public boolean isRightPw(ValidationDTO validationDTO) {
        String pattern = "^(?=.*[a-z])(?=.*\\d)[a-z\\d]{8,15}$"; // 8글자 이상, 15글자 이하의 영문, 숫자조합
        String pw = validationDTO.getLoginPw();

        return Pattern.matches(pattern, pw);
    }

    @Override
    public boolean isSamePw(ValidationDTO validationDTO) {
        return validationDTO.getLoginPw().equals(validationDTO.getLoginPwCheck());
    }

    @Override
    public boolean isAbleLogin(LoginDTO loginDTO) {
        Integer employeeState = mapper.getEmployeeState(loginDTO);

        if(employeeState == null){
            return false;
        }

        return employeeState != 0 && employeeState != 5;
    }

}
