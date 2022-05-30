package com.groupware.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CronMapper {
    int deleteNotice();
    int deleteBoard();
}
