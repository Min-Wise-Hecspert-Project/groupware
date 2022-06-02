package com.groupware.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("JoinDTO")
public class JoinDTO {

    private Long teamIdx=0L;
    private Long dutyIdx=0L;
    private Long positionIdx=0L;
    private String loginId;
    private String loginPw;
    private String loginPwCheck;
    private String name;
    private String enName;
    private String profileImage="";
    private String gender="";
    private String birthday="";
    private String phoneNumber="";
    private String email="";
    private String address="";
}
