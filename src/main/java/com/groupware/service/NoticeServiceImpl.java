package com.groupware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.NoticeDTO;
import com.groupware.mapper.NoticeMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class NoticeServiceImpl implements NoticeService {
	
	NoticeMapper mapper;

	@Override
	public Boolean insert(NoticeDTO noticeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(NoticeDTO noticeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long noticeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeDTO> getNoticeList() {
		return mapper.getNoticeList();
	}

	@Override
	public NoticeDTO getNotice(Long noticeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
