package com.groupware.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class LogoutServiceImpl implements LogoutService{
    @Override
    public ResponseEntity<Map<String, Object>> logoutAction(HttpSession session) {
        Map<String, Object> resultMap = new HashMap<>();

        session.invalidate();

        resultMap.put("result", true);
        resultMap.put("message", "session destroyed");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }
}
