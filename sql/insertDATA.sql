
-- 회원, 게시글 삭제하고 넣기
-- from recipe VARCHAR2(50)으로 변경할 것


--===================================member 넣기===========================================================================
INSERT into member (member_num,id,name,pw,tel,email,birth,gender,nickname,cdate,udate)
VALUES (1,'shell','김소라','1234','01022222222','shell@1.com','2000-05-03','여','소라',systimestamp,systimestamp);

INSERT into member (member_num,id,name,pw,tel,email,birth,gender,nickname,cdate,udate)
VALUES (2,'spring','이한봄','1234','01033333333','spring@1.com','2000-06-03','여','봄',systimestamp,systimestamp);

INSERT into member (member_num,id,name,pw,tel,email,birth,gender,nickname,cdate,udate)
VALUES (3,'Jaeyeop','김재엽','1234','01055555555','Jaeyeop@1.com','2000-05-03','남','Jaeyeop',systimestamp,systimestamp);

INSERT into member (member_num,id,name,pw,tel,email,birth,gender,nickname,cdate,udate)
VALUES (4,'hatae','하태우','1234','01041487939','793986@naver.com','1994-11-24','남','하태우',systimestamp,systimestamp);

INSERT into member (member_num,id,name,pw,tel,email,birth,gender,nickname,cdate,udate)
VALUES (5,'bokyeong','권보경','1234','01066666666','bokyeong@1.com','2000-05-03','여','bokyeong',systimestamp,systimestamp);

INSERT into member (member_num,id,name,pw,tel,email,birth,gender,nickname,cdate,udate)
VALUES (6,'SSoooda','배지희','1234','01077777777','SSoooda@1.com','2000-05-03','여','SSoooda',systimestamp,systimestamp);
--===================================member 넣기 끝===========================================================================


--===================================board 넣기 6개씩(제과 11)==========================================================================
INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 11, '(제과) 촉촉한 초코칩쿠키 만들기', 1, '소라', systimestamp, DEFAULT, '(제과) 딱딱한건 싫으니 촉촉한 초코칩 쿠키를 만들어 보아요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 11, '(제과) 크림 디저트 딸기 푸드', 2, '봄', systimestamp, DEFAULT, '(제과) 달달한 크림이 들어간 케이크 만들기.', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ed%81%ac%eb%a6%bc-%eb%94%94%ec%a0%80%ed%8a%b8-%eb%94%b8%ea%b8%b0-%ed%91%b8%eb%93%9c-3177906/
INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 11, '(제과) 당이 필요할때 당 폭발 흰가루 마약쿠키 만들기', 3, 'Jaeyeop', systimestamp, DEFAULT, '(제과) 기분전환 하기 좋은 달달한 쿠키를 만들어 봅시다', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%bf%a0%ed%82%a4-%eb%b9%b5-%ea%b5%bd%ea%b8%b0-%ed%8c%a8%ec%8a%a4%ed%8a%b8%eb%a6%ac-756601/
INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 11, '(제과) 단단한 바게트빵 만들기', 4, '하태우', systimestamp, DEFAULT, '(제과) 싫어 하는 그사람에게 빵이라고 만든 벽돌을 주면서 치아를 박살내 보아요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%eb%b0%94%ea%b2%8c%ed%8a%b8-%eb%b9%b5-%ec%a0%9c%ea%b3%bc%ec%a0%90-%ec%8b%9d%eb%b9%b5-678113/
INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 11, '(제과) 초코 블루베리 케이크 만들기', 5, 'bokyeong', systimestamp, DEFAULT, '(제과) 초코 듬뿍,', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%b9%98%ec%a6%88-%ec%bc%80%ec%9e%8c-%eb%af%b8%ea%b5%ad-%ec%82%ac%eb%9e%8c-%eb%b9%8c%eb%b2%a0%eb%a6%ac-1559403/
INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 11, '(제과) 디저트 초콜릿 만들기', 6, 'SSoooda', systimestamp, DEFAULT, '(제과) 집에서 간단하게 만드는 디저트 초콜릿', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%b4%88%ec%bd%94-%ec%bc%80%ec%9d%b4%ed%81%ac-penam-4628281/
--===================================board 넣기 6개씩 (제빵 12)==========================================================================

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 12, '(제빵) 슈크림빵 만들기', 1, '소라', systimestamp, DEFAULT, '(제빵) 딱딱한건 싫으니 촉촉한 초코칩 쿠키를 만들어 보아요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%8a%88%ed%81%ac%eb%a6%bc-%eb%a7%9b%ec%9e%88%eb%8a%94-%ed%94%84%eb%9e%91%ec%8a%a4-%ea%b3%bc%ec%9e%90-427181/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 12, '(제빵) 머랭 케이크 만들기', 2, '봄', systimestamp, DEFAULT, '(제빵) 제과점에서 사먹는것 보다 훨씬 맛있는 모카빵을 만들어 보겠습니다.', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%eb%a8%b8%eb%9e%ad-%ec%bc%80%ec%9d%b4%ed%81%ac-4866598/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 12, '(제빵) 당이 필요할때 당 폭발 흰가루 마약쿠키 만들기', 3, 'Jaeyeop', systimestamp, DEFAULT, '(제빵) 기분전환 하기 좋은 달달한 쿠키를 만들어 봅시다', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%eb%94%94%ec%a0%80%ed%8a%b8-%eb%a7%88%ec%b9%b4%eb%a1%b1-%eb%94%b8%ea%b8%b0-%ec%8b%9d%eb%8b%b9-3398645/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 12, '(제빵) 시나몬 롤 시나몬 빵 만들기', 4, '하태우', systimestamp, DEFAULT, '(제빵) 계피 좋아하세요? 그럼 시나몬은요??', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%8b%9c%eb%82%98%eb%aa%ac-%eb%a1%a4-%ec%8b%9c%eb%82%98%eb%aa%ac-%eb%b9%b5-4719023/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 12, '(제빵) 크로아상 만들기', 5, 'bokyeong', systimestamp, DEFAULT, '(제빵)크로플로도 만들 수 있는 다재다능한 크로와상 만들기!', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%eb%b9%b5-%ed%81%ac%eb%a3%a8%ec%95%84%ec%83%81-%ec%9d%8c%ec%8b%9d-%eb%b9%b5%ec%a7%91-4077812/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 12, '(제빵) 머핀 케이크 만들기', 6, 'SSoooda', systimestamp, DEFAULT, '(제빵) 머핀으로 케이크를 만들어 봅시다', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%eb%a8%b8%ed%95%80-%ec%bc%80%ec%9d%b4%ed%81%ac-%ed%83%80%eb%a5%b4%ed%8a%b8-%eb%94%94%ec%a0%80%ed%8a%b8-3510308/

