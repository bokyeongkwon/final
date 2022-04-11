package com146.HOME.CA.BE.domain.login.svc;


import com146.HOME.CA.BE.domain.login.Login;

public interface LoginSVC {

  /**
   * 로그인
   * @param id
   * @param pw
   * @return
   */
  Login login(String id, String pw);

//  /**
//   * 비밀번호 일치여부 체크
//   * @param id
//   * @param pw
//   * @return
//   */
//  boolean isLogin(String id, String pw);

  /**
   * 아이디 찾기(전화번호)
   * @param name
   * @param tel
   * @return
   */
  Login searchTelID(String name, String tel);

  /**
   * 아이디 찾기(이메일)
   * @param name
   * @param email
   * @return
   */
  Login searchEmailID(String name, String email);

  /**
   * 비밀번호 찾기(전화번호)
   * @param id
   * @param tel
   * @return
   */
  Login searchTelPW(String id, String tel);

  /**
   * 비밀번호 찾기(이메일)
   * @param id
   * @param email
   * @return
   */
  Login searchEmailPW(String id, String email);

}
