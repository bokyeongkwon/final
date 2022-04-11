package com146.HOME.CA.BE.domain.report.svc;

import com146.HOME.CA.BE.domain.report.Report;
import com146.HOME.CA.BE.domain.report.dao.ReportDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ReportSVCImpl implements ReportSVC{

    private final ReportDAO reportDAO;

    /**
     * 게시물 신고
     * @param report
     * @return
     */
    @Override
    public Long reportBoard(Report report) {
        return reportDAO.reportBoard(report);
    }

    /**
     * 댓글 신고
     * @param report
     * @return
     */
    @Override
    public Long reportReply(Report report) {
        return reportDAO.reportReply(report);
    }

}
