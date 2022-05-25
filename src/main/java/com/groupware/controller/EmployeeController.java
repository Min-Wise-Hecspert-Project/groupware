package com.groupware.controller;

import com.groupware.dto.EmployeeDTO;
import com.groupware.dto.employeeDTO;
import com.groupware.global.Config;
import com.groupware.service.EmployeeService;
import com.groupware.service.employeeService;
import com.groupware.vo.CommonSearchVO;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Log4j
public class EmployeeController {

		private final EmployeeService service;
		
		@GetMapping("/employee")
		public ResponseEntity<List<EmployeeDTO>> list(
				@RequestParam(defaultValue = "") String title,
				@RequestParam(defaultValue = "") String content,
				@RequestParam(defaultValue = "") String writer,
				@RequestParam(defaultValue = "1") Integer sorting,
				@RequestParam(defaultValue = "1") Integer page
				) {
			
			CommonSearchVO searchVO = new CommonSearchVO(title, content, writer, sorting, page, Config.globalPageSize);
			
			List<EmployeeDTO> dtos = service.selectList(searchVO);
			
			if(dtos.size() < 1 ) {
				// 값이 없을때 204 - 응답 body가 필요 없는 자원
				return ResponseEntity
						.status(HttpStatus.NO_CONTENT)
						.body(null);
			} else {
				// 성공시 200 - OK
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(dtos);
			}
		}

		
		@PostMapping("/employee")
		public ResponseEntity<EmployeeDTO> post(EmployeeDTO employeeDTO) {

			EmployeeDTO resemployeeDTO = service.insert(employeeDTO);
			
			if(resemployeeDTO == null) {
				// 실패시 409 - 해당 요청의 처리가 비지니스 로직상 불가능하거나 모순이 생긴 경우
				return ResponseEntity
						.status(HttpStatus.CONFLICT)
						.body(null);
			} else {
				// 성공시 201 - 요청에 성공하고 새로운 리소스를 만든 경우
				return ResponseEntity
						.status(HttpStatus.CREATED)
						.body(resemployeeDTO);
			}
		}
		
		@GetMapping("/employee/{employeeIdx}")
		public ResponseEntity<EmployeeDTO> get(@PathVariable("employeeIdx") Long employeeIdx) {

			EmployeeDTO resemployeeDTO = service.select(employeeIdx);
			
			if(resemployeeDTO == null) {
				// 값이 없을때 204 - 응답 body가 필요 없는 자원
				return ResponseEntity
						.status(HttpStatus.NO_CONTENT)
						.body(null);
			} else {
				// 성공시 200 - OK
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(resemployeeDTO);
			}
		}
		
		@PutMapping("/employee")
		public ResponseEntity<EmployeeDTO> put(@RequestBody EmployeeDTO employeeDTO) {

			EmployeeDTO resemployeeDTO = service.update(employeeDTO);

			if(resemployeeDTO == null) {
				// 실패시 409 - 해당 요청의 처리가 비지니스 로직상 불가능하거나 모순이 생긴 경우
				return ResponseEntity
						.status(HttpStatus.CONFLICT)
						.body(null);
			} else {
				// 성공시 200 - OK
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(resemployeeDTO);
			}
		}
		
		@DeleteMapping("/employee/{employeeIdx}")		
		public ResponseEntity<EmployeeDTO> delete(@PathVariable("employeeIdx") Long employeeIdx) {
			
			EmployeeDTO resemployeeDTO = service.delete(employeeIdx);
			
			if(resemployeeDTO == null) {
				// 실패시 409 - 해당 요청의 처리가 비지니스 로직상 불가능하거나 모순이 생긴 경우
				return ResponseEntity
						.status(HttpStatus.CONFLICT)
						.body(null);				
			} else {
				// 성공시 200 - OK
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(resemployeeDTO);
			}

		}
		
		@DeleteMapping("/employee/schedule")
		public void deleteBySchedule(RedirectAttributes rttr) {
			log.info("deleteBySchedule: ");	
//			return ResponseEntity
//					.status(HttpStatus.OK)
//					.body(null); // 수정 필요
		}
}
