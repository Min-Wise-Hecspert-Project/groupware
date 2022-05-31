package com.groupware.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@Alias("ValidationDTO")
public class ValidationDTO {
    private String loginId;
    private String loginPw;
    private String loginPwCheck;
    private Integer state;
}