--===================================board 넣기 6개씩 (음료 13)==========================================================================

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 13, '(음료) 라떼는 말이야! 라떼만들기', 1, '소라', systimestamp, 1000, '(음료) 따뜻하고 부드러운 라떼 만드는 방법 알려드립니다.', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%bb%a4%ed%94%bc-%ed%8e%9c-%ea%b3%b5%ec%b1%85-%ec%98%a4%ed%94%88-%eb%85%b8%ed%8a%b8-2306471/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 13, '(음료) 아이스 아메리카노 만들기', 2, '봄', systimestamp, 900, '(음료) 얼죽아 라는 말이 괜히 생긴게 아니죠 아메리카노 만들기.', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%bb%a4%ed%94%bc-%ec%95%84%eb%a9%94%eb%a6%ac%ec%b9%b4%eb%85%b8-%ec%bb%a4%ed%94%bc%ec%9e%94-5386871/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 13, '(음료) 따뜻한 홍차 한잔 하실래요?', 3, 'Jaeyeop', systimestamp, 750, '(음료) 마음을 편안하게 만들어주는 홍차를 만들어서 먹어 봅시다.', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%b0%a8%eb%a5%bc-%eb%81%93%ec%9d%b4%eb%8b%a4-%ed%99%8d%ec%b0%a8-%ec%9c%a0%eb%a6%ac%eb%b3%91-557448/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 13, '(음료) 새콤달콤 레몬에이드 만들기', 4, '하태우', systimestamp, 680, '(음료) 날로 먹는 레몬에이드를 만들어 봅시다', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%eb%a0%88%eb%aa%ac-%ec%97%90%ec%9d%b4%eb%93%9c-%ec%96%bc%ec%9d%8c-%eb%a0%88%eb%aa%ac-7014122/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 13, '(음료) 누가 요즘 그냥 레몬에이드를 먹습니까?? 핑크 레몬에이드 만들기', 5, 'bokyeong', systimestamp, 500, '(음료)흔하디 흔한 레몬에이드 말고 핑크 레몬에이드를 만들어 먹어봅시다', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ed%95%91%ed%81%ac-%eb%a0%88%eb%aa%a8%eb%84%a4%ec%9d%b4%eb%93%9c-%ec%97%ac%eb%a6%84-%ec%98%a5%ec%99%b8-795029/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 13, '(음료) 카테일 우우 만들기 ', 6, 'SSoooda', systimestamp, 150, '(음료) 술은 음료가 아닌것 같다구요? 이렇게나 맛있는데? 레몬을 곁들인 우우 칵테일 만들기!', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%88%a0-%ec%9d%8c%eb%a3%8c-%ec%b9%b5%ed%85%8c%ec%9d%bc-%ec%b6%94%ec%9a%b4-1853327/

