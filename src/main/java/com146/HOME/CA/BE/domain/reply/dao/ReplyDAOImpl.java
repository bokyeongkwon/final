package com146.HOME.CA.BE.domain.reply.dao;

import com146.HOME.CA.BE.domain.reply.Reply;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ReplyDAOImpl implements ReplyDAO{

    private final JdbcTemplate jdbcTemplate;

    /**
     * 게시물에 댓글 불러오기
     * @param boardNum
     * @return
     */
    @Override
    public List<Reply> showReply(Long boardNum) {
        StringBuffer sql = new StringBuffer();
        sql.append("select ");
        sql.append("    r.reply_num, ");
        sql.append("    r.board_num, ");
        sql.append("    r.member_num, ");
        sql.append("    r.reply_date, ");
        sql.append("    r.reply_content, ");
        sql.append("    r.reply_group, ");
        sql.append("    r.preply_num, ");
        sql.append("    r.report_chk, ");
        sql.append("    m.nickname ");
        sql.append("    from reply r inner join member m ");
        sql.append("         on r.member_num = m.member_num ");
        sql.append("  where r.board_num = ? order by reply_date ASC ");

        List<Reply> replyList = jdbcTemplate.query(sql.toString(),
                new BeanPropertyRowMapper<>(Reply.class),
                boardNum);

        return replyList;
    }

    /**
     * 댓글 작성
     * @param reply
     * @return
     */
    @Override
    public Long writeReply(Reply reply) {
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO reply ( ");
        sql.append("  reply_num, ");				//댓글 고유 번호
        sql.append("  board_num, ");			//댓글이 작성된 게시글번호
        sql.append("  member_num, ");				//회원 아이디
        sql.append("  reply_date, ");		//회원 닉네임
        sql.append("  reply_content, ");			//댓글 내용
        sql.append("  reply_group) ");			//댓글그룹
        sql.append("	VALUES ( ");
        sql.append("  reply_reply_num_seq.nextval, ");
        sql.append("  ?, ");					//댓글이 작성된 게시물번호
        sql.append("  ?, ");					//회원 번호
        sql.append("  ?, ");					//작성일
        sql.append("  ?, ");					//댓글 내용
        sql.append("  reply_reply_num_seq.currval "); //댓글그룹
        sql.append(") ");

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(
                        sql.toString(),
                        new String[]{"reply_num"});

                pstmt.setLong(1, reply.getBoardNum());
                pstmt.setLong(2, reply.getMemberNum());
                pstmt.setDate(3, Date.valueOf(reply.getReplyDate()));
                pstmt.setString(4, reply.getReplyContent());

                return pstmt;
            }
        },keyHolder);

        return ((BigDecimal)keyHolder.getKeys().get("reply_num")).longValue();
    }

    /**
     * 댓글 수정
     * @param modifiedContent
     * @param replyNum
     * @param memberNum
     * @return
     *
     *
     */
    @Override
    public String modifyReply(String modifiedContent, Long replyNum, Long memberNum) throws IllegalAccessException {
        log.info(modifiedContent, replyNum, memberNum);
        StringBuffer sql = new StringBuffer();
        sql.append("update reply ");
        sql.append("    set reply_content = ?, ");
        sql.append("  where reply_num = ? and member_num = ?  ");

        int rows = jdbcTemplate.update(sql.toString(), modifiedContent, replyNum, memberNum);

        if(rows != 1){
            throw new IllegalAccessException(replyNum + "번 댓글을 찾을 수 없습니다.");
        }
        return modifiedContent;
    }

    /**
     * 댓글 삭제
     * @param replyNum
     */
    @Override
    public void deleteReply(Long replyNum) throws IllegalAccessException {
        StringBuffer sql = new StringBuffer();
        sql.append("delete from reply ");
        sql.append("  where reply_num = ? ");

        if(jdbcTemplate.update(sql.toString(), replyNum) != 1){
            throw new IllegalAccessException(replyNum + "번 댓글을 찾을 수 없습니다.");
        }

    }

    /**
     * 부모 댓글 블러오기
     * @param replyNum
     * @return
     */
    @Override
    public Reply findParentReply(Long replyNum) {
        StringBuffer sql = new StringBuffer();
        sql.append("select ");
        sql.append("    r.reply_num, ");
        sql.append("    r.board_num, ");
        sql.append("    r.member_num, ");
        sql.append("    r.reply_date, ");
        sql.append("    r.reply_content, ");
        sql.append("    r.reply_group, ");
        sql.append("    r.preply_num, ");
        sql.append("    r.report_chk, ");
        sql.append("    m.nickname ");
        sql.append("    from reply r inner join member m ");
        sql.append("         on r.member_num = m.member_num ");
        sql.append("  where r.reply_num = ? ");

        Reply reply = jdbcTemplate.queryForObject(
                sql.toString(),
                new BeanPropertyRowMapper<>(Reply.class),
                replyNum
        );
        return reply;
    }

    /**
     * 대댓글 작성
     * @param reply
     * @return
     */
    @Override
    public Long writeReplyReply(Reply reply) {
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO reply ( ");
        sql.append("  reply_num, ");				//댓글 고유 번호
        sql.append("  board_num, ");			  //댓글이 작성된 게시글번호
        sql.append("  member_num, ");				//회원번호
        sql.append("  reply_date, ");		    //작성일
        sql.append("  reply_content, ");		//댓글 내용
        sql.append("  preply_num, ");			  //부모댓글 번호
        sql.append("  reply_group) ");			//댓글그룹
        sql.append("	VALUES ( ");
        sql.append("  reply_reply_num_seq.nextval, ");
        sql.append("  ?, ");				//댓글이 작성된 게시글번호
        sql.append("  ?, ");				//회원번호
        sql.append("  ?, ");				//작성일
        sql.append("  ?, ");				//댓글 내용
        sql.append("  ?, ");				//부모댓글 번호
        sql.append("  ?, ");				//댓글그룹
        sql.append(") ");
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(
                        sql.toString(),
                        new String[] {"reply_num"});

                pstmt.setLong(1, reply.getBoardNum());
                pstmt.setLong(2, reply.getMemberNum());
                pstmt.setDate(3, Date.valueOf(reply.getReplyDate()));
                pstmt.setString(4, reply.getReplyContent());
                pstmt.setLong(5, reply.getPreplyNum());
                pstmt.setLong(6, reply.getReplyGroup());

                return pstmt;
            }
        }, keyHolder);

        return  ((BigDecimal)keyHolder.getKeys().get("reply_num")).longValue();
    }
}
