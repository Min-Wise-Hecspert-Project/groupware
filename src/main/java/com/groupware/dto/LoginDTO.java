package com.groupware.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@Alias("LoginDTO")
public class LoginDTO {
    private Long employeeIdx;
    private String loginId;
    private String loginPw;
    private Integer state;
}
