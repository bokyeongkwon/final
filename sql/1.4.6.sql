--초기화를 위한 테이블 삭제
drop table RESULT;
drop table REPORT;
drop table UPLOAD_FILE;
drop table LIKELIST;
drop table REPLY;
drop table BOARD;
drop table CATEGORY;
drop table member;

--회원테이블
create table member (
    member_num   number(10),    --회원번호
    id       varchar2(40),      --아이디
    name      varchar2(40),     --이름
    pw    varchar2(15),         --비밀번호
    tel      varchar2(13),      --전화번호
    email       varchar2(40),   --이메일
    birth      varchar2(10),            --생년월일
    gender      char(3) default '여',    --성별(남,여)
    nickname      varchar2(40),         --별칭
    cdate      TIMESTAMP default systimestamp,  --생성일시
    udate      TIMESTAMP                        --변경일시
);

--기본키생성
alter table member add Constraint member_member_num_pk primary key (member_num);

--제약조건
alter table member modify id constraint member_id_uk unique;
alter table member modify email constraint member_email_uk unique;
alter table member modify nickname constraint member_nickname_uk unique;

alter table member modify id constraint member_id_nn not null;
alter table member modify name constraint member_name_nn not null;
alter table member modify pw constraint member_pw_nn not null;
alter table member modify tel constraint member_tel_nn not null;
alter table member modify email constraint member_email_nn not null;
alter table member modify birth constraint member_birth_nn not null;
alter table member modify gender constraint member_gender_nn not null;
alter table member modify cdate constraint member_cdate_nn not null;

alter table member add constraint member_gender_ck check (gender in ('남','여'));

--시퀀스
drop sequence member_member_num_seq;
create sequence member_member_num_seq
increment by 1
start with 1
minvalue 1
nocache;

--게시판 테이블
create table BOARD (
    board_num   number(10),             --게시판 게시글 번호
    cate_num       NUMBER(10),         --분류코드
    board_title      varchar2(150),     --게시글 제목
    member_num    NUMBER(10),           --회원번호
    nickname      varchar2(40),         --별칭
    board_date      TIMESTAMP default systimestamp, --작성일
    board_hit       NUMBER(5) default '0',          --조회수
    board_content      CLOB,                --게시글 내용
    from_recipe     varchar2(30),           --레시피 출처
    board_map_address      VARCHAR2(300),   --지도 API에서 받은 주소
    board_picture      BLOB                 --대표사진
);
--기본키생성
alter table BOARD add Constraint BOARD_board_num_pk primary key (board_num);

--제약조건
alter table BOARD modify board_title constraint BOARD_board_title_nn not null;
alter table BOARD modify nickname constraint BOARD_nickname_nn not null;
alter table BOARD modify board_date constraint BOARD_board_date_nn not null;
alter table BOARD modify board_hit constraint BOARD_board_hit_nn not null;
alter table BOARD modify board_content constraint BOARD_board_content_nn not null;
alter table BOARD modify from_recipe constraint BOARD_from_recipe_nn not null;
alter table BOARD modify board_picture constraint BOARD_board_picture_nn not null;


--시퀀스
drop sequence board_board_num_seq;
create sequence board_board_num_seq
increment by 1
start with 1
minvalue 1
nocache;

--댓글게시판 테이블
create table REPLY (
    reply_num   number(10),         --댓글번호
    board_num       number(10),     --게시글번호
    member_num      number(10),     --회원번호
    reply_date    TIMESTAMP default systimestamp,   --작성일
    reply_content      CLOB,        --댓글내용
    reply_group       number(5),    --댓글그룹
    reply_step      number(5),      --댓글의 단계
    reply_indent      number(5),    --댓글의 들여쓰기
    preply_num      number(10)      --부모댓글번호
);
--기본키생성
alter table REPLY add Constraint REPLY_reply_num_pk primary key (reply_num);

--제약조건
alter table REPLY modify reply_date constraint REPLY_reply_date_nn not null;
alter table REPLY modify reply_content constraint REPLY_reply_content_nn not null;
alter table REPLY modify reply_group constraint REPLY_reply_group_nn not null;
alter table REPLY modify reply_step constraint REPLY_reply_step_nn not null;
alter table REPLY modify reply_indent constraint REPLY_reply_indent_nn not null;

--시퀀스
drop sequence reply_reply_num_seq;
create sequence reply_reply_num_seq
increment by 1
start with 1
minvalue 1
nocache;

