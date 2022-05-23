package com.groupware.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("EmployeeDTO")
public class EmployeeDTO {
	private long employeeIdx;
	private long companyIdx ;
	private long 	teamIdx ;
	private long 	dutyIdx ;
	private long 	positionIdx ;
	private long 	authorityIdx ;
	private String 	name;
	private String 	ENName;
	private String 	profileImage;
	private String 	gender;
	private String 	birthday;
	private String 	phone;
	private String 	email;
	private String 	address;
	private String 	salary;
	private String 	annualLeave;
	private String 	state;
	private String 	hireDate;
	private String 	resignationDate;
	private String 	createDate;
	private long 	departmentIdx;


}
