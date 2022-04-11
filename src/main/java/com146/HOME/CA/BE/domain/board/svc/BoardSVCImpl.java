package com146.HOME.CA.BE.domain.board.svc;


import com146.HOME.CA.BE.domain.board.Board;
import com146.HOME.CA.BE.domain.board.dao.BoardDAO;
import com146.HOME.CA.BE.domain.board.dao.BoardFilterCondition;
import com146.HOME.CA.BE.domain.common.file.svc.UploadFileSVC;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardSVCImpl implements BoardSVC {

  private final BoardDAO boardDAO;
  private final UploadFileSVC uploadFileSVC;

  /**
   * 등록
   * @param board
   * @return
   */
  @Override
  public Long boardUpload(Board board) {
    return boardDAO.insertBoard(board);
  }

  /**
   * 등록 - 첨부파일 포함
   * @param board
   * @param files
   * @return
   */
  @Override
  public Long boardUpload(Board board, List<MultipartFile> files) {
    //1)원글 저장
    Long boardNum = boardUpload(board);

    //2)첨부 저장
    uploadFileSVC.addFile(board.getCateNum(), boardNum,files);

    return boardNum;
  }

  /**
   * 상세 조회, 조회수 +1
   * @param boardNum
   * @return
   */
  @Override
  public Board findByBoardNum(Long boardNum) {
    Board foundItem = boardDAO.selectByBoardNum(boardNum);
    boardDAO.increaseHit(boardNum);
    return foundItem;
  }

  /**
   * 수정
   * @param boardNum
   * @param board
   * @return
   */
  @Override
  public int boardUpdate(Long boardNum, Board board) {
    return boardDAO.updateByBoardNum(boardNum, board);
  }

  /**
   *  수정 - 첨부파일 포함
   * @param boardNum 게시글 번호
   * @param board 수정내용
   * @param files 첨부파일
   * @return
   */
  @Override
  public int boardUpdate(Long boardNum, Board board, List<MultipartFile> files) {
    //1)수정
    int affectedRow = boardUpdate(boardNum,board);

    //2)첨부 저장
    uploadFileSVC.addFile(board.getCateNum(),boardNum,files);

    return affectedRow;
  }

  /**
   * 삭제
   * @param boardNum
   * @return
   */
  @Override
  public int deleteByBoardNum(Long boardNum) {
    //1)첨부파일 삭제
    int cateNum = boardDAO.selectByBoardNum(boardNum).getCateNum();
    uploadFileSVC.deleteFileByCateNumWithBoardNum(cateNum, boardNum);

    //2)게시글 삭제
    int affectedRow =  boardDAO.deleteByBoardNum(boardNum);

    return affectedRow;
  }

  /**
   * 페이징 적용된 카테고리별 게시판 목록
   * @param cateCode
   * @param startRec
   * @param endRec
   * @return
   */
  @Override
  public List<Board> selectBoard(int cateCode, int startRec, int endRec) {
    return boardDAO.selectBoard(cateCode, startRec, endRec);
  }

  /**
   * 카테고리별 게시물 총 개수
   * @param cateCode
   * @return
   */
  @Override
  public int totalCount(int cateCode) {
    return boardDAO.totalCount(cateCode);
  }

  /**
   * 검색
   * @param filterCondition 분류,시작레코드번호,종료레코드번호,검색유형,검색어
   * @return
   */
  @Override
  public List<Board> findAll(BoardFilterCondition filterCondition) {
    return boardDAO.findAll(filterCondition);
  }

  /**
   * 댓글 작성
   * @param board
   * @return
   */
  @Override
  public Long insertReply(Board board) {
    return boardDAO.insertReply(board);
  }

  /**
   * 댓글 수정
   * @param replyNum
   * @param board
   * @return
   */
  @Override
  public int updateReply(Long replyNum, Board board) {
    return boardDAO.updateReply(replyNum, board);
  }

  /**
   * 댓글 삭제
   * @param replyNum
   * @return
   */
  @Override
  public int deleteReply(Long replyNum) {
    return boardDAO.deleteReply(replyNum);
  }
}
