package com146.HOME.CA.BE.domain.report;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Report {
    Long reportNum;                   //신고번호 NUMBER(10)
    Long memberNum;                   //회원번호 NUMBER(10)
    LocalDate reportDate;             //신고일 TIMESTAMP
    String reportContent;             //신고내용 CLOB
    Long boardNum;                    //게시글번호 NUMBER(10)
    Long replyNum;                    //댓글번호 NUMBER(10)
    int reportProceed;                //신고상황 CHAR(0) DEFAULT

    int result;                       //신고결과 CHAR(0) DEFAULT '삭제'
    String resultReason;              //신고결과이유 CLOB
    LocalDate resultDate;             //신고결과처리일 TIMESTAMP
}
