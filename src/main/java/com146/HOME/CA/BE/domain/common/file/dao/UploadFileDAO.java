package com146.HOME.CA.BE.domain.common.file.dao;


import com146.HOME.CA.BE.domain.common.file.UploadFile;

import java.util.List;

public interface UploadFileDAO {

  /**
   * 업로드 파일 등록 - 단건
   * @param uploadFile
   * @return 파일Id
   */
  Long addFile(UploadFile uploadFile);

  /**
   * 업로드 파일 등록 - 여러건
   * @param uploadFile
   */
  void addFile(List<UploadFile> uploadFile);

  /**
   * 업로드파일조회
   * @param  cateNum
   * @param boardNum
   * @return
   */
  List<UploadFile> getFilesByCateNumWithBoardNum(int cateNum, Long boardNum);

  /**
   * 첨부파일조회
   * @param fileNum
   * @return
   */
  UploadFile findFileByfileNum(Long fileNum);


  /**
   * 첨부파일 삭제 by uplaodfileId
   * @param fileNum 첨부파일아이디
   * @return 삭제한 레코드수
   */
  int deleteFileByfileNum(Long fileNum);

  /**
   * 첨부파일 삭제 By code, rid
   * @param cateNum 첨부파일 분류코드
   * @param boardNum 첨부파일아이디
   * @return 삭제한 레코드수
   */
  int deleteFileByCateNumWithBoardNum(int cateNum, Long boardNum);
}
