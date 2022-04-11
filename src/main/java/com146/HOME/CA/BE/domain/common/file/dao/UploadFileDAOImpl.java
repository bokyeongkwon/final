package com146.HOME.CA.BE.domain.common.file.dao;


import com146.HOME.CA.BE.domain.common.file.UploadFile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UploadFileDAOImpl implements UploadFileDAO{

  private final JdbcTemplate jdbcTemplate;

  //업로드파일 등록-단건
  @Override
  public Long addFile(UploadFile uploadFile) {

    StringBuffer sql = new StringBuffer();
    sql.append("INSERT INTO UPLOAD_FILE ( ");
    sql.append("  file_num, ");
    sql.append("  cate_num, ");
    sql.append("  board_num, ");
    sql.append("  store_file_name, ");
    sql.append("  upload_file_name, ");
    sql.append("  file_size, ");
    sql.append("  file_type ");
    sql.append(") VALUES ( ");
    sql.append("  upload_file_file_num_seq.nextval, ");
    sql.append("  ?, ");
    sql.append("  ?, ");
    sql.append("  ?, ");
    sql.append("  ?, ");
    sql.append("  ?, ");
    sql.append("  ? ");
    sql.append(") ");

    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(sql.toString(),new String[]{"uploadfile_id"});
        pstmt.setInt(1, uploadFile.getCateNum());
        pstmt.setLong(2,uploadFile.getBoardNum());
        pstmt.setString(3, uploadFile.getStoreFileName());
        pstmt.setString(4, uploadFile.getUploadFileName());
        pstmt.setLong(5, uploadFile.getFileSize());
        pstmt.setString(6, uploadFile.getFileType());
        return pstmt;
      }
    },keyHolder);

    return Long.valueOf(keyHolder.getKeys().get("file_num").toString());
  }

  //업로드파일 등록-여러건
  @Override
  public void addFile(List<UploadFile> uploadFile) {

    StringBuffer sql = new StringBuffer();
    sql.append("INSERT INTO UPLOAD_FILE ( ");
    sql.append("  file_num, ");
    sql.append("  cate_num, ");
    sql.append("  board_num, ");
    sql.append("  store_file_name, ");
    sql.append("  upload_file_name, ");
    sql.append("  file_size, ");
    sql.append("  file_type ");
    sql.append(") VALUES ( ");
    sql.append("  upload_file_file_num_seq.nextval, ");
    sql.append("  ?, ");
    sql.append("  ?, ");
    sql.append("  ?, ");
    sql.append("  ?, ");
    sql.append("  ?, ");
    sql.append("  ? ");
    sql.append(") ");

    //배치 처리 : 여러건의 갱신작업을 한꺼번에 처리하므로 단건처리할때보다 성능이 좋다.
    jdbcTemplate.batchUpdate(sql.toString(), new BatchPreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setInt(1, uploadFile.get(i).getCateNum());
        ps.setLong(2,uploadFile.get(i).getBoardNum());
        ps.setString(3, uploadFile.get(i).getStoreFileName());
        ps.setString(4, uploadFile.get(i).getUploadFileName());
        ps.setLong(5, uploadFile.get(i).getFileSize());
        ps.setString(6, uploadFile.get(i).getFileType());
      }

      //배치처리할 건수
      @Override
      public int getBatchSize() {
        return uploadFile.size();
      }
    });

  }

  //조회
  @Override
  public List<UploadFile> getFilesByCateNumWithBoardNum(int cateNum, Long boardNum) {
    StringBuffer sql = new StringBuffer();

    sql.append("SELECT  ");
    sql.append("   file_num, ");
    sql.append("   cate_num, ");
    sql.append("   board_num,  ");
    sql.append("   store_file_name, ");
    sql.append("   upload_file_name,  ");
    sql.append("   file_size,  ");
    sql.append("   file_type,  ");
    sql.append("   file_date  ");
    sql.append("  FROM  UPLOAD_FILE  ");
    sql.append(" WHERE cate_num = ?  ");
    sql.append("   AND board_num = ?  ");

    List<UploadFile> list = jdbcTemplate.query(sql.toString(),
        new BeanPropertyRowMapper<>(UploadFile.class), cateNum, boardNum);
    log.info("list={}",list);
    return list;
  }

  //첨부파일 조회
  @Override
  public UploadFile findFileByfileNum(Long fileNum) {
    StringBuffer sql = new StringBuffer();
    sql.append(" select * ");
    sql.append("  from UPLOAD_FILE ");
    sql.append(" where file_num = ? ");

    UploadFile uploadFile = null;
    try {
      uploadFile = jdbcTemplate.queryForObject(
          sql.toString(),
          new BeanPropertyRowMapper<>(UploadFile.class),
              fileNum);
    }catch (EmptyResultDataAccessException e){
      e.printStackTrace();
      uploadFile = null;
    }
    return uploadFile;
  }

  // 첨부파일 삭제 by uplaodfileId
  @Override
  public int deleteFileByfileNum(Long fileNum) {
    StringBuffer sql = new StringBuffer();
    sql.append("delete from UPLOAD_FILE ");
    sql.append(" where file_num = ? ");

    return jdbcTemplate.update(sql.toString(), fileNum);
  }

  // 첨부파일 삭제 by uplaodfileId
  @Override
  public int deleteFileByCateNumWithBoardNum(int cateNum, Long boardNum) {
    StringBuffer sql = new StringBuffer();
    sql.append("delete from UPLOAD_FILE ");
    sql.append(" where cate_num = ? ");
    sql.append("   and board_num = ? ");

    return jdbcTemplate.update(sql.toString(), cateNum, boardNum);
  }
}
