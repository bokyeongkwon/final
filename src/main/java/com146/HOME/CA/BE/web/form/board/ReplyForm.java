
package com146.HOME.CA.BE.web.form.board;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReplyForm {
    private Long ReplyNum;                    //댓글번호 NUMBER(10)
    private Long boardNum;                    //게시물 번호 NUMBER(10)
    private Long memberNum;                   //회원번호 NUMBER(10)
    private LocalDate replyDate;              //작성일 TIMESTAMP
    private String replyContent;              //댓글내용 CLOB
    private int replyGroup;                   //댓글그룹 NUMBER(5)
    private int replyStep;                    //댓글의 단계 NUMBER(5)
    private int replyIndent;                  //댓글의 들여쓰기 NUMBER(5)
    private int preplyNum;                    //부모댓글번호 NUMBER(10)
    private String nickname;            //varchar2(40) --별칭
}
