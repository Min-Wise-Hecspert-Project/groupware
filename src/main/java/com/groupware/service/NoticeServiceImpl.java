package com.groupware.service;

import java.util.List;

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
	public NoticeDTO insert(NoticeDTO noticeDTO) {
		mapper.insert(noticeDTO);
		return this.select(noticeDTO.getNoticeIdx());
	}

	@Override
	public NoticeDTO update(NoticeDTO noticeDTO) {
		Long noticeIdx = mapper.update(noticeDTO);
		return this.select(noticeIdx);
	}

	@Override
	public NoticeDTO delete(Long noticeIdx) {
		NoticeDTO resNoticeDTO = this.select(noticeIdx);
		return mapper.delete(noticeIdx) < 1 ? null : resNoticeDTO;
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
	public int deleteBySchedule() {
		return mapper.deleteBySchedule();
	}

}
