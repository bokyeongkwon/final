package com146.HOME.CA.BE.domain.common.paging;

/**
 * 한페이지에 보여줄 레코드 계산
 */
public class RecordCriteria {
  private Integer reqPage = 1;							//요청페이지
  private final int REC_COUNT_PER_PAGE; //한페이지에 보여줄 레코드수
  private int startRec;									//한페이지에 보여줄 시작레코드
  private int endRec;										//한페이지에 보여줄 종료레코드

  public RecordCriteria(int REC_COUNT_PER_PAGE) {
    this.REC_COUNT_PER_PAGE = REC_COUNT_PER_PAGE;
  }
  /**
   * 시작레코드
   * (요청페이지-1)*한페이지에보여줄레코드수+1
   * @return 시작 레코드 번호
   */
  public int getStartRec() {
    return this.startRec;
  }
  /**
   * 종료레코드
   * 한페이지에 보여줄 레코드수 * 요청페이지
   * @return 종료레코드
   */
  public int getEndRec() {
    return this.endRec;
  }

  public int getReqPage() {
    return reqPage;
  }

  /**
   * 요청페이지를 입력받아 시작레코드 종료레코드를 구한다.
   * @param reqPage
   */
  public void setReqPage(int reqPage) {
    this.reqPage = reqPage;
    this.startRec = (reqPage - 1) * REC_COUNT_PER_PAGE + 1;
    this.endRec = REC_COUNT_PER_PAGE * reqPage;
  }

  public int getREC_COUNT_PER_PAGE() {
    return REC_COUNT_PER_PAGE;
  }

}
