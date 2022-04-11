package com146.HOME.CA.BE.web.form.login;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FindTelID {

  private String name;          //이름 VARCHAR2(40)
  private String tel;           //전화번호 VARCHAR2(13)
}
