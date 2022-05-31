package com.groupware.controller;

import com.groupware.dto.JoinDTO;
import com.groupware.service.JoinService;
import com.groupware.service.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public ResponseEntity<Map<String, Object>> join(JoinDTO joinDTO) {
        return joinService.joinAction(joinDTO);
    }
}
