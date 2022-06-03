package com.groupware.controller;

import com.groupware.dto.Employee;
import com.groupware.service.EmployeeService;
import com.groupware.vo.CommonSearchVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.groupware.vo.EmployeeSearchVO;
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

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Log4j
public class EmployeeController {

		private final EmployeeService service;
		
		@GetMapping("/employee")
		public ResponseEntity<Map<String, Object>> list(
				@RequestParam(value = "name", defaultValue = "") String name,
				@RequestParam(value = "companyName", defaultValue = "") String companyName,
				@RequestParam(value = "departmentName", defaultValue = "") String departmentName,
				@RequestParam(value = "teamName", defaultValue = "") String teamName,
				@RequestParam(defaultValue = "") Integer sorting,
				@RequestParam(defaultValue = "1") Integer page,
				@RequestParam(defaultValue = "10") Integer perPage
				) {

			EmployeeSearchVO searchVO = new EmployeeSearchVO(name, companyName, departmentName, teamName, sorting, page, perPage);
			
			return service.selectList(searchVO);
		}

		
		@PostMapping("/employee")
		public ResponseEntity<Employee.DetailDTO> post(Employee.InsertDTO insertDTO) {
			return service.insert(insertDTO);
		}
		
		@GetMapping("/employee/{employeeIdx}")
		public ResponseEntity<Employee.DetailDTO> get(@PathVariable("employeeIdx") Long employeeIdx) {
			return service.select(employeeIdx);
		}
		@GetMapping("/employee/info")
		public ResponseEntity<Map<String, Object>> info(HttpSession session) {
			Map<String, Object> stringStringMap = new HashMap<>();

			Long employeeIdx = (Long) session.getAttribute("employeeIdx");
			String name = session.getAttribute("name").toString();

			stringStringMap.put("name", name);
			stringStringMap.put("employeeIdx", employeeIdx);

			return ResponseEntity.status(HttpStatus.OK).body(stringStringMap);
		}

		
		@PutMapping("/employee")
		public ResponseEntity<Employee.DetailDTO> put(@RequestBody Employee.UpdateDTO employeeDTO) {
			return service.update(employeeDTO);
		}
		
		@DeleteMapping("/employee/{employeeIdx}")		
		public ResponseEntity<Employee.DetailDTO> delete(@PathVariable("employeeIdx") Long employeeIdx) {
			return service.delete(employeeIdx);
		}
		
		@DeleteMapping("/employee/cron")
		public ResponseEntity<Map<String, Object>> deleteBySchedule() {
			return service.deleteBySchedule();
		}
}
