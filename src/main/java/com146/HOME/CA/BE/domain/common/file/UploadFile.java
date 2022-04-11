package com146.HOME.CA.BE.domain.common.file;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UploadFile {
  private Long fileNum;          //  number(10) --파일아이디
  private int cateNum;         //  NUMBER(10) --분류코드
  private Long boardNum;         //  number(10) --게시글 번호
  private String storeFileName; //  VARCHAR2(150) --서버보관 파일명
  private String uploadFileName;//  VARCHAR2(150) --업로드 파일명
  private Long fileSize;         //  NUMBER(30) --파일크기
  private String fileType;       //  VARCHAR2(100) --파일유형
  private LocalDateTime fileDate;// TIMESTAMP default systimestamp --작성일
  private byte[] fileDatae;        //  BLOB --첨부파일
}
