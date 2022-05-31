package com.groupware.service;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface LogoutService {
    public ResponseEntity<Map<String, Object>> logoutAction(HttpSession session);
}
