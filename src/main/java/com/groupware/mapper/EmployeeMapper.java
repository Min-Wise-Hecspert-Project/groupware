package com.groupware.mapper;

import com.groupware.dto.EmployeeDTO;
import com.groupware.dto.NoticeDTO;
import com.groupware.vo.CommonSearchVO;

import java.util.List;

public interface EmployeeMapper {
	public List<EmployeeDTO> selectList(CommonSearchVO searchVO);
	
	public Long insert(EmployeeDTO Notice);
	
	public EmployeeDTO select(Long noticeIdx);

	public Long update(EmployeeDTO employeeDTO);

	public Long delete(Long noticeIdx);
	
	public int deleteBySchedule();
}
