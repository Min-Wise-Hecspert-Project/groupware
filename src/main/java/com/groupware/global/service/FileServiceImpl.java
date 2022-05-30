package com.groupware.global.service;

import com.groupware.dto.NoticeFileDTO;
import com.groupware.global.Config;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{
    @Override
    public ResponseEntity<List<NoticeFileDTO>> fileUpload(MultipartFile[] multipartFiles) {
        String uploadFolder = Config.UPLOAD_FOLDER;
        List<NoticeFileDTO> list = new ArrayList<>();
        File uploadPath = new File(uploadFolder,getFolder());

        if(!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        for(MultipartFile multipartFile: multipartFiles) {
            NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
            UUID uuid = UUID.randomUUID();
            String uploadFileName = multipartFile.getOriginalFilename(); // 파일 이름 설정
            noticeFileDTO.setFileName(uploadFileName);
            noticeFileDTO.setFilePath(getFolder());
            uploadFileName = uuid.toString()+"_"+uploadFileName;

            File saveFile = new File(uploadPath,uploadFileName);
            try {

                multipartFile.transferTo(saveFile);
                noticeFileDTO.setUuid(uuid.toString());
                if (checkImageType(saveFile)) {
                    noticeFileDTO.setFileType(1);
                    FileOutputStream thumbnall =
                            new FileOutputStream(new File(uploadPath, "s_"+uploadFileName));
                    Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnall, 100 , 100);
                    thumbnall.close();
                }

            }catch (Exception e) {

            }
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    private String getFolder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String str = sdf.format(date);
        return str.replace("-", File.separator);
    }
    private boolean checkImageType(File file) {
        try {
            String contentType = Files.probeContentType(file.toPath());
            return contentType.startsWith("image");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
