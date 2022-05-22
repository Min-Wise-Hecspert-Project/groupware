package com.groupware.mapper;

import java.util.List;

import com.groupware.vo.NoticeVO;

public interface NoticeMapper {
	public List<NoticeVO> getNoticeList();
	
	public void insert(NoticeVO Notice);
	
	public NoticeVO getNotice(Long noticeIdx);

	public int update(NoticeVO NoticeVO);

	public int delete(Long noticeIdx);
}