--관심리스트 테이블
create table LIKELIST (
    likelist_num   number(10),              --관심리스트 번호
    member_num       NUMBER(10),            --회원번호
    likelist_chk      char(10) default '동의',  --관심리스트 체크 여부 (동의,비동의)
    likelist_date    TIMESTAMP default systimestamp,    --찜한 날짜
    board_num      NUMBER(10),              --게시판 게시글 번호
    board_picture    BLOB,                  --대표사진
    board_title      VARCHAR2(150)          --게시글 제목
);
--기본키생성
alter table LIKELIST add Constraint LIKELIST_likelist_num_pk primary key (likelist_num);

--제약조건
alter table LIKELIST modify likelist_chk constraint LIKELIST_likelist_chk_nn not null;
alter table LIKELIST modify likelist_date constraint LIKELIST_likelist_date_nn not null;
alter table LIKELIST modify board_picture constraint LIKELIST_board_picture_nn not null;

alter table LIKELIST add constraint LIKELIST_likelist_chk_ck check (likelist_chk in ('동의','비동의'));

--시퀀스
drop sequence likelist_likelist_num_seq;
create sequence likelist_likelist_num_seq
increment by 1
start with 1
minvalue 1
nocache;

--게시판파일첨부 테이블
create table UPLOAD_FILE (
    file_num   number(10),              --파일아이디
    cate_num       NUMBER(10),         --분류코드
    board_num       number(10),         --게시글 번호
    file_date      TIMESTAMP default systimestamp,  --작성일
    store_file_name    VARCHAR2(150),   --서버보관 파일명
    upload_file_name    VARCHAR2(150),  --업로드 파일명
    file_size      NUMBER(30),          --파일크기
    file_type       VARCHAR2(100),      --파일유형
    file_data      BLOB                 --첨부파일
);
--기본키생성
alter table UPLOAD_FILE add Constraint UPLOAD_FILE_file_num_pk primary key (file_num);

--제약조건
alter table UPLOAD_FILE modify file_date constraint UPLOAD_FILE_file_date_nn not null;
alter table UPLOAD_FILE modify store_file_name constraint UPLOAD_FILE_store_file_name_nn not null;
alter table UPLOAD_FILE modify upload_file_name constraint UPLOAD_FILE_upload_file_name_nn not null;
alter table UPLOAD_FILE modify file_size constraint UPLOAD_FILE_file_size_nn not null;
alter table UPLOAD_FILE modify file_type constraint UPLOAD_FILE_file_type_nn not null;

--시퀀스
drop sequence upload_file_file_num_seq;
create sequence upload_file_file_num_seq
increment by 1
start with 1
minvalue 1
nocache;

--카테고리 테이블
create table CATEGORY (
    cate_num   number(10),      --분류번호
    cate_name  VARCHAR2(60),     --분류명
    pcate_num    number(10),       --부모 분류번호
    useyn       char(1) default 'Y',            --사용여부 (사용:'Y',미사용:'N')
    cdate       timestamp default systimestamp,         --생성일시
    udate       timestamp default systimestamp          --수정일시
);

--기본키생성
alter table CATEGORY add Constraint CATEGORY_cate_num_pk primary key (cate_num);

--제약조건
alter table CATEGORY modify cate_name constraint CATEGORY_cate_name_nn not null;
alter table CATEGORY modify useyn constraint CATEGORY_useyn_nn not null;

alter table CATEGORY add constraint CATEGORY_useyn_ck check(useyn in ('Y','N'));   --해당 분류의 현재 사용 여부.

--신고 테이블
create table REPORT (
    report_num   number(10),                --신고번호
    member_num       number(10),            --회원번호
    report_date      TIMESTAMP default systimestamp,    --신고일
    report_content    CLOB,                 --신고내용
    board_num      number(10),              --게시글 번호
    reply_num       number(10),             --댓글번호
    report_proceed   char(10) default '진행'    --신고 진행 사항  (진행,완료)
);

--기본키생성
alter table REPORT add Constraint REPORT_FILE_report_num_pk primary key (report_num);

--제약조건
alter table REPORT modify report_date constraint REPORT_report_date_nn not null;
alter table REPORT modify report_content constraint REPORT_report_content_nn not null;

--시퀀스
drop sequence report_report_num_seq;
create sequence report_report_num_seq
increment by 1
start with 1
minvalue 1
nocache;

