package com146.HOME.CA.BE.domain.board.dao;

import com146.HOME.CA.BE.domain.board.Board;

import java.util.List;

public interface BoardDAO {
    //num = seq

    /**
     * 등록
     * @param board 등록내용
     * @return  게시글 번호
     */
    Long insertBoard(Board board);

    /**
     * 상세조회
     * @param boardNum 게시글 번호
     * @return  게시글
     */
    Board selectByBoardNum(Long boardNum);

    /**
     * 수정
     * @param boardNum 게시글 번호
     * @param board 수정내용
     * @return  수정건수
     */
    int updateByBoardNum(Long boardNum, Board board);

    /**
     * 삭제
     * @param boardNum 게시글 번호
     * @return  삭제건수
     */
    int deleteByBoardNum(Long boardNum);

    /**
     * 조회수 증가
     * @param boardNum 게시글 번호
     * @return  수정건수
     */
    int increaseHit(Long boardNum);

    /**
     * 게시판 분류별 전체조회
     * @param cateNum       카테고리
     * @param startRec      첫게시물
     * @param endRec        마지막 게시물
     * @return      게시판 별 게시물
     */
    List<Board> selectBoard(int cateNum, int startRec, int endRec);

    /**
     * 게시판 별 전체 게시물
     * @param cateNum       카테고리
     * @return          게시판 별 전체 게시물 수
     */
    int totalCount(int cateNum);

    //댓글 등록
    Long insertReply(Board board);

    //댓글 조회
    List<Board> replyList(long boardNum, int startRec, int endRec);

    //댓글 수정
    int updateReply(Long replyNum, Board board);

    //댓글 삭제
    int deleteReply(Long replyNum);

    /**
     * 검색
     * @param filterCondition 분류,시작레코드번호,종료레코드번호,검색유형,검색어
     * @return
     */
    List<Board> findAll(BoardFilterCondition filterCondition);

    /**
     * 검색 한 게시물 수
     * @param filterCondition 분류,시작레코드번호,종료레코드번호,검색유형,검색어
     * @return
     */
    int totalCount(BoardFilterCondition filterCondition);
}
