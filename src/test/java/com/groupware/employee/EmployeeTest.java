package com.groupware.employee;

import com.groupware.config.RootConfig;
import com.groupware.config.ServletConfig;
import com.groupware.dto.Employee;
import com.groupware.service.EmployeeService;
import com.groupware.vo.CommonSearchVO;
import com.groupware.vo.EmployeeSearchVO;
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
public class EmployeeTest {
    @Autowired
    private EmployeeService es;

    @Test
    public void getEmployeeTest(){
        EmployeeSearchVO searchVO = new EmployeeSearchVO("","","","",1,1,10);
        ResponseEntity<Map<String, Object>> mapResponseEntity = es.selectList(searchVO);
        log.info(mapResponseEntity);
    }

    @Test
    public void getEmployee(){
        ResponseEntity<Employee.DetailDTO> select = es.select(1L);
        log.info(select);
    }

    @Test
    public void insertEmployee(){
        Employee.InsertDTO insertDTO = new Employee.InsertDTO();
        insertDTO.setName("삽입테스트");
        insertDTO.setCompanyIdx(1L);
        log.info(es.insert(insertDTO));
    }
}
