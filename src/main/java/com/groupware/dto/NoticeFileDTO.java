package com.groupware.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NoticeFileDTO {
    private Long noticeFileIdx;
    private Long noticeIdx;
    private String uuid;
    private String filePath;
    private String fileName;
    private int fileType;
}
