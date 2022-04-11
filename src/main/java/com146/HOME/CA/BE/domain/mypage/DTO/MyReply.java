package com146.HOME.CA.BE.domain.mypage.DTO;

import lombok.Data;

import java.sql.Clob;
import java.time.LocalDateTime;

@Data
public class MyReply {
    private Long replyNum;            //댓글 번호 NUMBER(10)
    private Long boardNum;            //게시글 번호 NUMBER(10)
    private Long memberNum;           //회원번호 NUMBER(10)
    private LocalDateTime replyDate;  //작성일 TIMESTAMP
    private Clob replyContent;        //댓글 내용 CLOB
    private Long replyGroup;          //댓글 그룹 NUMBER(5)
    private Long replyStep;           //댓글 단계 NUMBER(5)
    private Long replyIndent;         //댓글 들여쓰기 NUMBER(5)
    private Long preplyNum;           //부모댓글번호 NUMBER(10)
    
}
