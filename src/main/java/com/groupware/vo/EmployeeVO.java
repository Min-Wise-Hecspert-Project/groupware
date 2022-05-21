package com.groupware.vo;

import lombok.Data;

@Data
public class EmployeeVO {
	private long empIdx;
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
