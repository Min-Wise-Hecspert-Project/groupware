package com.groupware.service;

import java.util.List;

import com.groupware.dto.Employee;
import com.groupware.vo.CommonSearchVO;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
	ResponseEntity<Employee.DetailDTO> insert(Employee.DetailDTO employeeDTO);
	ResponseEntity<Employee.DetailDTO> update(Employee.DetailDTO employeeDTO);
	ResponseEntity<Employee.DetailDTO> delete(Long employeeDTO);
	ResponseEntity<List<Employee.DetailDTO>> selectList(CommonSearchVO searchVO);
	ResponseEntity<Employee.DetailDTO> select(Long employeeIdx);
	int deleteBySchedule();

}
