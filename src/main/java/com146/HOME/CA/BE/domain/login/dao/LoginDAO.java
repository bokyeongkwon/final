package com146.HOME.CA.BE.domain.login.dao;


import com146.HOME.CA.BE.domain.login.Login;

import java.lang.reflect.Member;

public interface LoginDAO {

  /**
   * 로그인 인증
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
  Login findTelID(String name, String tel);

  /**
   * 아이디 찾기(이메일)
   * @param name
   * @param email
   * @return
   */
  Login findEmailID(String name, String email);

  /**
   * 비밀번호 찾기(전화번호)
   * @param id
   * @param tel
   * @return
   */
  Login findTelPW(String id, String tel);

  /**
   * 비밀번호 찾기(이메일)
   * @param id
   * @param email
   * @return
   */
  Login findEmailPW(String id, String email);

}
