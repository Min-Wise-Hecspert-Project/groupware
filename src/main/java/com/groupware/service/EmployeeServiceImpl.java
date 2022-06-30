package com.groupware.service;

import com.groupware.dto.BoardDTO;
import com.groupware.mapper.BoardMapper;
import com.groupware.dto.Employee;
import com.groupware.mapper.EmployeeMapper;
import com.groupware.vo.EmployeeSearchVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeMapper mapper;

	@Override
	public ResponseEntity<Employee.DetailDTO> insert(Employee.InsertDTO insertDTO) {
		mapper.insert(insertDTO);

		Employee.DetailDTO resEmployeeDTO = this.getEmployee(insertDTO.getEmployeeIdx());

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
	public ResponseEntity<Employee.DetailDTO> update(Employee.UpdateDTO updateDTO) {
		mapper.update(updateDTO);
		Employee.DetailDTO resEmployeeDTO = this.getEmployee(updateDTO.getEmployeeIdx());

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
	public ResponseEntity<Map<String, Object>> selectList(EmployeeSearchVO searchVO) {

		List<Employee.ListDTO> listDTOS = mapper.selectList(searchVO);

		Map<String, Object> employeeListPageMap = new HashMap<>();

		HttpHeaders headers = new HttpHeaders();
		headers.add("zzz","utf-8");

		if(listDTOS.size() < 1 ) {
			// 값이 없을때 204 - 응답 body가 필요 없는 자원 But error message 를 위해 200으로 보낸다~!
			String message = "no employee ^^";
			employeeListPageMap.put("result", false);
			employeeListPageMap.put("message", message);
		} else {
			// 성공시 200 - OK
			employeeListPageMap.put("result", true);

			Map<String, Integer> pagination = new HashMap<>();
			pagination.put("page", searchVO.getPage());
			pagination.put("totalCount", mapper.getTotalCount(searchVO));

			Map<String, Object> data = new HashMap<>();
			data.put("contents", listDTOS);
			data.put("pagination", pagination);

			employeeListPageMap.put("data", data);
		}

		return ResponseEntity
				.status(HttpStatus.OK)
				.headers(headers)
				.body(employeeListPageMap);
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
	public ResponseEntity<Map<String, Object>> deleteBySchedule() {
		int i = mapper.deleteBySchedule();

		Map<String, Object> resultMap = new HashMap<>();

		if(i >= 1){
			resultMap.put("result", true);
			resultMap.put("rows", i);

			return ResponseEntity
					.status(HttpStatus.OK)
					.body(resultMap);
		} else {
			return ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.build();
		}
	}

	@Override
	public ResponseEntity<Employee.DetailDTO> info(HttpSession session) {
		return null;
	}

	public Employee.DetailDTO getEmployee(Long employeeIdx) {
		return mapper.select(employeeIdx);
	}


}
