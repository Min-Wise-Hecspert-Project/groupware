package com.groupware.mapper;

import java.util.List;

import com.groupware.dto.Notice;
import com.groupware.vo.CommonSearchVO;

public interface NoticeMapper {
	List<Notice.listDTO> selectList(CommonSearchVO searchVO);
	
	Long insert(Notice.insertDTO insertDTO);
	
	Notice.detailDTO select(Long noticeIdx);

	Long update(Notice.updateDTO updateDTO);

	Long delete(Long noticeIdx);
	
	int deleteBySchedule();
}
