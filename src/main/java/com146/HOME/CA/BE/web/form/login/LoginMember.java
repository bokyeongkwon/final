package com146.HOME.CA.BE.web.form.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginMember {

  private String id;              //아이디 VARCHAR2(40)
  private String nickname;        //닉네임 VARCHAR2(40)

}
