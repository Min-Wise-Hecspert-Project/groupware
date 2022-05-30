package com.groupware.mapper;

import com.groupware.dto.Employee;
import com.groupware.vo.CommonSearchVO;

import java.util.List;

public interface EmployeeMapper {
	List<Employee.ListDTO> selectList(CommonSearchVO searchVO);
	
	Long insert(Employee.DetailDTO Notice);

	Employee.DetailDTO select(Long noticeIdx);

	Long update(Employee.DetailDTO employeeDTO);

	Long delete(Long noticeIdx);
	
	int deleteBySchedule();

	Integer getTotalCount(CommonSearchVO searchVO);
}
