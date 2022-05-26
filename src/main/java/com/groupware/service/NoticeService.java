package com.groupware.service;

import java.util.List;

import com.groupware.dto.Notice;
import com.groupware.vo.CommonSearchVO;

public interface NoticeService {
	Notice.detailDTO insert(Notice.insertDTO insertDTO);
	Notice.detailDTO update(Notice.updateDTO updateDTO);
	Notice.detailDTO delete(Long noticeIdx);
	List<Notice.listDTO> selectList(CommonSearchVO searchVO);
	Notice.detailDTO select(Long noticeIdx);
	int deleteBySchedule();

}
