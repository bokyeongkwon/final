package com146.HOME.CA.BE.web.form.board;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class EditForm {

    private Long boardNum;
    private int cateNum;	            //NUMBER(10) --분류코드
    private String boardTitle;	        //VARCHAR2(150) --게시글 제목
    private Long memberNum;	        //NUMBER(10) --회원번호
    private String nickname;            //varchar2(40) --별칭
    private String boardContent;	    //CLOB --게시글 내용
    private String fromRecipe;          //varchar2(30) --레시피 출처
    private String boardMapAddress;	//VARCHAR2(300) --지도 API에서 받은 주소
    private byte[] boardPicture;         //BLOB --대표사진

    private List<MultipartFile> files;  // 첨부파일
    private int hit;              //  조회수

}
