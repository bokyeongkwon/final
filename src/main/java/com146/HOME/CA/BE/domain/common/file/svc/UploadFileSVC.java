package com146.HOME.CA.BE.domain.common.file.svc;


import com146.HOME.CA.BE.domain.common.file.UploadFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadFileSVC {

  /**
   * 업로드파일 처리-단건
   * @param cateNum  분류코드(ex 계시판,상품등록..)
   * @param boardNum   참조ID(ex 게시글번호, 상품번호..)
   * @param file  첨부파일
   * @return 성공여부
   */
  boolean addFile(int cateNum, Long boardNum, MultipartFile file);
  /**
   * 업로드파일 처리-여러건
   * @param cateNum  분류코드(ex 계시판,상품등록..)
   * @param boardNum   참조ID(ex 게시글번호, 상품번호..)
   * @param files  첨부파일
   * @return 성공여부
   */
  boolean addFile(int cateNum, Long boardNum, List<MultipartFile> files);

  /**
   * 업로드파일 경로
   * @param cateNum
   * @return
   */
  String getFullPath(int cateNum);
  /**
   * 업로드파일조회
   * @param cateNum
   * @param boardNum
   * @return
   */
  List<UploadFile> getFilesByCateNumWithBoardNum(int cateNum, Long boardNum);

  /**
   * 첨부파일조회
   * @param  fileNum 첨부파일 아이디
   * @return 첨부파일 메타정보
   */
  UploadFile findFileByFileNum(Long fileNum);

  /**
   * 첨부파일 삭제 by file_num
   * @param fileNum 첨부파일아이디
   * @return 삭제한 레코드수
   */
  int deleteFileByFileNum(Long fileNum);

  /**
   * 첨부파일 삭제 By cateNum, boardNum
   * @param cateNum 첨부파일 분류코드
   * @param boardNum 첨부파일아이디
   * @return 삭제한 레코드수
   */
  int deleteFileByCateNumWithBoardNum(int cateNum, Long boardNum);

}