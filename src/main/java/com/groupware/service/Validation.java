package com.groupware.service;

import com.groupware.dto.LoginDTO;
import com.groupware.dto.ValidationDTO;

public interface Validation {
    // 아이디 정규식 검증
    boolean isRightId(ValidationDTO validationDTO);
    // 아이디 중복 검증
    boolean isDupId(ValidationDTO validationDTO);
    // 아이디 탈퇴여부 검증
    boolean isWithdrawalId(ValidationDTO validationDTO);
    // 비밀번호 정규식 검증
    boolean isRightPw(ValidationDTO validationDTO);
    // 비밀번호 확인입력 검증
    boolean isSamePw(ValidationDTO validationDTO);

    boolean isAbleLogin(LoginDTO loginDTO);

}
