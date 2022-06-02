package com.groupware.service;

import java.util.Map;

<<<<<<< HEAD
import com.groupware.dto.BoardDTO;
import com.groupware.dto.EmployeeDTO;
import com.groupware.vo.CommonSearchVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
=======
import com.groupware.dto.Employee;
import com.groupware.vo.EmployeeSearchVO;
import org.springframework.http.ResponseEntity;
>>>>>>> 457e3ca7769cbac2906710120786be81e281095b

public interface EmployeeService {
	ResponseEntity<Employee.DetailDTO> insert(Employee.InsertDTO insertDTO);
	ResponseEntity<Employee.DetailDTO> update(Employee.UpdateDTO employeeDTO);
	ResponseEntity<Employee.DetailDTO> delete(Long employeeDTO);
	ResponseEntity<Map<String, Object>> selectList(EmployeeSearchVO searchVO);
	ResponseEntity<Employee.DetailDTO> select(Long employeeIdx);
	ResponseEntity<Map<String, Object>> deleteBySchedule();

}
