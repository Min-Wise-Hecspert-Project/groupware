package com.groupware.mapper;

import com.groupware.dto.Employee;
import com.groupware.vo.CommonSearchVO;

import java.util.List;

public interface EmployeeMapper {
	List<Employee> selectList(CommonSearchVO searchVO);
	
	Long insert(Employee Notice);
	
	Employee select(Long noticeIdx);

	Long update(Employee employeeDTO);

	Long delete(Long noticeIdx);
	
	int deleteBySchedule();
}
