package com.groupware.mapper;

import java.util.List;

import com.groupware.dto.NoticeDTO;

public interface NoticeMapper {
	public List<NoticeDTO> selectList();
	
	public int insert(NoticeDTO Notice);
	
	public NoticeDTO select(Long noticeIdx);

	public int update(NoticeDTO NoticeDTO);

	public int delete(Long noticeIdx);
	
	public int deleteBySchedule();
}
