package com146.HOME.CA.BE.domain.mypage.DAO;

import com146.HOME.CA.BE.domain.mypage.DTO.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MyPageDAOImpl implements MyPageDAO{

    private final JdbcTemplate jdbcTemplate;

    /**
     *  구독 / 알림 목록
     */
    @Override
    public List<Subscribe> subscribeList() {
        StringBuffer sql = new StringBuffer();

        sql.append("select ");
        sql.append("    s.sub_member, ");
        sql.append("    b.board_num, ");
        sql.append("    s.sub_chk, ");
        sql.append("    b.board_title, ");
        sql.append("    m.nickname ");
        sql.append("  from subscribe s inner join member m ");
        sql.append("    on s.member_num = m.member_num ");
        sql.append("                   inner join board b ");
        sql.append("    on m.member_num = b.member_num ");
        sql.append(" where m.member_num = ? ");
        sql.append(" order by s.sub_num desc ");

        List<Subscribe> list = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Subscribe.class));


        return list;
    }

    /**
     *  알림 설정
     */
    @Override
    public int setAlarm(int alarm) {
        StringBuffer sql = new StringBuffer();

        sql.append("update subscribe ");
        sql.append("    set alarm_chk = ? ");
        sql.append("  where sub_member_num = ? ");
        sql.append("       and board_num = ? ");

        int cnt = jdbcTemplate.update(sql.toString(), alarm);

        return cnt;
    }

    /**
     *  구독 취소
     */
    @Override
    public int deleteSubscribe(long subNum) {
        StringBuffer sql = new StringBuffer();

        sql.append("delete from subscribe ");
        sql.append("    set sub_chk = ? ");
        sql.append("  where sub_member_num = ? ");
        sql.append("       and board_num = ? ");

        int cnt = jdbcTemplate.update(sql.toString(), subNum);

        return cnt;
    }

    /**
     *  관심리스트 목록
     */
    @Override
    public List<Like> likeList() {
        StringBuffer sql = new StringBuffer();

        sql.append("select ");
        sql.append("    l.likelist_num, ");
        sql.append("    b.board_picture, ");
        sql.append("    m.nickname, ");
        sql.append("    b.board_date, ");
        sql.append("    l.likelist_chk, ");
        sql.append("    b.board_title ");
        sql.append("  from likelist l inner member m ");
        sql.append("    on l.member_num = m.member_num ");
        sql.append("                   inner join board b ");
        sql.append("    on m.member_num = b.member_num ");
        sql.append(" where m.member_num = ? ");
        sql.append(" order by l.likelist_num desc ");

        List<Like> list = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Like.class));


        return list;
    }

    /**
     *  관심리스트 삭제
     */
    @Override
    public int deleteLike(long likeNum) {
        StringBuffer sql = new StringBuffer();

        sql.append("delete from likelist ");
        sql.append("  where likelist_num = ? ");


        int cnt = jdbcTemplate.update(sql.toString(), likeNum);

        return cnt;

    }

    /**
     * 내가 작성한 게시물 목록
     * @return
     */
    @Override
    public List<MyBoard> myBoardList() {
        StringBuffer sql = new StringBuffer();

        sql.append("select ");
        sql.append("    b.board_title, ");
        sql.append("    m.member_nickname, ");
        sql.append("    b.board_date, ");
        sql.append("    b.board_hit, ");
        sql.append("    b.board_picture, ");
        sql.append("    l.likelist_chk ");
        sql.append("  from board b inner join member m ");
        sql.append("    on b.member_num = m.member_num ");
        sql.append("               inner join likelist l ");
        sql.append("    on m.member_num = l.member_num ");
        sql.append("  where m.member_id = ? ");

        List<MyBoard> list = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(MyBoard.class));


        return list;
    }

    /**
     * 내가 작성한 게시물 삭제
     * @param memberNum
     * @return
     */
    @Override
    public int deleteMyBoard(long memberNum) {
        StringBuffer sql = new StringBuffer();

        sql.append("delete from board ");
        sql.append("  where member_num = ? ");
        sql.append("  and board_num = ? ");


        int cnt = jdbcTemplate.update(sql.toString(), memberNum);

        return cnt;
    }

    /**
     *  내가 작성한 댓글 목록
     */
    @Override
    public List<MyReply> myReplyList() {
        StringBuffer sql = new StringBuffer();

        sql.append("select ");
        sql.append("    r.reply_num, ");
        sql.append("    r.board_num, ");
        sql.append("    r.reply_date, ");
        sql.append("    r.reply_content, ");
        sql.append("    b.board_title ");
        sql.append("  from board b inner join reply r ");
        sql.append("    on b.member_num = r.member_num ");
        sql.append("  where r.member_id = ? ");

        List<MyReply> list = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(MyReply.class));


        return list;
    }

    /**
     * 내가 작성한 댓글 삭제
     * @param memberNum
     * @return
     */
    @Override
    public int deleteMyReply(long memberNum) {
        StringBuffer sql = new StringBuffer();

        sql.append("delete from reply ");
        sql.append("  where member_num = ? ");
        sql.append("  and board_num = ? ");
        sql.append("  and reply_num = ? ");


        int cnt = jdbcTemplate.update(sql.toString(), memberNum);

        return cnt;
    }

    /**
     *  내가 신고한 게시물 목록
     */
    @Override
    public List<MyBoardReport> boardReportList() {
        StringBuffer sql = new StringBuffer();

        sql.append("select ");
        sql.append("    p.report_num, ");
        sql.append("    p.report_date, ");
        sql.append("    b.board_title, ");
        sql.append("    p.report_proceed, ");
        sql.append("    p.report_content, ");
        sql.append("    t.result, ");
        sql.append("    t.result_reason ");
        sql.append("  from board b inner report p ");
        sql.append("    on b.member_num = p.member_num ");
        sql.append("               inner result t ");
        sql.append("    on p.report_num = t.report_num ");
        sql.append("  where p.member_id = ? ");

        List<MyBoardReport> list = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(MyBoardReport.class));


        return list;
    }

    /**
     *  내가 신고한 댓글 목록
     */
    @Override
    public List<MyReplyReport> replyReportList() {
        StringBuffer sql = new StringBuffer();

        sql.append("select ");
        sql.append("    p.report_num, ");
        sql.append("    p.report_date, ");
        sql.append("    r.reply_content, ");
        sql.append("    p.report_proceed, ");
        sql.append("    p.report_content, ");
        sql.append("    t.result, ");
        sql.append("    t.result_reason ");
        sql.append("  from reply r inner report p ");
        sql.append("    on r.member_num = p.member_num ");
        sql.append("               inner result t ");
        sql.append("    on p.report_num = t.report_num ");
        sql.append("  where p.member_id = ? ");

        List<MyReplyReport> list = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(MyReplyReport.class));


        return list;
    }
}
