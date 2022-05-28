package com.groupware.service;

import java.util.List;

import com.groupware.dto.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupware.mapper.NoticeMapper;
import com.groupware.vo.CommonSearchVO;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
	
	private final NoticeMapper mapper;

	@Override
	public ResponseEntity<Notice.detailDTO> insert(Notice.insertDTO insertDTO) {
		mapper.insert(insertDTO);

		Notice.detailDTO detailDTO = this.getNotice(insertDTO.getNoticeIdx());

		if(detailDTO == null) {
			// 실패시 409 - 해당 요청의 처리가 비지니스 로직상 불가능하거나 모순이 생긴 경우
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(null);
		} else {
			// 성공시 201 - 요청에 성공하고 새로운 리소스를 만든 경우
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(detailDTO);
		}
	}

	@Override
	public ResponseEntity<Notice.detailDTO> update(Notice.updateDTO updateDTO) {
		mapper.update(updateDTO);

		Notice.detailDTO detailDTO = this.getNotice(updateDTO.getNoticeIdx());

		if(detailDTO == null) {
			// 실패시 409 - 해당 요청의 처리가 비지니스 로직상 불가능하거나 모순이 생긴 경우
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(null);
		} else {
			// 성공시 200 - OK
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(detailDTO);
		}

	}

	@Override
	public ResponseEntity<Notice.detailDTO> delete(Long noticeIdx) {
		Notice.detailDTO detailDTO = this.getNotice(noticeIdx);

		Notice.detailDTO resDetailDTO = mapper.delete(noticeIdx) < 1 ? null : this.getNotice(noticeIdx);

		if(resDetailDTO == null) {
			// 실패시 409 - 해당 요청의 처리가 비지니스 로직상 불가능하거나 모순이 생긴 경우
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(null);
		} else {
			// 성공시 200 - OK
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(resDetailDTO);
		}
	}

	@Override
	public ResponseEntity<List<Notice.listDTO>> selectList(CommonSearchVO searchVO) {

		List<Notice.listDTO> listDTOS = mapper.selectList(searchVO);

		if(listDTOS.size() < 1 ) {
			// 값이 없을때 204 - 응답 body가 필요 없는 자원
			return ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.body(null);
		} else {
			// 성공시 200 - OK
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(listDTOS);
		}
	}

	@Override
	public ResponseEntity<Notice.detailDTO> select(Long noticeIdx) {

		Notice.detailDTO detailDTO = this.getNotice(noticeIdx);

		if(detailDTO == null) {
			// 값이 없을때 204 - 응답 body가 필요 없는 자원
			return ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.body(null);
		} else {
			// 성공시 200 - OK
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(detailDTO);
		}

	}
	
	@Override
	public int deleteBySchedule() {
		return mapper.deleteBySchedule();
	}

	private Notice.detailDTO getNotice(Long noticeIdx){
		return mapper.select(noticeIdx);
	}

}
