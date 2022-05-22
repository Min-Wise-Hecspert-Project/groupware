package com.groupware.service;

import java.util.List;

import com.groupware.vo.NoticeVO;

public interface NoticeService {
	Boolean insert(NoticeVO noticeVO);
	Boolean update(NoticeVO noticeVO);
	Boolean delete(Long noticeIdx);
	List<NoticeVO> getNoticeList();
	NoticeVO getNotice(Long noticeIdx);

}
