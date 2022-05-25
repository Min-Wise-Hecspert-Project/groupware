package com.groupware.service;

import java.util.List;

import com.groupware.dto.NoticeDTO;
import com.groupware.vo.CommonSearchVO;

public interface NoticeService {
	NoticeDTO insert(NoticeDTO noticeDTO);
	NoticeDTO update(NoticeDTO noticeDTO);
	NoticeDTO delete(Long noticeDTO);
	List<NoticeDTO> selectList(CommonSearchVO searchVO);
	NoticeDTO select(Long noticeIdx);
	int deleteBySchedule();

}
