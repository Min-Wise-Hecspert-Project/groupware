package com.groupware.global.controller;

import com.groupware.dto.NoticeFileDTO;
import com.groupware.global.Config;
import com.groupware.global.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class FileController {


    private final FileService fileService;

    @PostMapping("/notice/file")
    public ResponseEntity<List<NoticeFileDTO>> fileUpload(MultipartFile[] multipartFiles) {
        return fileService.fileUpload(multipartFiles);
    }
}
