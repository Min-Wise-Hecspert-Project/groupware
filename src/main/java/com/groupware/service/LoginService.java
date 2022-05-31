package com.groupware.service;

import com.groupware.dto.LoginDTO;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface LoginService {

    ResponseEntity<Map<String, Object>> loginAction(LoginDTO loginDTO, HttpSession session);
}