--===================================board 넣기 6개씩 (노오븐 베이킹 14)==========================================================================

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 14, '(노오븐 베이킹) 티라미수 만들기', 1, '소라', systimestamp, 9999, '(노오븐 베이킹) 부드럽고 이쁜 티라미수를 오븐없이 만들어 볼게요 ', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%eb%94%94%ec%a0%80%ed%8a%b8-%ec%bc%80%ec%9d%b4%ed%81%ac-%ed%8b%b0%eb%9d%bc%eb%af%b8%ec%88%98-%ed%8c%8c%ec%9d%b4-932884/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 14, '(노오븐 베이킹) 카스테라 만들기', 2, '봄', systimestamp, 8888, '(노오븐 베이킹) 오븐없이 도 만들 수 있는 카스테라 만들기', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%b9%b4%ec%8a%a4%ed%85%8c%eb%9d%bc-%ec%8a%a4%ec%9c%84%ed%8a%b8-%eb%a3%b8-%eb%8b%ac%ec%bd%a4%ed%95%9c-389071/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 14, '(노오븐 베이킹) 노오븐 쿠키 만들기', 3, 'Jaeyeop', systimestamp, 7777, '(노오븐 베이킹) 간단하면서 맛도 좋은 쿠키를 만들어 봅시다', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%bf%a0%ed%82%a4-%ea%b7%b8%eb%a6%87-%ed%81%ac%eb%a6%ac%ec%8a%a4%eb%a7%88%ec%8a%a4-%ec%bf%a0%ed%82%a4-5809181/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 14, '(노오븐 베이킹) 알록달록 도넛 오븐없이 간단하게 만들기', 4, '하태우', systimestamp, 6666, '(노오븐 베이킹) 삐야삐야 깐따삐야~ 아 이게 아니라구요? 도넛 만들기!', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%eb%8f%84%eb%84%9b-%ec%9e%ac%eb%af%b8%ec%9e%88%eb%8a%94-%ec%84%a4%ed%83%95-%ec%9d%8c%ec%8b%9d-179248/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 14, '(노오븐 베이킹) 노오븐이 이것도 된다구? 찹쌀떡 만들기', 5, 'bokyeong', systimestamp, 5555, '(노오븐 베이킹)쫀득쫀득! 맛있는 앙금이 가득한 찹쌀떡 만들기', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%eb%96%a1-%ec%b0%b9%ec%8c%80-%ec%b0%b9%ec%8c%80%eb%96%a1-%eb%94%b8%ea%b8%b0%eb%96%a1-4769452/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 14, '(노오븐 베이킹) 브라우니 만들기', 6, 'SSoooda', systimestamp, 3333, '(노오븐 베이킹) 겉바속촉?? 원하는대로 만드는 브라우니 만들기', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%b4%88%ec%bd%9c%eb%a6%bf-%eb%b8%8c%eb%9d%bc%ec%9a%b0%eb%8b%88-%eb%b8%8c%eb%9d%bc-%ec%9a%b0-%eb%8b%88-668624/

