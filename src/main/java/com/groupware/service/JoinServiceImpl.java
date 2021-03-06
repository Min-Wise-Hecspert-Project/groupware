package com.groupware.service;

import com.groupware.dto.JoinDTO;
import com.groupware.dto.ValidationDTO;
import com.groupware.mapper.JoinMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JoinServiceImpl implements JoinService{

    private final JoinMapper joinMapper;
    private final Validation validation;

    @Override
    public ResponseEntity<Map<String, Object>> joinAction(JoinDTO joinDTO) {
        ValidationDTO validationDTO = new ValidationDTO(joinDTO.getLoginId(), joinDTO.getLoginPw(), joinDTO.getLoginPwCheck(), 1);

        Map<String, Object> result = new HashMap<>();

        if(!validation.isRightId(validationDTO)){
            result.put("result", false);
            result.put("message", "check your id");

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(result);
        }

        if(validation.isDupId(validationDTO)){
            result.put("result", false);
            result.put("message", "can not use id(dup)");

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(result);
        }

        if(validation.isWithdrawalId(validationDTO)){
            result.put("result", false);
            result.put("message", "can not use id(wdr)");

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(result);
        }

        if(!validation.isRightPw(validationDTO)){
            result.put("result", false);
            result.put("message", "check your pw");

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(result);
        }

        if(!validation.isSamePw(validationDTO)){
            result.put("result", false);
            result.put("message", "check your pw(check)");

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(result);
        }

        int join = joinMapper.join(joinDTO);

        if (join >= 1) {
            result.put("result", true);
            result.put("message", "join success");

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(result);
        } else {
            result.put("result", false);
            result.put("message", "join failed");

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(result);
        }

    }
}
