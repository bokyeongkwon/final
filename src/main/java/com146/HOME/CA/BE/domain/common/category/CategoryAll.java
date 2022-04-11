package com146.HOME.CA.BE.domain.common.category;

import lombok.Data;

@Data
public class CategoryAll {
  private int pcateNum;              //상위 카테고리 넘버 NUMBER(10,0) ex) 10, 20, 30, 40...
  private String pcateName;          //상위 카테고리명 VARCHAR2(60 BYTE)

  private int ccateNum;              //하위 카테고리 넘버 NUMBER(10,0) ex)11, 12, 13, 14...
  private String ccateName;          //하위 카테고리명 VARCHAR2(60 BYTE)
}
