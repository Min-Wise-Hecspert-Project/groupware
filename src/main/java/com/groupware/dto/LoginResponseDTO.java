package com.groupware.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("LoginResponseDTO")
public class LoginResponseDTO {
    private Long employeeIdx;
    private String name;
    private Integer state;
}
