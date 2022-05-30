package com.groupware.service;

import java.util.List;

import com.groupware.dto.Notice;
import com.groupware.vo.CommonSearchVO;
import org.springframework.http.ResponseEntity;

public interface NoticeService {
	ResponseEntity<Notice.DetailDTO> insert(Notice.InsertDTO insertDTO);
	ResponseEntity<Notice.DetailDTO> update(Notice.UpdateDTO updateDTO);
	ResponseEntity<Notice.DetailDTO> delete(Long noticeIdx);
	ResponseEntity<List<Notice.ListDTO>> selectList(CommonSearchVO searchVO);
	ResponseEntity<Notice.DetailDTO> select(Long noticeIdx);
	int deleteBySchedule();

}
