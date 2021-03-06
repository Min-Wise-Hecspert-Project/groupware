package com.groupware.service;

import java.util.Map;

import com.groupware.dto.BoardDTO;
import com.groupware.vo.CommonSearchVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.groupware.dto.Employee;
import com.groupware.vo.EmployeeSearchVO;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpSession;

public interface EmployeeService {
	ResponseEntity<Employee.DetailDTO> insert(Employee.InsertDTO insertDTO);
	ResponseEntity<Employee.DetailDTO> update(Employee.UpdateDTO employeeDTO);
	ResponseEntity<Employee.DetailDTO> delete(Long employeeDTO);
	ResponseEntity<Map<String, Object>> selectList(EmployeeSearchVO searchVO);
	ResponseEntity<Employee.DetailDTO> select(Long employeeIdx);
	ResponseEntity<Map<String, Object>> deleteBySchedule();

    ResponseEntity<Employee.DetailDTO> info(HttpSession session);
}
