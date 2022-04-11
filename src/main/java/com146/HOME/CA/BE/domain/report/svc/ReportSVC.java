package com146.HOME.CA.BE.domain.report.svc;

import com146.HOME.CA.BE.domain.report.Report;

public interface ReportSVC {

    //게시물 신고
    Long reportBoard(Report report);

    //댓글 신고
    Long reportReply(Report report);
}
