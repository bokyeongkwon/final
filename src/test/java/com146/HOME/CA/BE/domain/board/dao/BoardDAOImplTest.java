package com146.HOME.CA.BE.domain.board.dao;

import com146.HOME.CA.BE.domain.board.Board;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class BoardDAOImplTest {

  @Autowired
  private BoardDAO boardDAO;

  @Test
  @DisplayName("게시글 등록")
  void insertBoard() {
    Board board = new Board();
    board.setCateNum(41);
    board.setBoardTitle("베이킹 클래스");
    board.setMemberNum(1L);
    board.setNickname("닉네임1");
    board.setBoardContent("베이킹 클래스");

    Long insertedNum = boardDAO.insertBoard(board);
    Assertions.assertThat(insertedNum).isEqualTo(5);
    log.info("insertedNum={}", insertedNum);

  }

  @Test
  @DisplayName("게시글 조회")
  void selectByNum() {
    Long num = 3L;
    Board foundItem = boardDAO.selectByBoardNum(num);
  //    조회수 증가
    boardDAO.increaseHit(num);

    log.info("foundItem={}",foundItem);
    Assertions.assertThat(foundItem.getBoardNum()).isEqualTo(num);
    Assertions.assertThat(foundItem.getBoardHit()).isEqualTo(0);
  }

  @Test
  @DisplayName("게시글 수정")
  void updateByNum() {
    //    수정할 게시물 id
    Long num = 4L;
//    덮어쓸 새 객체를 만들고 수정하고 싶은 내용 채우기.
    Board board = new Board();
//    다 안 넣어도 될 걸..? 아니네.
    board.setCateNum(41);
    board.setBoardTitle("장현동 베이킹 클래스");
    board.setBoardContent("당근케이크 만들었어요 맛있어보이죠?");

    int i = boardDAO.updateByBoardNum(num, board);
    Assertions.assertThat(i).isEqualTo(1);
    log.info("updatedItem={}", board);
  }

  @Test
  @DisplayName("게시글 삭제")
  void deleteByNum() {
    //    삭제할 id
    Long num = 5L;
//    삭제빵
    int i = boardDAO.deleteByBoardNum(num);
    Assertions.assertThat(i).isEqualTo(1);
  }

  @Test
  @DisplayName("조회수 증가")
  void increaseHit() {
    Long num = 3L;
    boardDAO.increaseHit(num);

    Assertions.assertThat(boardDAO.selectByBoardNum(num).getBoardHit()).isEqualTo(1);
    log.info("hit={}", boardDAO.selectByBoardNum(num).getBoardHit());

  }

  @Test
  @DisplayName("특정 카테고리 게시판 목록")
  void selectBoard() {
    int cate = 41;  //베이킹 클래스 게시판
    int startRec = 1;
    int endRec = 10;
    List<Board> board = boardDAO.selectBoard(cate, startRec, endRec);

    log.info("board={}", board);

  }

  @Test
  @DisplayName("게시판별 총 게시물 개수")
  void totalCount() {
    int cate = 31;
    int i = boardDAO.totalCount(cate);

    Assertions.assertThat(i).isEqualTo(1);
    log.info("i={}", i);
  }

  @Test
  @DisplayName("샘플 데이터 다수 등록")
  void insertBbss() {
    for(int i=1; i<101; i++) {
      Board board = new Board();
      board.setCateNum(11);
      board.setBoardTitle("제과"+i);
      board.setMemberNum(1L);
      board.setNickname("닉네임1");
      board.setBoardContent("제과"+i);

      boardDAO.insertBoard(board);
    }
  }


}