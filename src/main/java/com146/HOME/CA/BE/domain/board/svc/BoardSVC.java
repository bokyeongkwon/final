package com146.HOME.CA.BE.domain.board.svc;


import com146.HOME.CA.BE.domain.board.Board;
import com146.HOME.CA.BE.domain.board.dao.BoardFilterCondition;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardSVC {

  //    num = seq

  /**
   * 등록
   * @param board 등록내용
   * @return  게시글 번호
   */
  Long boardUpload(Board board);

  /**
   * 등록 - 첨부파일 포함
   * @param board
   * @param files
   * @return
   */
  Long boardUpload(Board board, List<MultipartFile> files);

  /**
   * 상세조회
   * @param boardNum 게시글 번호
   * @return  게시글
   */
  Board findByBoardNum(Long boardNum);

  /**
   * 수정
   * @param boardNum 게시글 번호
   * @param board 수정내용
   * @return  수정건수
   */
  int boardUpdate(Long boardNum, Board board);

  /**
   * 수정 - 첨부파일 포함
   * @param boardNum 게시글 번호
   * @param board 수정내용
   * @param files 첨부파일
   * @return 수정건수
   */
  int boardUpdate(Long boardNum, Board board,List<MultipartFile> files);

  /**
   * 삭제
   * @param boardNum 게시글 번호
   * @return  삭제건수
   */
  int deleteByBoardNum(Long boardNum);

  //  전체 조회. 각 게시판 분류별.
  List<Board> selectBoard(int cateCode, int startRec, int endRec);

  //게시판별 전체 게시물 수
  int totalCount(int cateCode);

  /**
   * 검색
   * @param filterCondition 분류,시작레코드번호,종료레코드번호,검색유형,검색어
   * @return
   */
  List<Board > findAll(BoardFilterCondition filterCondition);

  //댓글 등록
  Long insertReply(Board board);

  //댓글 수정
  int updateReply(Long replyNum, Board board);

  //댓글 삭제
  int deleteReply(Long replyNum);
}
