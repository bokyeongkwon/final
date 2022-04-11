package com146.HOME.CA.BE.web.form.mypage;

import lombok.Data;

@Data
public class SubscribeForm {
    private Long memberNum;       //구독자 회원번호 NUMBER(10)
    private int alarmChk;         //알림 설정 CHAR
    private Long subMemberNum;    //구독 된 회원번허 NUMBER(10)
    private String nickname;      //구독 된 회원 닉네임 VARCHAR2(40)
    private String boardTitle;    //구독 된 회원의 최신 게시물 제목 VARCHAR2(150)
    private Long boardNum;        //게시판 게시글 번호 NUMBER(10)
    private Long subNum;          //구독/알림 번호 NUMBER(10)
}
