package com.groupware.service;

import java.util.List;

import com.groupware.dto.EmployeeDTO;
import com.groupware.vo.CommonSearchVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface EmployeeService {
	ResponseEntity<EmployeeDTO> insert(EmployeeDTO employeeDTO);
	ResponseEntity<EmployeeDTO> update(EmployeeDTO employeeDTO);
	ResponseEntity<EmployeeDTO> delete(Long employeeDTO);
	ResponseEntity<List<EmployeeDTO>> selectList(CommonSearchVO searchVO);
	ResponseEntity<EmployeeDTO> select(Long employeeIdx);
	int deleteBySchedule();

}
