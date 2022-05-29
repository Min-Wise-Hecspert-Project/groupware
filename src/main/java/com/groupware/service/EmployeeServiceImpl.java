package com.groupware.service;

import com.groupware.dto.EmployeeDTO;
import com.groupware.mapper.EmployeeMapper;
import com.groupware.vo.CommonSearchVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * @Question
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeMapper mapper;

	@Override
	public ResponseEntity<EmployeeDTO> insert(EmployeeDTO employeeDTO) {
		mapper.insert(employeeDTO);

		EmployeeDTO resEmployeeDTO = this.getEmployee(employeeDTO.getEmployeeIdx());

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
	public ResponseEntity<EmployeeDTO> update(EmployeeDTO employeeDTO) {
		mapper.update(employeeDTO);
		EmployeeDTO resEmployeeDTO = this.getEmployee(employeeDTO.getEmployeeIdx());

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
	public ResponseEntity<EmployeeDTO> delete(Long employeeIdx) {
		EmployeeDTO employeeDTO = this.getEmployee(employeeIdx);
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
	public ResponseEntity<List<EmployeeDTO>> selectList(CommonSearchVO searchVO) {

		List<EmployeeDTO> employeeDTOS = mapper.selectList(searchVO);

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
	public ResponseEntity<EmployeeDTO> select(Long employeeIdx) {

		EmployeeDTO employeeDTO = this.getEmployee(employeeIdx);

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

	public EmployeeDTO getEmployee(Long employeeIdx) {
		return mapper.select(employeeIdx);
	}

}
