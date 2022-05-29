package com.groupware.controller;

import com.groupware.dto.Employee;
import com.groupware.service.EmployeeService;
import com.groupware.vo.CommonSearchVO;

import java.util.List;

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
		public ResponseEntity<List<Employee>> list(
				@RequestParam(value = "name", defaultValue = "") String writer,
				@RequestParam(defaultValue = "") Integer sorting,
				@RequestParam(defaultValue = "1") Integer page
				) {
			
			CommonSearchVO searchVO = new CommonSearchVO(writer, sorting, page);
			
			return service.selectList(searchVO);
		}

		
		@PostMapping("/employee")
		public ResponseEntity<Employee> post(Employee employeeDTO) {
			return service.insert(employeeDTO);
		}
		
		@GetMapping("/employee/{employeeIdx}")
		public ResponseEntity<Employee> get(@PathVariable("employeeIdx") Long employeeIdx) {
			return service.select(employeeIdx);
		}
		
		@PutMapping("/employee")
		public ResponseEntity<Employee> put(@RequestBody Employee employeeDTO) {
			return service.update(employeeDTO);
		}
		
		@DeleteMapping("/employee/{employeeIdx}")		
		public ResponseEntity<Employee> delete(@PathVariable("employeeIdx") Long employeeIdx) {
			return service.delete(employeeIdx);
		}
		
		@DeleteMapping("/employee/schedule")
		public void deleteBySchedule(RedirectAttributes rttr) {
			log.info("deleteBySchedule: ");	
//			return ResponseEntity
//					.status(HttpStatus.OK)
//					.body(null); // 수정 필요
		}
}
