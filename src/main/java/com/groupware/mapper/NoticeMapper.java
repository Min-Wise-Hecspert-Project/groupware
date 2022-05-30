package com.groupware.mapper;

import java.util.List;

import com.groupware.dto.Notice;
import com.groupware.vo.CommonSearchVO;

public interface NoticeMapper {
	List<Notice.ListDTO> selectList(CommonSearchVO searchVO);
	
	Long insert(Notice.InsertDTO insertDTO);
	
	Notice.DetailDTO select(Long noticeIdx);

	Long update(Notice.UpdateDTO updateDTO);

	Long delete(Long noticeIdx);
	
	int deleteBySchedule();

	Integer getTotalCount(CommonSearchVO searchVO);
}
