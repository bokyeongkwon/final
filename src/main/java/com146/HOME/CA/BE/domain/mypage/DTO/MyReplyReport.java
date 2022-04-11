package com146.HOME.CA.BE.domain.mypage.DTO;

import lombok.Data;

import java.sql.Clob;
import java.time.LocalDateTime;

@Data
public class MyReplyReport {
    private Long reportNum;             //신고번호 NUMBER(10)
    private Long memberNUm;             //회원번호 NUMBER(10)
    private LocalDateTime reportDate;   //신고일 TIMESTAMP
    private Clob replyContent;          //신고 된 댓글 CLOB
    private Clob reportContent;         //신고 내용 CLOB
    private Long replyNum;              //댓글 번호 NUMBER(10)
    private int reportProceed;          //신고 진행 사항 CHAR(0) DEFAULT '진행 중'
    private int result;                 //신고 결과 CHAR(0) DEFAULT '없음'
    private Clob resultReason;          //신고 결과 이유 CLOB
    private LocalDateTime resultDate;   //신고 결과 처리일 TIMESTAMP
}
