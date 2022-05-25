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
@RequiredArgsConstructor
@Alias("EmployeeDTO")
public class EmployeeDTO {
	@NonNull
	private Long employeeIdx;
	
	@NonNull
	private Long companyIdx;
	
	@NonNull
	private Long teamIdx;
	
	@NonNull
	private Long dutyIdx;
	
	@NonNull
	private Long positionIdx;
	
	@NonNull
	private Long authorityIdx;
	
	@NonNull
	private Long departmentIdx;
	
	@NonNull
	private String name;
	
	private String enName;
	
	@NonNull
	private String profileImage;
	
	@NonNull
	private String gender;
	
	private String birthday;
	
	@NonNull
	private String phoneNumber;
	
	@NonNull	
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