--===================================board 넣기 6개씩 (발렌타인데이 21)==========================================================================

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 21, '(발렌타인데이) 초콜릿 케이크 만들어주기', 1, '소라', systimestamp, 9888, '(발렌타인데이) 남자친구에게 평범한 초콜릿 보단 케이크는 어떤가요?', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%bc%80%ec%9d%b4%ed%81%ac-%ec%b4%88%ec%bd%9c%eb%a6%bf-%ec%b4%88%ec%bd%9c%eb%a6%bf-%ec%bc%80%ec%9d%b4%ed%81%ac-1850011/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 21, '(발렌타인데이) 코코아 초콜릿 만들기', 2, '봄', systimestamp, 8777, '(발렌타인데이) 상대방이 코코아를 좋아하는지 물어보는건 필수!.', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ed%8a%b8%eb%9f%ac%ed%94%8c-%ec%bd%94%ec%bd%94%ec%95%84-%ec%b4%88%ec%bd%9c%eb%a6%bf-%eb%a7%9b%ec%9e%88%eb%8a%94-6636081/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 21, '(발렌타인데이) 롤리 초콜릿 만들기', 3, 'Jaeyeop', systimestamp, 7666, '(발렌타인데이) 롤리폴리 노래를 부르며 롤리 초콜릿 만들기', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%bc%80%ec%9d%b4%ed%81%ac-%ed%8c%9d-%ed%8c%a8%ec%8a%a4%ed%8a%b8%eb%a6%ac-%ec%9d%8c%ec%8b%9d-693645/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 21, '(발렌타인데이) 안생겨요. 못받아요. 스스로에게 선물하는 다크 초콜릿', 4, '하태우', systimestamp, 6555, '(발렌타인데이) 당신의 마음을 표현할(난 아님) 씁쓸한 다크 초콜릿 만들깈ㅋㅋㅋ', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%b4%88%ec%bd%9c%eb%a6%bf-%eb%b0%94-%eb%8b%a4%ed%81%ac-%ec%b4%88%ec%bd%9c%eb%a6%bf-183543/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 21, '(발렌타인데이) 핫 초코도 초코 잖아?? 핫초코 만들기', 5, 'bokyeong', systimestamp, 5444, '(발렌타인데이) 꾸덕하고 머리끝까지 찡해지는 너무 달달한 핫초코 만들기', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ed%95%ab-%ec%b4%88%ec%bd%9c%eb%a6%bf-%ec%bd%94%ec%bd%94%ec%95%84-%ec%bf%a0%ed%82%a4-1782623/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 21, '(발렌타인데이) 남자친구에게 전해줄 정성스런 초콜릿 만들기', 6, 'SSoooda', systimestamp, 4333, '(발렌타인데이) 예쁘게 만드는 팁과 포장 방법 까지 초콜릿 만들기 팁 대량방출', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%b4%88%ec%bd%9c%eb%a6%bf-%ec%9d%8c%ec%8b%9d-%ea%b3%bc%ec%9e%90-%ec%b9%bc%eb%a1%9c%eb%a6%ac-491165/

--===================================board 넣기 6개씩 (할로윈 22)==========================================================================

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 22, '(할로윈) 할로윈엔 호박이지 호박쿠키 만들기', 1, '소라', systimestamp, 4567, '(할로윈) 호박쿠키를 만들어서 먹어볼까요?', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ed%98%b8%eb%b0%95-%ed%95%a0%eb%a1%9c%ec%9c%88-%ec%bf%a0%ed%82%a4-%ed%8c%a8%ec%8a%a4%ed%8a%b8%eb%a6%ac-5700591/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 22, '(할로윈) 박쥐쿠키 만들기', 2, '봄', systimestamp, 3456, '(할로윈) 무서운건지 귀여운건지 모르겠지만 어쨋듯 박쥐쿠기 만들기!', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ed%95%a0%eb%a1%9c%ec%9c%88-%ec%bf%a0%ed%82%a4-%eb%b0%95%ec%a5%90-%ec%ba%90%eb%82%98%eb%8b%a4-1752121/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 22, '(할로윈) 너도 쿠키? 나도 쿠키 할로윈 쿠키 만들기', 3, 'Jaeyeop', systimestamp, 2345, '(할로윈) 쿠키전문가 가 되고 있는것 같지만 할로윈 쿠키 만들기 유령 호박 거미 !!', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ed%95%a0%eb%a1%9c%ec%9c%88-%ed%95%a0%eb%a1%9c%ec%9c%88-%ec%bf%a0%ed%82%a4-%ec%bf%a0%ed%82%a4-6755637/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 22, '(할로윈) 코로나 에도 집에서 할로윈 즐기기', 4, '하태우', systimestamp, 1234, '(할로윈) 이런날은 거미도 하나씩 집어 먹고 해봐야겠죠??', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ea%b5%ac%ec%9a%b4-%ea%b2%83-%ea%b2%80%ec%9d%80-%ec%83%89-%ec%bc%80%ec%9d%b4%ed%81%ac-21777/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 22, '(할로윈) 무섭고도 달달한 할로윈 디저트 만들기', 5, 'bokyeong', systimestamp, 543, '(할로윈)귀여운 호박케잌과 무시무시한 유령 케잌 을 만들어 볼꺼에요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%eb%8b%ac%ec%bd%a4%ed%95%9c-%ec%9d%8c%ec%8b%9d-%ed%95%a0%eb%a1%9c%ec%9c%88-%eb%94%94%ec%a0%80%ed%8a%b8-316374/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 22, '(할로윈) 할로윈에도 혼자인 당신을 위한 달달한 할로윈 초콜릿', 6, 'SSoooda', systimestamp, 21, '(할로윈) 쓸쓸한 마음 달달한 초콜릿으로 달래보아요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ea%b0%80%ec%9d%84-%eb%b8%8c%eb%9d%bc%ec%9a%b4-%ec%82%ac%ed%83%95-%ec%b4%88%ec%bd%9c%eb%a6%bf-20416/

