package com146.HOME.CA.BE.domain.login.svc;

import com146.HOME.CA.BE.domain.login.Login;
import com146.HOME.CA.BE.domain.login.dao.LoginDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class LoginSVCImpl implements LoginSVC{

  private final LoginDAO loginDAO;

  //로그인
  @Override
  public Login login(String id, String pw) {
    return null;
  }

//  //비밀번호 일치여부 체크
//  @Override
//  public boolean isLogin(String id, String pw) {
//    return false;
//  }

  //아이디찾기(휴대폰)
  @Override
  public Login searchTelID(String name, String tel) {
    return null;
  }

  //아이디찾기(이메일)
  @Override
  public Login searchEmailID(String name, String email) {
    return null;
  }

  //비밀번호찾기(휴대폰)
  @Override
  public Login searchTelPW(String id, String tel) {
    return null;
  }

  //비밀번호찾기(이메일)
  @Override
  public Login searchEmailPW(String id, String email) {
    return null;
  }
}