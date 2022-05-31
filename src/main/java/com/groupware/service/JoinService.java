package com.groupware.service;

import com.groupware.dto.JoinDTO;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface JoinService {
    ResponseEntity<Map<String, Object>> joinAction(JoinDTO joinDTO);
}
