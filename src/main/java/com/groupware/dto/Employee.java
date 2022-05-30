package com.groupware.dto;

import lombok.*;

import java.util.Date;

public class Employee {

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter	@Setter	@ToString
	public static class DetailDTO {
		private Long employeeIdx;
		private String companyName;
		private String departmentName;
		private String teamName;
		private String positionName;
		private String dutyName;
		private String name;
		private String enName;
		private String profileImage;
		private String gender;
		private String birthday;
		private String phoneNumber;
		private String email;
		private String address;
		private int salary;
		private String annualLeave;
		private int state;
		private Date hireDate;
		private Date resignationDate;
		private Date insDate;
		private Date updDate;
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter	@Setter	@ToString
	public static class ListDTO {
		private Long employeeIdx;
		private String companyName;
		private String departmentName;
		private String teamName;
		private String positionName;
		private String dutyName;
		private String name;
		private String enName;
		private String profileImage;
		private String gender;
		private int state;
		private Date hireDate;
		private Date resignationDate;
		private Date insDate;
		private Date updDate;
	}

}
