package com146.HOME.CA.BE.web.form.login;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FindEmailID {

  private String name;          //이름 VARCHAR2(40)
  private String email;         //이메일 VARCHAR2(40)
}
