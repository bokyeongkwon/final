package com146.HOME.CA.BE.domain.common.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CategoryDAOImpl implements CategoryDAO {
  //  DB연동
  private final JdbcTemplate jdbcTemplate;

  /**
   * 상위 분류 > 하위 분류
   * @param pcateNum 상위 분류 ex) 10
   * @return 하위 ex) 11, 12, 13, 14...
   */
  @Override
  public List<Category> category(int pcateNum) {
    StringBuffer sql = new StringBuffer();
    sql.append(" SELECT t1.cate_num cateNum, t1.cate_name cateName ");
    sql.append(" FROM category t1, category t2 ");
    sql.append(" where t1.pcate_num = t2.cate_num ");
    sql.append(" and t1.useyn = 'Y' ");
    sql.append(" and t1.pcate_num = ? ");

    List<Category> categories = jdbcTemplate.query(
        sql.toString(),
        new BeanPropertyRowMapper<>(Category.class),
        pcateNum
    );
    return categories;
  }

  /**
   * 하위 카테고리가 소속된 상위 카테고리명을 추출해 페이지 소제목과 왼쪽 서브메뉴에 표시.
   * @param ccateNum 11~52 까지의 하위 카테고리
   * @return 상위 카테고리명
   */
  @Override
  public List<Category> superCategory(int ccateNum) {
    StringBuffer sql = new StringBuffer();
    sql.append(" select cate_num, cate_name ");
    sql.append(" from category ");
    sql.append(" where cate_num in ( ");
    sql.append("                     select pcate_num ");
    sql.append("                     from category ");
    sql.append("                     where cate_num like ?) ");

    List<Category> aSuper = jdbcTemplate.query(
        sql.toString(),
        new BeanPropertyRowMapper<>(Category.class),
        ccateNum
    );
    return aSuper;
  }

  /**
   * 카테고리 테이블의 모든 사용중 레코드 반환
   * @return 일반게시판 분류(< 60)까지 반환
   */
  @Override
  public List<CategoryAll> categoryAll() {
    StringBuffer sql = new StringBuffer();
    sql.append(" select t1.pcate_num pcateNum, t2.cate_name pcateName, t1.cate_num ccate, t1.cate_name ccateName ");
    sql.append(" from category t1, category t2 ");
    sql.append(" where t1.pcate_num = t2.cate_num ");
    sql.append(" and t1.useyn = 'Y' ");
    sql.append(" and t1.pcate_num < 60 ");

    List<CategoryAll> categoryAll = jdbcTemplate.query(
        sql.toString(),
        new BeanPropertyRowMapper<>(CategoryAll.class)
    );
    return categoryAll;
  }
}