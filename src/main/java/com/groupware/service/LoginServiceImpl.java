package com.groupware.service;

import com.groupware.dto.LoginDTO;
import com.groupware.dto.LoginResponseDTO;
import com.groupware.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final Validation validation;
    private final LoginMapper loginMapper;

    @Override
    public ResponseEntity<Map<String, Object>> loginAction(LoginDTO loginDTO, HttpSession session) {


        Map<String, Object> resultMap = new HashMap<>();

        if(session.getAttribute("employeeIdx") != null){
            resultMap.put("result", true);
            resultMap.put("message", "already login");

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(resultMap);
        }

        LoginResponseDTO employeeOne = loginMapper.getEmployeeOne(loginDTO);

        if(employeeOne == null){
            resultMap.put("result", false);
            resultMap.put("message", "login denied");

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(resultMap);
        }

        if (employeeOne.getState() == 0 || employeeOne.getState() == 5) {
            resultMap.put("result", false);
            resultMap.put("message", "login denied");

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(resultMap);
        }

        session.setAttribute("employeeIdx", employeeOne.getEmployeeIdx());
        session.setMaxInactiveInterval(60 * 60 * 8);

        resultMap.put("result", true);
        resultMap.put("message", "login success");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }
}