--신고 결과 테이블
create table RESULT (
    report_num   number(10),            --신고번호
    result   char(10) default '진행',       --신고결과 (진행,완료)
    result_reason       CLOB,           --신고 결과 이유
    result_date      TIMESTAMP default systimestamp,    --회원번호
    member_num    number(10),           --회원번호
    report_date      TIMESTAMP default systimestamp,    --신고일
    board_num      number(10),          --게시판 게시글 번호
    reply_num       number(10)          --댓글번호
);

--기본키생성
alter table RESULT add Constraint RESULT_report_num_pk primary key (report_num);

--제약조건
alter table RESULT modify result_date constraint RESULT_result_date_nn not null;
alter table RESULT modify report_date constraint RESULT_report_date_nn not null;

alter table RESULT add constraint RESULT_result_ck check (result in ('진행','완료'));


--외래키 모음--
--게시판
alter table BOARD add Constraint BOARD_cate_num_fk foreign key (cate_num) REFERENCES CATEGORY(cate_num);
alter table BOARD add Constraint BOARD_member_num_fk foreign key (member_num) REFERENCES MEMBER(member_num);

--댓글게시판
alter table REPLY add Constraint REPLY_board_num_fk foreign key (board_num) REFERENCES BOARD(board_num);
alter table REPLY add Constraint REPLY_member_num_fk foreign key (member_num) REFERENCES MEMBER(member_num);
alter table REPLY add Constraint REPLY_preply_num_fk foreign key (preply_num) REFERENCES REPLY(reply_num);

--관심리스트
alter table LIKELIST add Constraint LIKELIST_member_num_fk foreign key (member_num) REFERENCES MEMBER(member_num);
alter table LIKELIST add Constraint LIKELIST_board_num_fk foreign key (board_num) REFERENCES BOARD(board_num);

--게시판파일첨부
alter table UPLOAD_FILE add Constraint UPLOAD_FILE_board_num_fk foreign key (board_num) REFERENCES BOARD(board_num);
alter table UPLOAD_FILE add Constraint UPLOAD_FILE_cate_num_fk foreign key (cate_num) REFERENCES CATEGORY(cate_num);

--카테고리
alter table CATEGORY add constraint CATEGORY_pcate_num_fk foreign key(pcate_num) references CATEGORY(cate_num);

--신고
alter table REPORT add Constraint REPORT_member_num_fk foreign key (member_num) REFERENCES MEMBER(member_num);
alter table REPORT add Constraint REPORT_board_num_fk foreign key (board_num) REFERENCES BOARD(board_num);
alter table REPORT add Constraint REPORT_reply_num_fk foreign key (reply_num) REFERENCES REPLY(reply_num);

--신고 결과
alter table RESULT add Constraint RESULT_report_num_fk foreign key (report_num) REFERENCES REPORT(report_num);
alter table RESULT add Constraint RESULT_member_num_fk foreign key (member_num) REFERENCES MEMBER(member_num);
alter table RESULT add Constraint RESULT_board_num_fk foreign key (board_num) REFERENCES BOARD(board_num);
alter table RESULT add Constraint RESULT_reply_num_fk foreign key (reply_num) REFERENCES REPLY(reply_num);

--------------------------------------------------------------------------------------------------------------
--샘플 데이터
--회원
INSERT into member (member_num,id,name,pw,tel,email,birth,nickname)
VALUES (1,'아이디1','이름1','비번1','635-252','이메일1@주소1','2000-05-03','닉네임1');

--카테고리 데이터
--첨부파일의 경우 테이블이름은 카테고리지만 일단 추가시킴
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (10,'분야별 레시피',null,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (11,'제과',10,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (12,'제빵',10,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (13,'음료',10,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (14,'노오븐 베이킹',10,'Y');

insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (20,'테마별 레시피',null,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (21,'발렌타인 데이',20,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (22,'할로윈',20,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (23,'빼빼로 데이',20,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (24,'크리스마스',20,'Y');

insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (30,'사진 팁',null,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (31,'구도/각도',30,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (32,'보정',30,'Y');

insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (40,'베이킹 클래스 찾기',null,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (41,'베이킹 클래스 찾기',40,'Y');

insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (50,'커뮤니티',null,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (51,'QnA',50,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (52,'자유 게시판',50,'Y');

insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (90,'첨부',null,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (91,'파일',90,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (92,'이미지',90,'Y');
insert into CATEGORY (cate_num,cate_name,pcate_num,useyn) values (93,'프로필',90,'Y');

commit;