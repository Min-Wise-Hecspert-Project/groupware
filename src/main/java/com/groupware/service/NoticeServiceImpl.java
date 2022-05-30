package com.groupware.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.groupware.dto.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupware.mapper.NoticeMapper;
import com.groupware.vo.CommonSearchVO;
import org.springframework.web.servlet.function.ServerRequest;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
	
	private final NoticeMapper mapper;

	@Override
	public ResponseEntity<Notice.DetailDTO> insert(Notice.InsertDTO insertDTO) {
		mapper.insert(insertDTO);

		Notice.DetailDTO detailDTO = this.getNotice(insertDTO.getNoticeIdx());

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
	public ResponseEntity<Notice.DetailDTO> update(Notice.UpdateDTO updateDTO) {
		mapper.update(updateDTO);

		Notice.DetailDTO detailDTO = this.getNotice(updateDTO.getNoticeIdx());

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
	public ResponseEntity<Notice.DetailDTO> delete(Long noticeIdx) {
		Notice.DetailDTO detailDTO = this.getNotice(noticeIdx);

		Notice.DetailDTO resDetailDTO = mapper.delete(noticeIdx) < 1 ? null : this.getNotice(noticeIdx);

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
	public ResponseEntity<Map<String, Object>> selectList(CommonSearchVO searchVO) {

		List<Notice.ListDTO> listDTOS = mapper.selectList(searchVO);

		Map<String, Object> noticeListPageMap = new HashMap<>();

		HttpHeaders headers = new HttpHeaders();
		headers.add("zzz","utf-8");

		if(listDTOS.size() < 1 ) {
			// 값이 없을때 204 - 응답 body가 필요 없는 자원 But error message 를 위해 200으로 보낸다~!
			String message = "no notice ^^";
			noticeListPageMap.put("result", false);
			noticeListPageMap.put("message", message);
		} else {
			// 성공시 200 - OK
			noticeListPageMap.put("result", true);

			Map<String, Integer> pagination = new HashMap<>();
			pagination.put("page", searchVO.getPage());
			pagination.put("totalCount", mapper.getTotalCount(searchVO));

			Map<String, Object> data = new HashMap<>();
			data.put("contents", listDTOS);
			data.put("pagination", pagination);

			noticeListPageMap.put("data", data);
		}

		return ResponseEntity
				.status(HttpStatus.OK)
				.headers(headers)
				.body(noticeListPageMap);
	}

	@Override
	public ResponseEntity<Notice.DetailDTO> select(Long noticeIdx) {

		Notice.DetailDTO detailDTO = this.getNotice(noticeIdx);

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



	private Notice.DetailDTO getNotice(Long noticeIdx){
		return mapper.select(noticeIdx);
	}

	public int getPageData(CommonSearchVO searchVO) {
		return mapper.getPageData(searchVO);
	}
}
