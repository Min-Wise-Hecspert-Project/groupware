package com.groupware.service;

import com.groupware.dto.EmployeeDTO;
import com.groupware.mapper.EmployeeMapper;
import com.groupware.vo.CommonSearchVO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeMapper mapper;

	@Override
	public EmployeeDTO insert(EmployeeDTO employeeDTO) {
		mapper.insert(employeeDTO);
		return this.select(employeeDTO.getEmployeeIdx());
	}

	@Override
	public EmployeeDTO update(EmployeeDTO employeeDTO) {
		mapper.update(employeeDTO);
		return this.select(employeeDTO.getEmployeeIdx());
	}

	@Override
	public EmployeeDTO delete(Long noticeIdx) {
		EmployeeDTO resEmployeeDTO = this.select(noticeIdx);
		return mapper.delete(noticeIdx) < 1 ? null : resEmployeeDTO;
	}

	@Override
	public List<EmployeeDTO> selectList(CommonSearchVO searchVO) {
		return mapper.selectList(searchVO);
	}

	@Override
	public EmployeeDTO select(Long noticeIdx) {
		return mapper.select(noticeIdx);
	}
	
	@Override
	public int deleteBySchedule() {
		return mapper.deleteBySchedule();
	}

}
