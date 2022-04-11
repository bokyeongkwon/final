package com146.HOME.CA.BE.domain.mypage.DAO;

import com146.HOME.CA.BE.domain.mypage.DTO.*;

import java.util.List;

public interface MyPageDAO {
    // 구독/알림 목록
    List<Subscribe> subscribeList();
    // 알림 설정
    int setAlarm(int alarm);
    // 구독 취소
    int deleteSubscribe(long subNum);
    // 관심리스트 목록
    List<Like> likeList();
    // 관심리스트 삭제
    int deleteLike(long likeNum);
    // 내가 작성한 게시물 목록
    List<MyBoard> myBoardList();
    //내가 작성한 게시물 삭제
    int deleteMyBoard(long memberNum);
    // 내가 작성한 댓글 목록
    List<MyReply> myReplyList();
    int deleteMyReply(long memberNum);
    // 내가 신고한 게시물 목록
    List<MyBoardReport> boardReportList();
    // 내가 신고한 댓글 목록
    List<MyReplyReport> replyReportList();


}
