package com.groupware.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class EmployeeSearchVO {
    private String name;
    private String companyName;
    private String departmentName;
    private String teamName;
    private Integer sorting;
    private Integer page;

    private Integer perPage;
    private Integer startNum;
    private Integer endNum;

    public EmployeeSearchVO(String name, String companyName, String departmentName, String teamName, Integer sorting, Integer page, Integer perPage) {
        this.name = name;
        this.companyName = companyName;
        this.departmentName = departmentName;
        this.teamName = teamName;
        this.sorting = sorting;
        this.page = page;
        this.startNum = (page-1)*perPage;
        this.endNum = page*perPage;
    }
}
