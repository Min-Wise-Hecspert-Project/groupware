package com.groupware.service;

import java.util.List;

import com.groupware.dto.NoticeDTO;
import com.groupware.vo.SearchVO;

public interface NoticeService {
	Boolean insert(NoticeDTO noticeDTO);
	Boolean update(NoticeDTO noticeDTO);
	Boolean delete(Long noticeDTO);
	List<NoticeDTO> selectList(SearchVO searchVO);
	NoticeDTO select(Long noticeIdx);
	Boolean deleteBySchedule();

}
