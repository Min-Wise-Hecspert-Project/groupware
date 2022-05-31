package com.groupware.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@Alias("JoinDTO")
public class JoinDTO {
    private String loginId;
    private String loginPw;
    private String loginPwCheck;
}
