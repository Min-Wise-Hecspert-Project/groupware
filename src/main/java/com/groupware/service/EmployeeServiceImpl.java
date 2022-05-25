package com.groupware.service;

import com.groupware.dto.EmployeeDTO;
import com.groupware.mapper.EmployeeMapper;
import com.groupware.vo.CommonSearchVO;
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
	public EmployeeDTO delete(Long employeeIdx) {
		EmployeeDTO resEmployeeDTO = this.select(employeeIdx);
		return mapper.delete(employeeIdx) < 1 ? null : resEmployeeDTO;
	}

	@Override
	public List<EmployeeDTO> selectList(CommonSearchVO searchVO) {
		return mapper.selectList(searchVO);
	}

	@Override
	public EmployeeDTO select(Long employeeIdx) {
		return mapper.select(employeeIdx);
	}
	
	@Override
	public int deleteBySchedule() {
		return mapper.deleteBySchedule();
	}

}
