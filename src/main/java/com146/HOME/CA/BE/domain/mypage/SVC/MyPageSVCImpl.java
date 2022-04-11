package com146.HOME.CA.BE.domain.mypage.SVC;

import com146.HOME.CA.BE.domain.mypage.DAO.MyPageDAO;
import com146.HOME.CA.BE.domain.mypage.DTO.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MyPageSVCImpl implements MyPageSVC{

    private final MyPageDAO myPageDAO;

    // 구독/알림 목록
    @Override
    public List<Subscribe> subscribeList() {
        return  myPageDAO.subscribeList();
    }

    // 알림 설정
    @Override
    public int setAlarm(int alarm) {
        return myPageDAO.setAlarm(alarm);
    }

    // 구독 취소
    @Override
    public int deleteSubscribe(long subNum) {
        return myPageDAO.deleteSubscribe(subNum);
    }

    // 관심리스트 목록
    @Override
    public List<Like> likeList() {
        return myPageDAO.likeList();
    }

    // 관심리스트 삭제
    @Override
    public int deleteLike(long likeNum) {
        return myPageDAO.deleteLike(likeNum);
    }

    // 내가 작성한 게시물 목록
    @Override
    public List<MyBoard> myBoardList() {
        return myPageDAO.myBoardList();
    }

    // 내가 작성한 댓글 목록
    @Override
    public List<MyReply> myReplyList() {
        return myPageDAO.myReplyList();
    }

    // 내가 신고한 게시물 목록
    @Override
    public List<MyBoardReport> boardReportList() {
        return myPageDAO.boardReportList();
    }

    // 내가 신고한 댓글 목록
    @Override
    public List<MyReplyReport> replyReportList() {
        return myPageDAO.replyReportList();
    }
}
