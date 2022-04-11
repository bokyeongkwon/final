package com146.HOME.CA.BE.domain.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Long memberNum;            //number(10),    --회원번호
    private String id;                  //varchar2(40),      --아이디
    private String name;                // varchar2(40),     --이름
    private String pw;                  //varchar2(15),         --비밀번호
    private String tel;                 //varchar2(13),      --전화번호
    private String email;               //varchar2(40),   --이메일
    private String birth;               //varchar2(10),            --생년월일
    private String  gender;             //char(3) default '여', 성별(남,여)
    private String nickname;            //varchar2(40),         --별칭
    private LocalDateTime cdate;        //TIMESTAMP default systimestamp --생성일시
    private LocalDateTime udate;        //TIMESTAMP  --변경일시

    public Member(String id, String name, String pw, String tel, String email, String birth, String nickname){
        this.id = id;
        this.name = name;
        this.pw = pw;
        this.tel = tel;
        this.email = email;
        this.birth = birth;
        this.nickname = nickname;
    }
}
