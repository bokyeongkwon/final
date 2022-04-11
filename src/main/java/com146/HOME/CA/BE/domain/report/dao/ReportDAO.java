package com146.HOME.CA.BE.domain.report.dao;

import com146.HOME.CA.BE.domain.report.Report;

public interface ReportDAO {
    //게시물 신고
    Long reportBoard(Report report);

    //댓글 신고
    Long reportReply(Report report);
}
