package com.groupware.join;

import com.groupware.config.RootConfig;
import com.groupware.config.ServletConfig;
import com.groupware.dto.JoinDTO;
import com.groupware.mapper.JoinMapper;
import com.groupware.service.JoinService;
import com.groupware.service.Validation;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@Log4j
public class JoinTest {
    @Autowired
    JoinService joinService;

    @Autowired
    Validation validation;

    @Test
    public void joinTest(){
        JoinDTO joinDTO = new JoinDTO();
        joinDTO.setLoginId("1");
        joinDTO.setLoginPw("");
        joinDTO.setLoginPwCheck("");
        ResponseEntity<Map<String, Object>> mapResponseEntity = joinService.joinAction(joinDTO);

        log.info(mapResponseEntity);
    }
}
