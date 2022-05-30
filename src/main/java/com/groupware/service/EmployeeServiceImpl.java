package com.groupware.service;

import com.groupware.dto.Employee;
import com.groupware.mapper.EmployeeMapper;
import com.groupware.vo.CommonSearchVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Question
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeMapper mapper;

	@Override
	public ResponseEntity<Employee.DetailDTO> insert(Employee.DetailDTO employeeDTO) {
		mapper.insert(employeeDTO);

		Employee.DetailDTO resEmployeeDTO = this.getEmployee(employeeDTO.getEmployeeIdx());

		if(resEmployeeDTO == null) {
			// 실패시 409 - 해당 요청의 처리가 비지니스 로직상 불가능하거나 모순이 생긴 경우
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(null);
		} else {
			// 성공시 201 - 요청에 성공하고 새로운 리소스를 만든 경우
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(resEmployeeDTO);
		}
	}

	@Override
	public ResponseEntity<Employee.DetailDTO> update(Employee.DetailDTO employeeDTO) {
		mapper.update(employeeDTO);
		Employee.DetailDTO resEmployeeDTO = this.getEmployee(employeeDTO.getEmployeeIdx());

		if(resEmployeeDTO == null) {
			// 실패시 409 - 해당 요청의 처리가 비지니스 로직상 불가능하거나 모순이 생긴 경우
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(null);
		} else {
			// 성공시 200 - OK
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(resEmployeeDTO);
		}
	}

	@Override
	public ResponseEntity<Employee.DetailDTO> delete(Long employeeIdx) {
		Employee.DetailDTO employeeDTO = this.getEmployee(employeeIdx);
		employeeDTO = mapper.delete(employeeIdx) < 1 ? null : employeeDTO;

		if(employeeDTO == null) {
			// 실패시 409 - 해당 요청의 처리가 비지니스 로직상 불가능하거나 모순이 생긴 경우
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(null);
		} else {
			// 성공시 200 - OK
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(employeeDTO);
		}
	}

	@Override
	public ResponseEntity<List<Employee.DetailDTO>> selectList(CommonSearchVO searchVO) {

		List<Employee.DetailDTO> employeeDTOS = mapper.selectList(searchVO);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		if(employeeDTOS.size() < 1 ) {
			// 값이 없을때 204 - 응답 body가 필요 없는 자원
			return ResponseEntity.noContent()
					.headers(headers)
					.build();

		} else {
			// 성공시 200 - OK
			return ResponseEntity.ok()
					.headers(headers)
					.body(employeeDTOS);
		}
	}

	@Override
	public ResponseEntity<Employee.DetailDTO> select(Long employeeIdx) {

		Employee.DetailDTO employeeDTO = this.getEmployee(employeeIdx);

		if(employeeDTO == null) {
			// 값이 없을때 204 - 응답 body가 필요 없는 자원
			return ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.body(null);
		} else {
			// 성공시 200 - OK
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(employeeDTO);
		}
	}
	
	@Override
	public int deleteBySchedule() {
		return mapper.deleteBySchedule();
	}

	public Employee.DetailDTO getEmployee(Long employeeIdx) {
		return mapper.select(employeeIdx);
	}

}