--===================================board 넣기 6개씩 (빼빼로 데이 23)==========================================================================

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 23, '(빼빼로 데이) 빼빼로데이 이쁘게 빼빼로 만드는 방법', 1, '소라', systimestamp, 9800, '(빼빼로 데이) 빼빼로 만드는 재료 꿀팁 알려드릴게요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 23, '(빼빼로 데이) 아몬드 빼빼로 만들기', 2, '봄', systimestamp, 8700, '(빼빼로 데이) 가장 맛있는 빼빼로 아몬드 빼빼로를 직접 만들어 보겠습니다', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 23, '(빼빼로 데이) 아직도 기본 빼빼로만? 알록달록 빼빼로 만들기', 3, 'Jaeyeop', systimestamp, 7600, '(빼빼로 데이) 여러가지 종류의 빼빼로를 다양하게 만드는 방법을 알려 드릴게요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 23, '(빼빼로 데이)고백하기 좋은 빼빼로 만들기 ', 4, '하태우', systimestamp, 6500, '(빼빼로 데이) 이글을 보는 당신을 위로하며 정성을 다해 빼빼로를 만들어 볼까요?? ', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 23, '(빼빼로 데이) 빼빼로 데이? 가래떡 데이', 5, 'bokyeong', systimestamp, 5400, '(빼빼로 데이) 농업인의 날 우리것이 좋은것 아니겠습니까 가래떡을 먹어봅시다!', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 23, '(빼빼로 데이) 화이트쿠키 빼빼로 만들기', 6, 'SSoooda', systimestamp, 4500, '(빼빼로 데이) 오레오 좋아하시나요?? 오레오맛이 나는 빼빼로를 만들어 볼게요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

--===================================board 넣기 6개씩 (크리스마스 24)==========================================================================

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 12, '(크리스마스)크리스마스 쿠키 만들기 ', 1, '소라', systimestamp, 9167, '(크리스마스) 맛있고 이쁜 크리스마스 쿠키를 만들어요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%bf%a0%ed%82%a4-%ea%b3%bc%ec%9e%90-%ec%b7%a8%ea%b8%89-5773812/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 12, '(크리스마스) 크리스마스를 기념해서 과자집 만들기!', 2, '봄', systimestamp, 8634, '(크리스마스) 동화에서 나올것 같은 과자집을 만들어 볼게요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%a7%84%ec%a0%80-%ed%95%98%ec%9a%b0%ec%8a%a4-%eb%b0%94%ec%82%ad%ed%95%9c-%ec%a7%91-%ec%a7%84%eb%af%b8-1098731/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 12, '(크리스마스)작고 귀여운 딸기 케이크 만들기 ', 3, 'Jaeyeop', systimestamp, 7919, '(크리스마스) 크리스마스를 아기자기하게 꾸며줄 달콤한 케이크 만들기', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%eb%b2%a0%ec%9d%b4%ec%bb%a4%eb%a6%ac-%ec%9e%a5%ec%8b%9d-%eb%94%b8%ea%b8%b0-%eb%8b%ac%ec%bd%a4%ed%95%9c-4077811/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 12, '(크리스마스) 산타할아버지 드릴 쿠키와 우유 준비하기', 4, '하태우', systimestamp, 6248, '(크리스마스) 산타할아버지는 계시잖아요?? 아시죠? 이번년도에는 착한일도 잔득 했으니 산타할아버지가 오시면 드릴 쿠키를 준비해 볼게요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%82%b0%ed%83%80-%ed%81%b4%eb%a1%9c%ec%8a%a4-%ed%95%ab-%ec%b4%88%ec%bd%9c%eb%a6%bf-1906513/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 12, '(크리스마스) 크리스마스 쿠키런 쿠키 만들기', 5, 'bokyeong', systimestamp, 5124, '(크리스마스)캐빈은 지겨우니 쿠키런을 만들어 볼까?', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%a7%84%ec%a0%80-%eb%b8%8c%eb%a0%88%eb%93%9c-%eb%82%a8%ec%9e%90-%ec%8b%b8%ea%b5%ac%eb%a0%a4-%ec%a7%91-5828650/

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 12, '(크리스마스) 화이트 크리스마스 는 어려우니깐 새하얀 크리스마스 케이크', 6, 'SSoooda', systimestamp, 4658, '(크리스마스) 화이트 크리스마스를 기대하며 새햐얀 케이크를 만들어 봅시다', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--https://pixabay.com/ko/photos/%ec%bc%80%ec%9d%b4%ed%81%ac-%ec%88%9c%eb%a1%9d-%ed%81%ac%eb%a6%ac%ec%8a%a4%eb%a7%88%ec%8a%a4-6914158/

