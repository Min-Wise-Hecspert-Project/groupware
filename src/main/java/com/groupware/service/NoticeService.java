package com.groupware.service;

import java.util.List;

import com.groupware.dto.NoticeDTO;

public interface NoticeService {
	Boolean insert(NoticeDTO noticeDTO);
	Boolean update(NoticeDTO noticeDTO);
	Boolean delete(Long noticeDTO);
	List<NoticeDTO> getNoticeList();
	NoticeDTO getNotice(Long noticeDTO);

}
