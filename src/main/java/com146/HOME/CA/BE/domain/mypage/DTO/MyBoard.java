package com146.HOME.CA.BE.domain.mypage.DTO;

import lombok.Data;

import java.sql.Blob;
import java.time.LocalDateTime;

@Data
public class MyBoard {
    private Long boardNum;            //게시판 게시글 번호 NUMBER(10)
    private Long cateCode;            //분류코드 NUMBER(10)
    private String boardTitle;        //게시글 제목 VARCHAR2(150)
    private Long memberNum;           //회원번호 NUMBER(10)
    private LocalDateTime boardDate;  //작성일 TIMESTAMP
    private Long boardHit;            //조회수 NUMBER(5)
    private Blob boardPicture;        //대표 사진 BLOB
}
