package com.groupware.service;

import java.util.Map;

import com.groupware.dto.Employee;
import com.groupware.vo.EmployeeSearchVO;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
	ResponseEntity<Employee.DetailDTO> insert(Employee.InsertDTO insertDTO);
	ResponseEntity<Employee.DetailDTO> update(Employee.DetailDTO employeeDTO);
	ResponseEntity<Employee.DetailDTO> delete(Long employeeDTO);
	ResponseEntity<Map<String, Object>> selectList(EmployeeSearchVO searchVO);
	ResponseEntity<Employee.DetailDTO> select(Long employeeIdx);
	int deleteBySchedule();

}
