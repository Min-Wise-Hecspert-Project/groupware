package com.groupware.mapper;

import java.util.List;

import com.groupware.dto.NoticeDTO;
import com.groupware.vo.SearchVO;

public interface NoticeMapper {
	public List<NoticeDTO> selectList(SearchVO searchVO);
	
	public Long insert(NoticeDTO Notice);
	
	public NoticeDTO select(Long noticeIdx);

	public Long update(NoticeDTO NoticeDTO);

	public Long delete(Long noticeIdx);
	
	public int deleteBySchedule();
}
