package com146.HOME.CA.BE.domain.login.dao;

import com146.HOME.CA.BE.domain.login.Login;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
public class LoginDAOImplTest {

  @Autowired
  private LoginDAO loginDAO;
  
  @Test
  @DisplayName("로그인")
  void login() {
    
    String id = "tester2";
    String pw = "1234";
    
    Login login = loginDAO.login(id,pw);
    Assertions.assertThat(login).isNotNull();
  }

  @Test
  @DisplayName("아이디찾기(휴대폰)")
  void findTelID() {
    String name = "홍길동";
    String tel = "232-1111";

    Login telID = loginDAO.findTelID("홍길동","232-1111");
    Assertions.assertThat(telID.getId()).isEqualTo("tester2");
  }

  @Test
  @DisplayName("아이디찾기(이메일)")
  void findEmailID() {
    String name = "홍길동";
    String email = "tester2@kh.com";

    Login emailIDs = loginDAO.findEmailID("홍길동","tester2@kh.com");
    Assertions.assertThat(emailIDs.getId()).isEqualTo("tester2");
  }

  @Test
  @DisplayName("비밀번호찾기(휴대폰)")
  void findTelPW() {
    String id = "tester2";
    String tel = "232-1111";

    Login telPWs = loginDAO.findTelPW("tester2", "232-1111");
    Assertions.assertThat(telPWs.getPw()).isEqualTo("1234");


  }

  @Test
  @DisplayName("비밀번호찾기(이메일)")
  void findEmailPW() {
    String id = "tester2";
    String email = "tester2@kh.com";

    Login emailPWs = loginDAO.findEmailPW("tester2", "tester2@kh.com");
    Assertions.assertThat(emailPWs.getPw()).isEqualTo("1234");
  }
}