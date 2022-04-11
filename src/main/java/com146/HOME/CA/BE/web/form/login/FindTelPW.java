package com146.HOME.CA.BE.web.form.login;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FindTelPW {

  private String id;              //아이디 VARCHAR2(40)
  private String tel;             //전화번호 VARCHAR2(13)

}
