package com.groupware.service;

import java.util.List;

import com.groupware.dto.BoardDTO;
import com.groupware.dto.EmployeeDTO;
import com.groupware.vo.CommonSearchVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface EmployeeService {
	EmployeeDTO insert(EmployeeDTO employeeDTO);
	EmployeeDTO update(EmployeeDTO employeeDTO);
	EmployeeDTO delete(Long employeeDTO);
	List<EmployeeDTO> selectList(CommonSearchVO searchVO);
	EmployeeDTO select(Long employeeIdx);
	int deleteBySchedule();

}
