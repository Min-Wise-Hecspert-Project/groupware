package com.groupware.mapper;

import com.groupware.dto.Employee;
import com.groupware.vo.CommonSearchVO;
import com.groupware.vo.EmployeeSearchVO;

import java.util.List;

public interface EmployeeMapper {
	List<Employee.ListDTO> selectList(EmployeeSearchVO searchVO);
	
	Long insert(Employee.InsertDTO insertDTO);

	Employee.DetailDTO select(Long noticeIdx);

	Long update(Employee.UpdateDTO updateDTO);

	Long delete(Long noticeIdx);
	
	int deleteBySchedule();

	Integer getTotalCount(EmployeeSearchVO searchVO);
}