--===================================board 넣기 6개씩 (구도/각도 31)==========================================================================

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 31, '(구도/각도) 사진의 구도이해(인물편)', 1, '소라', systimestamp, 9613, '(구도/각도) 어딜가서도 이뻐보이는걸 포기 하지못하는 당신을 위해 인물편!', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 31, '(구도/각도) 더 맛있게 찍는 방법!', 2, '봄', systimestamp, 8746, '(구도/각도) 이게 집에서 찍은거라고?? 감성적인 HOMECABE사진 찍는방법', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 31, '(구도/각도) 구도를 알면 더 맛있어 보인다 사진찍는 방법!', 3, 'Jaeyeop', systimestamp, 7164, '(구도/각도) 같은 쿠키 사진도 이렇게 찍으면 더 있어보이죠', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 31, '(구도/각도) 사진을 잘찍는건 어려운게 아니랍니다', 4, '하태우', systimestamp, 6214, '(구도/각도) 어때요? 참 쉽죠?', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 31, '(구도/각도) 음식사진은 겔럭시! 겔럭시로 베이커리 사진 잘찍는방법', 5, 'bokyeong', systimestamp, 5138, '(구도/각도)겔럭시에 있는 유용한 기능등과 더이쁘게 더 맛있어 보이게 찍는 방법 알려드릴게요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 31, '(구도/각도) 조명의 각도는 생각 하셨나요??', 6, 'SSoooda', systimestamp, 4998, '(구도/각도) 빛의 중요성 여러가지 빛의 각도를 알아 봅시다 ', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

--===================================board 넣기 6개씩 (보정 32)==========================================================================

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 32, '(보정) 사진 보정을 이용한 더 맛있어 지는 베이커리', 1, '소라', systimestamp, 9889, '(보정) 색감조정만 해도 훨씬 맛있어 보여요 지금부터 알려드릴게요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 32, '(보정) 향과 분위기 마저 전달하는 보정방법', 2, '봄', systimestamp, 8112, '(보정)사진 보정만으로 빵의 향기와 HOMECABE의 분위기 마저 전달하는 보정방법 알려드릴게요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 32, '(보정) 같은구도에서 찍어도 더 맛있어 보이는 보정방법', 3, 'Jaeyeop', systimestamp, 7745, '(보정) 사진구도 이제 다들 아시죠 차별화를 두려면 보정을 해야합니다!', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 32, '(보정) 최고의 보정은 무보정??', 4, '하태우', systimestamp, 6590, '(보정) 보정하지않아도 보정한거 같은 사진 찍기', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 32, '(보정) 보정과 포스팅 강좌', 5, 'bokyeong', systimestamp, 5678, '(보정)사진보정과 포스팅 방법에 대해서 공유 드릴게요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 32, '(보정) 좀더 집중할 수 있게 만드는 보정방법', 6, 'SSoooda', systimestamp, 4148, '(보정) 보정을 약간 손보는 것만으로도 더 집중시킬 수 있습니다.', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

