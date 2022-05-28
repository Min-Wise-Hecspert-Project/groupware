package com.groupware.service;

import java.util.List;

import com.groupware.dto.Notice;
import com.groupware.vo.CommonSearchVO;
import org.springframework.http.ResponseEntity;

public interface NoticeService {
	ResponseEntity<Notice.detailDTO> insert(Notice.insertDTO insertDTO);
	ResponseEntity<Notice.detailDTO> update(Notice.updateDTO updateDTO);
	ResponseEntity<Notice.detailDTO> delete(Long noticeIdx);
	ResponseEntity<List<Notice.listDTO>> selectList(CommonSearchVO searchVO);
	ResponseEntity<Notice.detailDTO> select(Long noticeIdx);
	int deleteBySchedule();

}
