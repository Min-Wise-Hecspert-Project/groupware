package com.groupware.global.service;

import com.groupware.dto.NoticeFileDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    ResponseEntity<List<NoticeFileDTO>> fileUpload(MultipartFile[] multipartFiles);
}
