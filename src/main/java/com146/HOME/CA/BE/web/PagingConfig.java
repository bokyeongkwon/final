package com146.HOME.CA.BE.web;

import com146.HOME.CA.BE.domain.common.paging.PageCriteria;
import com146.HOME.CA.BE.domain.common.paging.RecordCriteria;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PagingConfig {

//   베이킹 클래스, 커뮤니티 게시판(10, 10)
  private static final  int REC_COUNT_10_PER_PAGE = 10;
  private static final  int PAGE_COUNT_10_PER_PAGE = 10;
//  갤러리형  일반 게시판(9, 5)
  private static final  int REC_COUNT_9_PER_PAGE = 9;
  private static final  int PAGE_COUNT_5_PER_PAGE = 5;

  @Bean
  public RecordCriteria rc10(){
    return new RecordCriteria(REC_COUNT_10_PER_PAGE);
  }

  @Bean
  public PageCriteria pc10(){
    return new PageCriteria(rc10(), PAGE_COUNT_10_PER_PAGE);
  }

  @Bean
  public RecordCriteria rc9(){
    return new RecordCriteria(REC_COUNT_9_PER_PAGE);
  }

  @Bean
  public PageCriteria pc5(){
    return new PageCriteria(rc9(), PAGE_COUNT_5_PER_PAGE);
  }

}