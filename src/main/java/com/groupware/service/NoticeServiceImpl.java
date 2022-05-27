package com.groupware.service;

import java.util.List;

import com.groupware.dto.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.groupware.mapper.NoticeMapper;
import com.groupware.vo.CommonSearchVO;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
	
	private final NoticeMapper mapper;

	@Override
	public Notice.detailDTO insert(Notice.insertDTO insertDTO) {
		mapper.insert(insertDTO);
		return this.select(insertDTO.getNoticeIdx());
	}

	@Override
	public Notice.detailDTO update(Notice.updateDTO updateDTO) {
		mapper.update(updateDTO);
		return this.select(updateDTO.getNoticeIdx());
	}

	@Override
	public Notice.detailDTO delete(Long noticeIdx) {
		Notice.detailDTO resNoticeDTO = this.select(noticeIdx);
		return mapper.delete(noticeIdx) < 1 ? null : resNoticeDTO;
	}

	@Override
	public List<Notice.listDTO> selectList(CommonSearchVO searchVO) {
		return mapper.selectList(searchVO);
	}

	@Override
	public Notice.detailDTO select(Long noticeIdx) {
		return mapper.select(noticeIdx);
	}
	
	@Override
	public int deleteBySchedule() {
		return mapper.deleteBySchedule();
	}

}
