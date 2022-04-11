package com146.HOME.CA.BE.domain.report.dao;

import com146.HOME.CA.BE.domain.report.Report;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ReportDAOImpl implements ReportDAO{

    JdbcTemplate jdbcTemplate;

    /**
     * 게시물 신고
     * @param report
     * @return
     */
    @Override
    public Long reportBoard(Report report) {
        StringBuffer sql = new StringBuffer();
        sql.append(" INSERT INTO report ( ");
        sql.append("     report_num, ");
        sql.append("     member_num, ");
        sql.append("     report_date, ");
        sql.append("     report_content, ");
        sql.append("     board_num, ");
        sql.append("     report_proceed ");
        sql.append(" ) VALUES ( ");
        sql.append("     report_report_num_SEQ.nextval, ");
        sql.append("     ?, ");
        sql.append("     ?, ");
        sql.append("     ?, ");
        sql.append("     ?, ");
        sql.append("     ? ) ");

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(sql.toString(), new String[]{"report_num"});
                pstmt.setLong(1, report.getMemberNum());
                pstmt.setDate(2, Date.valueOf(report.getReportDate()));
                pstmt.setString(3, report.getReportContent());
                pstmt.setLong(4, report.getBoardNum());
                pstmt.setInt(5, report.getReportProceed());

                return pstmt;
            }
        }, keyHolder);

//    신고 번호를 반환.
        return Long.valueOf(keyHolder.getKeys().get("report_num").toString());
    }



    /**
     * 댓글 신고
     * @param report
     * @return
     */
    @Override
    public Long reportReply(Report report) {
        StringBuffer sql = new StringBuffer();
        sql.append(" INSERT INTO report ( ");
        sql.append("     report_num, ");
        sql.append("     member_num, ");
        sql.append("     report_date, ");
        sql.append("     report_content, ");
        sql.append("     reply_num, ");
        sql.append("     report_proceed ");
        sql.append(" ) VALUES ( ");
        sql.append("     report_report_num_SEQ.nextval, ");
        sql.append("     ?, ");
        sql.append("     ?, ");
        sql.append("     ?, ");
        sql.append("     ?, ");
        sql.append("     ? ) ");

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(sql.toString(), new String[]{"report_num"});
                pstmt.setLong(1, report.getMemberNum());
                pstmt.setDate(2, Date.valueOf(report.getReportDate()));
                pstmt.setString(3, report.getReportContent());
                pstmt.setLong(4, report.getReplyNum());
                pstmt.setInt(5, report.getReportProceed());

                return pstmt;
            }
        }, keyHolder);

//    신고 번호를 반환.
        return Long.valueOf(keyHolder.getKeys().get("report_num").toString());
    }
}
