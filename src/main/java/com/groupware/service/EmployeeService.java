package com.groupware.service;

import java.util.List;

import com.groupware.dto.Employee;
import com.groupware.vo.CommonSearchVO;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
	ResponseEntity<Employee> insert(Employee employeeDTO);
	ResponseEntity<Employee> update(Employee employeeDTO);
	ResponseEntity<Employee> delete(Long employeeDTO);
	ResponseEntity<List<Employee>> selectList(CommonSearchVO searchVO);
	ResponseEntity<Employee> select(Long employeeIdx);
	int deleteBySchedule();

}
