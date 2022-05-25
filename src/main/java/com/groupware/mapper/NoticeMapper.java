package com.groupware.mapper;

import java.util.List;

import com.groupware.dto.NoticeDTO;
import com.groupware.vo.CommonSearchVO;

public interface NoticeMapper {
	List<NoticeDTO> selectList(CommonSearchVO searchVO);
	
	Long insert(NoticeDTO Notice);
	
	NoticeDTO select(Long noticeIdx);

	Long update(NoticeDTO NoticeDTO);

	Long delete(Long noticeIdx);
	
	int deleteBySchedule();
}
