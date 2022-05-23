package com.groupware.mapper;

import java.util.List;

import com.groupware.dto.NoticeDTO;

public interface NoticeMapper {
	public List<NoticeDTO> getNoticeList();
	
	public void insert(NoticeDTO Notice);
	
	public NoticeDTO getNotice(Long noticeIdx);

	public int update(NoticeDTO NoticeDTO);

	public int delete(Long noticeIdx);
}
