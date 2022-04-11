package com146.HOME.CA.BE.web.form.board;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DetailForm {

    private Long boardNum;	            //NUMBER(10) --게시판 게시글 번호
    private int cateNum;	            //NUMBER(10) --분류코드
    private String boardTitle;	        //VARCHAR2(150) --게시글 제목
    private Long memberNum;	        //NUMBER(10) --회원번호
    private String nickname;            //varchar2(40) --별칭
    private String boardDate;	        //TIMESTAMP default systimestamp --작성일
    private Long boardHit;	            //NUMBER(5) default '0' --조회수
    private String boardContent;	    //CLOB --게시글 내용
    private String fromRecipe;          //varchar2(30) --레시피 출처
    private String boardMapAddress;	//VARCHAR2(300) --지도 API에서 받은 주소

    private Long ReplyNum;                    //댓글번호 NUMBER(10)
    private LocalDate replyDate;              //작성일 TIMESTAMP
    private String replyContent;              //댓글내용 CLOB
    private int replyGroup;                   //댓글그룹 NUMBER(5)
    private int replyStep;                    //댓글의 단계 NUMBER(5)
    private int replyIndent;                  //댓글의 들여쓰기 NUMBER(5)
    private int preplyNum;                    //부모댓글번호 NUMBER(10)

}
