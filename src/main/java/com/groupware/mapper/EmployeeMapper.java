package com.groupware.mapper;

import com.groupware.dto.EmployeeDTO;
import com.groupware.vo.CommonSearchVO;

import java.util.List;

public interface EmployeeMapper {
	List<EmployeeDTO> selectList(CommonSearchVO searchVO);
	
	Long insert(EmployeeDTO Notice);
	
	EmployeeDTO select(Long noticeIdx);

	Long update(EmployeeDTO employeeDTO);

	Long delete(Long noticeIdx);
	
	int deleteBySchedule();
}
