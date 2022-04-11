package com146.HOME.CA.BE.domain.login.dao;

import com146.HOME.CA.BE.domain.login.Login;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class LoginDAOImpl implements LoginDAO{

  private final JdbcTemplate jdbcTemplate;


  // 로그인
  @Override
  public Login login(String id, String pw) {

    StringBuffer sql = new StringBuffer();
    sql.append("select name, tel, email ");
    sql.append("from member ");
    sql.append("where id = ? and pw = ? ");

    List<Login> list = jdbcTemplate.query(
            sql.toString(),
            new BeanPropertyRowMapper<>(Login.class),
            id,pw
    );

    return list.size() == 1 ? list.get(0) : null;

  }
//
//  // 비밀번호 일치여부 체크
//  @Override
//  public boolean isLogin(String id, String pw) {
//    return false;
//  }

  // 아이디 찾기(전화번호)
  @Override
  public Login findTelID(String name, String tel) {

    StringBuffer sql = new StringBuffer();

    sql.append("select id ");
    sql.append("  from member ");
    sql.append("  where name = ? and tel = ? ");

    Login LoginTelID = jdbcTemplate.queryForObject(
            sql.toString(),
            new BeanPropertyRowMapper<>(Login.class),
            name, tel);

    return LoginTelID;
  }

  // 아이디 찾기(이메일)
  @Override
  public Login findEmailID(String name, String email) {

    StringBuffer sql = new StringBuffer();

    sql.append("select id ");
    sql.append("  from member ");
    sql.append("  where name = ? and email = ? ");

    Login LoginEmailId = jdbcTemplate.queryForObject(
            sql.toString(),
            new BeanPropertyRowMapper<>(Login.class),
            name, email);

    return LoginEmailId;
  }

  // 비밀번호 찾기(전화번호)
  @Override
  public Login findTelPW(String id, String tel) {

    StringBuffer sql = new StringBuffer();

    sql.append("select pw ");
    sql.append("  from member ");
    sql.append("  where id = ? and tel = ? ");

    Login LoginTelPW = jdbcTemplate.queryForObject(
            sql.toString(),
            new BeanPropertyRowMapper<>(Login.class),
            id, tel);


    return LoginTelPW;
  }

  // 비밀번호 찾기(이메일)
  @Override
  public Login findEmailPW(String id, String email) {

    StringBuffer sql = new StringBuffer();

    sql.append("select pw ");
    sql.append("  from member ");
    sql.append("  where id = ? and email = ? ");

    Login LoginEmailPW = jdbcTemplate.queryForObject(
            sql.toString(),
            new BeanPropertyRowMapper<>(Login.class),
            id, email);

    return LoginEmailPW;
  }
}
