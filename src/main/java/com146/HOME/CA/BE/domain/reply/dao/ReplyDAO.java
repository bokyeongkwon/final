package com146.HOME.CA.BE.domain.reply.dao;

import com146.HOME.CA.BE.domain.reply.Reply;

import java.util.List;

public interface ReplyDAO {

    //게시글에 댓글 불러오기
    List<Reply> showReply(Long boardNum);

    //댓글 작성
    Long writeReply(Reply reply);

    //댓글 수정
    String modifyReply(String modifiedContent, Long replyNum, Long memberNum) throws IllegalAccessException;

    //댓글 삭제
    void deleteReply(Long replyNum) throws IllegalAccessException;

    //부모 댓글 불러오기
    Reply findParentReply(Long replyNum);

    //대댓글 작성
    Long writeReplyReply(Reply reply);
}
