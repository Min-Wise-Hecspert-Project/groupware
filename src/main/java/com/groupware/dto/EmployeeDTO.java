package com.groupware.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias("EmployeeDTO")
public class EmployeeDTO {
	private Long employeeIdx;
	private Long companyIdx;
	private Long teamIdx;
	private Long dutyIdx;
	private Long positionIdx;
	private Long authorityIdx;
	private Long departmentIdx;
	private String name;
	private String enName;
	private String profileImage;
	private String gender;
	private String birthday;
	private String phoneNumber;
	private String email;
	private String address;
	private String salary;
	private String annualLeave;
	private String state;
	private String hireDate;
	private String resignationDate;
	private String insDate;
	private String updDate;

}
