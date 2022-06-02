package com.groupware.mapper;

import com.groupware.dto.JoinDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JoinMapper {
    int join(JoinDTO joinDTO);
}
