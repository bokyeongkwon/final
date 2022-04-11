package com146.HOME.CA.BE.web.form.mypage;

import lombok.Data;

import java.sql.Blob;
import java.time.LocalDateTime;

@Data
public class LikeListForm {
    private Long likeNum;              //관심리스트 번호 NUMBER(10)
    private Long memberNum;            //회원번호  NUMBER(10)
    private int likeChk;               //관심리스트 체크 여부 CHAR
    private Long boardNum;             //게시판 게시글 번호 NUMBER(10)
    private Blob boardPicture;         //대표 사진 BLOB
    private String boardTitle;         //게시글 제목 VARCHAR2(150)
    private LocalDateTime boardDate;   //게시물 작성일 TIMESTAMP
    private String nickname;           //닉네임 VARCHAR2(40)
    private Long boardHit;             //조회수 NUMBER(5)
}
