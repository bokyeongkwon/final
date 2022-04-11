package com146.HOME.CA.BE.web.form.login;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FindEmailPW {

  private String id;              //아이디 VARCHAR2(40)
  private String email;           //이메일 VARCHAR2(40)

}
