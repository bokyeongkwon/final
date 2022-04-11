package com146.HOME.CA.BE.domain.reply.svc;

import com146.HOME.CA.BE.domain.reply.Reply;
import com146.HOME.CA.BE.domain.reply.dao.ReplyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplySVCImpl implements ReplySVC{

    private final ReplyDAO replyDAO;

    /**
     * 게시물에 댓글 불러오기
     * @param boardNum
     * @return
     */
    @Override
    public List<Reply> showReply(Long boardNum) {
        return replyDAO.showReply(boardNum);
    }

    /**
     * 댓글 작성
     * @param reply
     * @return
     */
    @Override
    public Long writeReply(Reply reply) {
        return replyDAO.writeReply(reply);
    }

    /**
     * 댓글 수정
     * @param modifiedContent
     * @param replyNum
     * @param memberNum
     * @return
     * @throws IllegalAccessException
     */
    @Override
    public String modifyReply(String modifiedContent, Long replyNum, Long memberNum) throws IllegalAccessException {
        return replyDAO.modifyReply(modifiedContent, replyNum, memberNum);
    }

    /**
     * 댓글 삭제
     * @param replyNum
     * @throws IllegalAccessException
     */
    @Override
    public void deleteReply(Long replyNum) throws IllegalAccessException {
        replyDAO.deleteReply(replyNum);
    }

    /**
     * 부모 댓글 찾기
     * @param replyNum
     * @return
     */
    @Override
    public Reply findParentReply(Long replyNum) {
        return replyDAO.findParentReply(replyNum);
    }

    /**
     * 답글 작성성
    * @param reply
     * @return
     */
    @Override
    public Long writeReplyReply(Reply reply) {
        return replyDAO.writeReplyReply(reply);
    }
}
