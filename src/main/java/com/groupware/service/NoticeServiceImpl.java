package com.groupware.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.NoticeDTO;
import com.groupware.mapper.NoticeMapper;
import com.groupware.vo.SearchVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class NoticeServiceImpl implements NoticeService {
	
	NoticeMapper mapper;

	@Override
	public Boolean insert(NoticeDTO noticeDTO) {
		return mapper.insert(noticeDTO) >= 1;
	}

	@Override
	public Boolean update(NoticeDTO noticeDTO) {
		return mapper.update(noticeDTO) >= 1;
	}

	@Override
	public Boolean delete(Long noticeIdx) {
		return mapper.delete(noticeIdx) >= 1;
	}

	@Override
	public List<NoticeDTO> selectList(SearchVO searchVO) {
		return mapper.selectList(searchVO);
	}

	@Override
	public NoticeDTO select(Long noticeIdx) {
		return mapper.select(noticeIdx);
	}
	
	@Override
	public Boolean deleteBySchedule() {
		return mapper.deleteBySchedule()>= 1;
	}

}
