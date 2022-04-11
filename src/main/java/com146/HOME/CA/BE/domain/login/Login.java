package com146.HOME.CA.BE.domain.login;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Login {

  private String id;
  private String name;
  private String pw;
  private String tel;
  private String email;

  public Login(String id, String pw){
    this.id = id;
    this.pw = pw;
  }
}
