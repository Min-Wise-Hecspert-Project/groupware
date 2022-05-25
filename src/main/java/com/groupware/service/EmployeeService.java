package com.groupware.service;

import java.util.List;

import com.groupware.dto.EmployeeDTO;
import com.groupware.vo.CommonSearchVO;

public interface EmployeeService {
	EmployeeDTO insert(EmployeeDTO employeeDTO);
	EmployeeDTO update(EmployeeDTO employeeDTO);
	EmployeeDTO delete(Long employeeDTO);
	List<EmployeeDTO> selectList(EmployeeDTO searchVO);
	EmployeeDTO select(Long employeeIdx);
	int deleteBySchedule();

}
