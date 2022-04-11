package com146.HOME.CA.BE.web.form.member;

import lombok.Data;

@Data
public class DetailForm {

    private Long memberNum;            //number(10),    --회원번호
    private String id;                  //varchar2(40),      --아이디
    private String name;                // varchar2(40),     --이름
    private String pw;                  //varchar2(15),         --비밀번호
    private String tel;                 //varchar2(13),      --전화번호
    private String email;               //varchar2(40),   --이메일
    private String birth;               //varchar2(10),            --생년월일
    private String  gender;             //char(3) default '여', 성별(남,여)
    private String nickname;            //varchar2(40),         --별칭

}
