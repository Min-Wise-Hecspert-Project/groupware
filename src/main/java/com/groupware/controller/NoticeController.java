package com.groupware.controller;

import com.groupware.dto.NoticeDTO;
import com.groupware.global.Config;
import com.groupware.service.NoticeService;
import com.groupware.vo.CommonSearchVO;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Log4j
public class NoticeController {

		private final NoticeService service;
		
		@GetMapping("/notice")
		public ResponseEntity<List<NoticeDTO>> list(
				@RequestParam(defaultValue = "") String title,
				@RequestParam(defaultValue = "") String content,
				@RequestParam(defaultValue = "") String writer,
				@RequestParam(defaultValue = "1") Integer sorting,
				@RequestParam(defaultValue = "1") Integer page
				) {
			
			CommonSearchVO searchVO = new CommonSearchVO(title, content, writer, sorting, page, Config.globalPageSize);
			
			List<NoticeDTO> dtos = service.selectList(searchVO);
			
			if(dtos.size() < 1 ) {
				// 媛믪씠 �뾾�쓣�븣 204 - �쓳�떟 body媛� �븘�슂 �뾾�뒗 �옄�썝
				return ResponseEntity
						.status(HttpStatus.NO_CONTENT)
						.body(null);
			} else {
				// �꽦怨듭떆 200 - OK
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(dtos);
			}
		}

		
		@PostMapping("/notice")
		public ResponseEntity<NoticeDTO> post(NoticeDTO noticeDTO) {

			NoticeDTO resNoticeDTO = service.insert(noticeDTO);
			
			if(resNoticeDTO == null) {
				// �떎�뙣�떆 409 - �빐�떦 �슂泥��쓽 泥섎━媛� 鍮꾩��땲�뒪 濡쒖쭅�긽 遺덇��뒫�븯嫄곕굹 紐⑥닚�씠 �깮湲� 寃쎌슦
				return ResponseEntity
						.status(HttpStatus.CONFLICT)
						.body(null);
			} else {
				// �꽦怨듭떆 201 - �슂泥��뿉 �꽦怨듯븯怨� �깉濡쒖슫 由ъ냼�뒪瑜� 留뚮뱺 寃쎌슦
				return ResponseEntity
						.status(HttpStatus.CREATED)
						.body(resNoticeDTO);
			}
		}
		
		@GetMapping("/notice/{noticeIdx}")
		public ResponseEntity<NoticeDTO> get(@PathVariable("noticeIdx") Long noticeIdx) {

			NoticeDTO resNoticeDTO = service.select(noticeIdx);
			
			if(resNoticeDTO == null) {
				// 媛믪씠 �뾾�쓣�븣 204 - �쓳�떟 body媛� �븘�슂 �뾾�뒗 �옄�썝
				return ResponseEntity
						.status(HttpStatus.NO_CONTENT)
						.body(null);
			} else {
				// �꽦怨듭떆 200 - OK
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(resNoticeDTO);
			}
		}
		
		@PutMapping("/notice")
		public ResponseEntity<NoticeDTO> put(@RequestBody NoticeDTO noticeDTO) {

			NoticeDTO resNoticeDTO = service.update(noticeDTO);

			if(resNoticeDTO == null) {
				// �떎�뙣�떆 409 - �빐�떦 �슂泥��쓽 泥섎━媛� 鍮꾩��땲�뒪 濡쒖쭅�긽 遺덇��뒫�븯嫄곕굹 紐⑥닚�씠 �깮湲� 寃쎌슦
				return ResponseEntity
						.status(HttpStatus.CONFLICT)
						.body(null);
			} else {
				// �꽦怨듭떆 200 - OK
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(resNoticeDTO);
			}
		}
		
		@DeleteMapping("/notice/{noticeIdx}")		
		public ResponseEntity<NoticeDTO> delete(@PathVariable("noticeIdx") Long noticeIdx) {
			
			NoticeDTO resNoticeDTO = service.delete(noticeIdx);
			
			if(resNoticeDTO == null) {
				// �떎�뙣�떆 409 - �빐�떦 �슂泥��쓽 泥섎━媛� 鍮꾩��땲�뒪 濡쒖쭅�긽 遺덇��뒫�븯嫄곕굹 紐⑥닚�씠 �깮湲� 寃쎌슦
				return ResponseEntity
						.status(HttpStatus.CONFLICT)
						.body(null);				
			} else {
				// �꽦怨듭떆 200 - OK
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(resNoticeDTO);
			}

		}
		
		@DeleteMapping("/notice/schedule")
		public void deleteBySchedule(RedirectAttributes rttr) {
			log.info("deleteBySchedule: ");	
//			return ResponseEntity
//					.status(HttpStatus.OK)
//					.body(null); // �닔�젙 �븘�슂
		}
}