--===================================board 넣기 6개씩 (QnA 51)==========================================================================

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 51, '(QnA) 대용량 강력분 소분해서 어떻게 보관해야할까요? ', 1, '소라', systimestamp, 6666, '(QnA) 20kg이나 사버렸어요 어떻게 보관해야하나요..', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 51, '(QnA) 오븐 사는게 좋을까요?', 2, '봄', systimestamp, 5120, '(QnA) 취미로 천천히 배워보려고 하는데 오븐 사는게 좋을까요?', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 51, '(QnA) 일요일에 선물할 휘낭시에 오늘 구워도 될까요?', 3, 'Jaeyeop', systimestamp, 4432, '(QnA) 내일 휘낭시에를 선물하려고 하는데 오늘 부터 구워놔도 될까요?', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 51, '(QnA) 반죽기 추천해주세요', 4, '하태우', systimestamp, 3998, '(QnA) 반죽하다 손목 나갈꺼 같습니다 가성비 좋은 반죽기 추천해주세요!', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 51, '(QnA) 보정과 포스팅 강좌', 5, 'bokyeong', systimestamp, 2718, '(QnA)사진보정과 포스팅 방법에 대해서 공유 드릴게요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 51, '(QnA) 앙버터크로플 레시피 질문', 6, 'SSoooda', systimestamp, 1124, '(QnA) 모리아 가게에 파는 앙버터 크로플 재료가 알고 싶어요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

--===================================board 넣기 6개씩 (자유 게시판 52)==========================================================================

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 52, '(자유 게시판) 등급아이콘은 어떻게 골라진건가요', 1, '소라', systimestamp, 7939, '(자유 게시판) 케잌 달 수 있으려나', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 52, '(자유 게시판) 내가쓴 게시물 랭킹 올라갔다!', 2, '봄', systimestamp, 4648, '(자유 게시판)랭킹 에 게시물 올라갔다 ㅎㅎ ', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 52, '(자유 게시판) 곧 다가올 어머니 생신때 어떤 케이크 만드는게 좋을까요', 3, '3312', systimestamp, DEFAULT, '(자유 게시판) 생신은 4월 22일 금요일 입니다! 어떤걸 만들어 드려야 좋아하실까요??', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 52, '(자유 게시판) 제가 생각한 레시피가 있는데 봐주실 분 있으실까요?', 4, '하태우', systimestamp, 2116, '(자유 게시판) makers mark 위스키의 비율로 빵을 만들면 어떨까요??', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 52, '(자유 게시판) 코로나 걸린 동생을 위한 영양가 있는 간식 없을까요?', 5, 'bokyeong', systimestamp, 1541, '(자유 게시판) 항상 활발하던 동생이 기운이 없어서 마음이 아프네요 부탁드려요', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 52, '(자유 게시판) 빵을 너무좋아 하는데 밀가루가 몸에 좋지 않아서 걱정입니다', 6, 'SSoooda', systimestamp, 486, '(보정) 아직 건강할때 조심해야 한다는데 건강하게 맛있는 레시피 없을까요??', 'https://www.google.com/search?q=homebaking '); --board_map_address, board_picture
--


INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 41, '레이앤크림베이킹클래스', 1, '소라', systimestamp, 426, '연락처 0507-1453-3026 도로명주소 서울 종로구 청계천로 67', 'http://place.map.kakao.com/942892487'); --board_map_address, board_picture
--
INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 41, '베이킹클래스 훈스팩토리', 1, '소라', systimestamp, 226, '도로명주소 서울 동대문구 천호대로39길 62', 'http://place.map.kakao.com/419277541');

INSERT into BOARD (board_num, cate_num, board_title, member_num, nickname, board_date, board_hit, board_content, from_recipe) --board_map_address, board_picture
VALUES (BOARD_BOARD_NUM_SEQ.nextval, 41, '스윗언더스탠딩 베이킹클래스', 1, '소라', systimestamp, 556, '도로명주소 서울 서초구 서초대로74길 23', 'http://place.map.kakao.com/1842582732
');
INSERT INTO "C##HOMECABE"."BOARD" (BOARD_NUM, CATE_NUM, BOARD_TITLE, MEMBER_NUM, NICKNAME, BOARD_DATE, BOARD_HIT, BOARD_CONTENT, FROM_RECIPE) VALUES ('153', '41', '로사여사 베이킹클래스 달달아지트', '1', '소라', TO_TIMESTAMP('2022-04-11 20:37:21.441054000', 'YYYY-MM-DD HH24:MI:SS.FF'), '50', '도로명주소
서울 구로구 경서로1길 21', 'http://place.map.kakao.com/80189222');


commit;
