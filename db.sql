drop database buytogether;


create database buytogether;




use buytogether;
-- drop table access cascade CONSTRAINTS;


-- 접근
CREATE TABLE access (
	access_number INTEGER     NOT NULL auto_increment, -- 접근번호
	access_name   VARCHAR(50) NULL,      -- 접근명
	access_declare_count INTEGER     NULL,     -- 신고횟수
	access_duedate       INTEGER     NULL,      -- 제한날짜수




	primary key(access_number)
);








-- 유저
CREATE TABLE user (
	user_number      INTEGER      NOT NULL auto_increment, -- 유저번호
	id               VARCHAR(12)  NOT NULL unique,     -- 아이디
	pw               VARCHAR(60)  NULL,     -- 비밀번호
	name             VARCHAR(8)   NOT NULL,     -- 이름
	email            VARCHAR(20)  NOT NULL unique,     -- 이메일
	phone_number     VARCHAR(11)  NOT NULL,     -- 전화번호
	birthdate         DATE         NOT NULL,     -- 생년월일
	gender           VARCHAR(2)   NOT NULL,     -- 성별
	nickname         VARCHAR(10)  NOT NULL unique,     -- 닉네임
	profile          VARCHAR(100) NULL,     -- 프로필사진
	reputation       INTEGER      NOT NULL default 70,     -- 평판




	primary key (user_number)
	
);




-- 카테고리
CREATE TABLE category (
	category_number INTEGER     NOT NULL auto_increment, -- 카테고리번호
	category_name   VARCHAR(20) NULL,      -- 카테고리명




	primary key (category_number)
);




-- 관심
CREATE TABLE interest (
	interest_number INTEGER NOT NULL auto_increment, -- 관심번호
	user_number     INTEGER NULL,     -- 유저번호
	category_number INTEGER NULL,      -- 카테고리번호




	primary key (interest_number),
	foreign key (user_number) references user (user_number) on delete cascade,
	foreign key (category_number) references category (category_number) on delete cascade
);




-- 관리자
CREATE TABLE admin (
	admin_number      INTEGER     NOT NULL auto_increment, -- 관리자번호
	admin_id          VARCHAR(10) NOT NULL unique,     -- 아이디
	admin_pw          VARCHAR(60) NOT NULL,     -- 비밀번호
	admin_nickname    VARCHAR(10) NOT NULL unique,     -- 닉네임
	admin_email       VARCHAR(20) NOT NULL,     -- 이메일
	admin_phonenumber VARCHAR(11) NOT NULL,     -- 전화번호
	admin_grade       INTEGER     NOT NULL,     -- 관리자등급




	primary key (admin_number)
);




-- Q&A
CREATE TABLE qna (
	qna_number    INTEGER     NOT NULL auto_increment, -- Q&A번호
	qna_parent_number INTEGER NULL, -- qna 질문글(답글 달때 qna번호가 들어감)
	qna_title     VARCHAR(50) NOT NULL,     -- 제목
	qna_content   TEXT        NOT NULL,     -- 내용
	qna_writedate timestamp        NOT NULL default now(),     -- 작성일
	user_number   INTEGER     NULL,     -- 유저번호
	admin_number  INTEGER     NULL,      -- 관리자번호




	primary key (qna_number),
	foreign key (user_number) references user (user_number) on delete cascade,
	foreign key (admin_number) references admin (admin_number) on delete set null,
	foreign key (qna_parent_number) references qna(qna_number) on delete cascade
);








-- 선택상태
CREATE TABLE matching (
	matching_status_number INTEGER    NOT NULL auto_increment, -- 선택상태번호
	matching_status_name   VARCHAR(6) NULL,     -- 선택상태명




	primary key (matching_status_number)
);












-- 사냥방식
CREATE TABLE huntingtype (
	hunting_type_number INTEGER    NOT NULL auto_increment, -- 사냥방식번호
	hunting_type        VARCHAR(8) NULL,      -- 사냥방식명




	primary key (hunting_type_number)
);








-- 같이사냥상태
CREATE TABLE huntingstatus (
	status_number INTEGER     NOT NULL auto_increment, -- 상태번호
	status_name   VARCHAR(20) NULL,      -- 상태명




	primary key (status_number)
);




-- 같이사냥
CREATE TABLE buytogether (
	buytogether_number   INTEGER      NOT NULL auto_increment, -- 같이사냥번호
	title                VARCHAR(50)  NOT NULL,     -- 제목
	content              TEXT         NOT NULL,     -- 내용
	writedate            timestamp         NOT NULL default now(),     -- 작성시간
	updatedate           timestamp         NOT NULL default now(),     -- 수정시간
	duedate              timestamp         NOT NULL,     -- 마감시간
	join_number          INTEGER      NOT NULL,     -- 참여정원
	price                INTEGER      NOT NULL,     -- 가격
	category_number      INTEGER      NULL,     -- 카테고리번호
	user_number          INTEGER      NOT NULL,     -- 유저번호
	status_number       INTEGER      NOT NULL default 1,     -- 상태번호
	hunting_type_number INTEGER      NOT NULL,      -- 사냥방식번호




	primary key (buytogether_number),
	foreign key (category_number) references category (category_number) on delete set null,
	foreign key (user_number) references user (user_number) on delete cascade,
	foreign key (status_number) references huntingstatus (status_number) on delete cascade,
	foreign key (hunting_type_number) references huntingtype (hunting_type_number) on delete cascade
);




-- 사냥찜
CREATE TABLE dip (
	dip_number         INTEGER NOT NULL auto_increment, -- 찜번호
	user_number        INTEGER NOT NULL,     -- 유저번호
	buytogether_number INTEGER NOT NULL,      -- 같이사냥번호




	primary key (dip_number),
	foreign key (user_number) references user (user_number) on delete cascade,
	foreign key (buytogether_number) references buytogether (buytogether_number) on delete cascade
);




-- 참여
CREATE TABLE joinin (
	joinin_number         INTEGER NOT NULL auto_increment, -- 참여번호
	user_number         INTEGER NOT NULL,     -- 유저번호
	matching_status_number INTEGER NOT NULL default 1 ,     -- 선택상태번호
	buytogether_number  INTEGER NULL,      -- 같이사냥번호




	primary key (joinin_number),
	foreign key (user_number) references user (user_number) on delete cascade,
	foreign key (matching_status_number) references matching (matching_status_number) on delete cascade,
	foreign key (buytogether_number) references buytogether (buytogether_number) on delete set null
);








-- 댓글분류
CREATE TABLE commenttype (
	comment_type_number INTEGER     NOT NULL auto_increment, -- 댓글분류번호
	comment_type_name   VARCHAR(10) NOT NULL,      -- 댓글분류명




	primary key (comment_type_number)
);



-- 댓글
CREATE TABLE comment (
	comment_number      INTEGER NOT NULL auto_increment, -- 댓글번호
	comment_parent_number INTEGER NULL, -- 부모댓글번호
	comment_content     TEXT    NOT NULL,     -- 내용
	comment_writedate   timestamp NOT NULL default now(),     -- 작성일
	buytogether_number  INTEGER NOT NULL,     -- 같이사냥번호
	user_number         INTEGER NOT NULL,     -- 유저번호
	comment_type_number INTEGER NOT NULL,      -- 댓글분류번호




	primary key (comment_number),
	foreign key (buytogether_number) references buytogether (buytogether_number) on delete cascade,
	foreign key (user_number) references user (user_number) on delete cascade,
	foreign key (comment_type_number) references commenttype (comment_type_number) on delete cascade,
	foreign key (comment_parent_number) references comment(comment_number) on delete cascade
	
);




-- 신고카테고리
CREATE TABLE declarecategory (
	declare_category_number INTEGER     NOT NULL auto_increment, -- 신고카테고리번호
	declare_category_name   VARCHAR(20) NOT NULL,      -- 카테고리명




	primary key (declare_category_number)
);








-- 신고글분류
CREATE TABLE declaretype (
	type_number INTEGER    NOT NULL auto_increment, -- 분류번호
	type        VARCHAR(6) NOT NULL,      -- 분류




	primary key (type_number)
);




-- 신고글
CREATE TABLE declareboard (
	declare_number          INTEGER      NOT NULL auto_increment, -- 신고글번호
	buytogether_number      INTEGER      NULL,     -- 신고타켓번호
	comment_number 	INTEGER NULL,
	type_number             INTEGER      NOT NULL,     -- 분류번호
	declare_category_number INTEGER      NOT NULL,     -- 신고카테고리번호
	user_number             INTEGER      NOT NULL,     -- 유저번호
	declare_reason          TEXT         NULL,     -- 사유
	declare_photo           VARCHAR(100) NULL,     -- 첨부사진
	declare_status          BOOLEAN      NOT NULL default false,      -- 처리상태




	primary key (declare_number),
	foreign key (buytogether_number) references buytogether (buytogether_number) on delete set null,
	foreign key (comment_number) references comment (comment_number) on delete set null,
	foreign key (user_number) references user (user_number) on delete cascade,
	foreign key (declare_category_number) references declarecategory (declare_category_number) on delete cascade,
	foreign key (type_number) references declaretype (type_number) on delete cascade




);










-- 게시판종류(공지,FAQ,정보사냥,튜토리얼,같이사냥)
CREATE TABLE boardtype (
	board_type_number INTEGER     NOT NULL auto_increment, -- 게시판종류번호
	board_name        VARCHAR(10) NOT NULL unique,     -- 게시판이름




	primary key (board_type_number)
);








-- 게시판(공지,FAQ,정보사냥,튜토리얼)
CREATE TABLE board (
	board_number      INTEGER     NOT NULL auto_increment, -- 게시글번호
	board_title       VARCHAR(50) NOT NULL,     -- 제목
	board_content     TEXT        NOT NULL,     -- 내용
	board_writedate   timestamp        NOT NULL default now(),     -- 작성시간
	board_updatedate  timestamp        NULL,     -- 수정시간
	admin_number      INTEGER     NULL,     -- 관리자번호
	board_type_number INTEGER     NOT NULL,      -- 게시판종류번호




	primary key (board_number),
	foreign key (admin_number) references admin (admin_number) on delete set null,
	foreign key (board_type_number) references boardtype (board_type_number) on delete cascade




);




-- 첨부사진
CREATE TABLE attachedphoto (
	photo_number       INTEGER      NOT NULL auto_increment, -- 사진번호
	path               VARCHAR(100) NOT NULL,     -- 경로
	board_number       INTEGER      NULL,     -- 게시글번호
	buytogether_number INTEGER	 NULL,
	board_type_number  INTEGER      NOT NULL,     -- 게시판종류번호




	primary key (photo_number),
	foreign key (board_type_number) references boardtype (board_type_number) on delete cascade,
	foreign key (board_number) references board (board_number) on delete cascade,
	foreign key (buytogether_number) references buytogether (buytogether_number) on delete cascade
);








-- 검색
CREATE TABLE search (
	keyword_number INTEGER     NOT NULL auto_increment, -- 키워드번호
	keyword        VARCHAR(100) NOT NULL unique,      -- 키워드




	primary key (keyword_number)
);




-- 유저주소
CREATE TABLE useraddress (
	user_address_number INTEGER     NOT NULL auto_increment, -- 주소번호
	user_sido           VARCHAR(20) NOT NULL,     -- 시/도
	user_sigungu        VARCHAR(20) NOT NULL,     -- 시/군/구
	user_road_address   VARCHAR(20) NOT NULL,     -- 도로명
	user_detail         VARCHAR(50) NULL,     -- 상세주소
	user_number         INTEGER     NOT NULL,      -- 유저번호




	primary key (user_address_number),
	foreign key (user_number) references user (user_number) on delete cascade
);




-- 같이사냥주소
CREATE TABLE buytogetheraddress (
	buytogether_address_number       INTEGER      NOT NULL auto_increment, -- 주소번호
	latitude                         INTEGER      NOT NULL,     -- 위도
	longitude                        INTEGER      NOT NULL,     -- 경도
	buytogether_address_sido         VARCHAR(10)  NOT NULL,     -- 시/도
	buytogether_address_sigungu      VARCHAR(10)  NOT NULL,     -- 시/군/구
	buytogether_address_road_address VARCHAR(100) NOT NULL,     -- 도로명
	buytogether_address_detail       VARCHAR(50)  NULL,     -- 상세주소
	buytogether_number               INTEGER      NOT NULL,      -- 같이사냥번호




	primary key (buytogether_address_number),
	foreign key (buytogether_number) references buytogether (buytogether_number) on delete cascade
);




-- 신고유저
CREATE TABLE declareuser (
	user_number   INTEGER NOT NULL, -- 유저번호
	delcare_count INTEGER NULL,     -- 신고누적횟수
	access_free   timestamp    NULL,     -- 제한해제시간
	access_number INTEGER NULL,      -- 접근번호
    
    primary key (user_number),
	foreign key (user_number) references user (user_number) on delete cascade,
    foreign key (access_number) references access (access_number) on delete cascade




);


-- inset 쿼리



-- access (-1은 탈퇴를 의미한다.)
insert into access(access_name, access_declare_count, access_duedate) 
values("경고횟수3", 3, 1);
insert into access(access_name, access_declare_count, access_duedate) 
values("경고횟수5", 5, 3);
insert into access(access_name, access_declare_count, access_duedate) 
values("경고횟수7", 7, 5);
insert into access(access_name, access_declare_count, access_duedate) 
values("경고횟수10", 10, -1);

-- user 
insert into user(id, pw, name, email, phone_number, birthdate, gender, nickname, profile) 
values("user1", "user1", "user1", "user1@user1", "111", "1994-04-06", "M", "희원찡", null);
insert into user(id, pw, name, email, phone_number, birthdate, gender, nickname, profile) 
values("user2", "user2", "user2", "user2@user2", "222", "1994-02-02", "M", "양갱갱", null);
insert into user(id, pw, name, email, phone_number, birthdate, gender, nickname, profile) 
values("user3", "user3", "user3", "user3@user3", "333", "1994-03-03", "M", "소희짱", null);
insert into user(id, pw, name, email, phone_number, birthdate, gender, nickname, profile) 
values("user4", "user4", "user4", "user4@user4", "444", "1994-04-04", "M", "수리수리", null);
insert into user(id, pw, name, email, phone_number, birthdate, gender, nickname, profile) 
values("user5", "user5", "user5", "user5@user5", "555", "1994-05-05", "M", "갤갤갤", null);
insert into user(id, pw, name, email, phone_number, birthdate, gender, nickname, profile) 
values("user6", "user6", "user6", "user6@user6", "666", "1994-06-06", "M", "성유니", null);
insert into user(id, pw, name, email, phone_number, birthdate, gender, nickname, profile) 
values("user7", "user7", "user7", "user7@user7", "777", "1997-07-07", "M", "디마", null);
insert into user(id, pw, name, email, phone_number, birthdate, gender, nickname, profile) 
values("user8", "user8", "user8", "user8@user8", "888", "1998-08-08", "M", "888", null);
insert into user(id, pw, name, email, phone_number, birthdate, gender, nickname, profile) 
values("user9", "user9", "user9", "user9@user9", "999", "1994-09-09", "M", "팀리더", null);
insert into user(id, pw, name, email, phone_number, birthdate, gender, nickname, profile) 
values("user10", "user10", "user10", "user10@user10", "10", "1990-04-06", "M", "000", null);

-- category
insert into category(category_number, category_name)
values(1,"식품");
insert into category(category_number, category_name)
values(2,"뷰티");
insert into category(category_number, category_name)
values(3,"생활용품");
insert into category(category_number, category_name)
values(4,"의류/악세사리");
insert into category(category_number, category_name)
values(5,"기타");

select * from category;

-- interest
insert into interest(user_number, category_number)
values(1,5);
insert into interest(user_number, category_number)
values(2,1);
insert into interest(user_number, category_number)
values(3,2);
insert into interest(user_number, category_number)
values(4,5);
insert into interest(user_number, category_number)
values(4,1);
insert into interest(user_number, category_number)
values(5,4);
insert into interest(user_number, category_number)
values(6,3);
insert into interest(user_number, category_number)
values(7,1);
insert into interest(user_number, category_number)
values(7,2);
insert into interest(user_number, category_number)
values(7,3);
insert into interest(user_number, category_number)
values(8,3);
insert into interest(user_number, category_number)
values(10,1);

-- admin (1=전체관리자)
insert into admin(admin_id, admin_pw, admin_nickname, admin_email, admin_phonenumber, admin_grade)
values("admin1", "admin1", "admin1", "admin1@admin1.com", 12345, 1);
insert into admin(admin_id, admin_pw, admin_nickname, admin_email, admin_phonenumber, admin_grade)
values("admin2", "admin2", "admin2", "admin2@admin2.com", 12345, 2);

-- qna
insert into qna(qna_title, qna_content, user_number)
values("같이 사냥을 할때.. ", "사람들이 제꺼에는 참여를 안해요..", 4);

insert into qna(qna_title, qna_content, user_number)
values("정보 사냥을 할때.. ", "저에게는 정보를 안주세요?ㅡㅡ", 1);

insert into qna(qna_title, qna_content, user_number)
values("제 평판이...", "왜 내려갔오용?;;", 9);

insert into qna(qna_parent_number, qna_title, qna_content, admin_number)
values(1, "고객님 .........", "제가 해드릴께요 ...", 2);


-- matching
insert into matching(matching_status_name)
values("사냥대기중");
insert into matching(matching_status_name)
values("같이사냥중");

-- huningtype
insert into huntingtype(hunting_type)
values("온라인");
insert into huntingtype(hunting_type)
values("오프라인");

-- huntingstatus
insert into huntingstatus(status_name)
values("혼자사냥중");
insert into huntingstatus(status_name)
values("같이사냥중");
insert into huntingstatus(status_name)
values("같이사냥완료");
insert into huntingstatus(status_name)
values("사냥실패");

-- buytogether
insert into buytogether(title, content, duedate, join_number, price, category_number, user_number, hunting_type_number)
values("햄버거 살사람 괌", "롯데리아 9,900원 행사 같이 하실분? 추가 2명 모집", "2016-12-03", 2, 9900, 1, 4, 2);

insert into buytogether(title, content, duedate, join_number, price, category_number, user_number, hunting_type_number)
values("립스틱 같이 살사람~", "미샤에서 1+1데이 립스틱 같이 사요","2016-12-04", 1, 12000, 2, 5, 2);

insert into buytogether(title, content, duedate, join_number, price, category_number, user_number, hunting_type_number)
values("카카오톡 이어폰 1+1", "이어폰 같이 사자 님들아", "2016-12-05", 1, 15000, 3, 3, 1);

insert into buytogether(title, content, duedate, join_number, price, category_number, user_number, hunting_type_number)
values("코스타 회식 같이 참가하실분", "코스타에서 하는 회식인데 같이 참여합시다.", "2016-12-28", 1, 50000, 1, 6, 2);

insert into buytogether(title, content, duedate, join_number, price, category_number, user_number, hunting_type_number)
values("참이슬 크리스마스 에디션 같이 사자", "아이유가 광고하는 참이슬 크리스마스 에디션 쏴주 같이 살사람", "2016-12-25", 5, 500000, 1, 8, 2);

insert into buytogether(title, content, duedate, join_number, price, category_number, user_number, hunting_type_number)
values("해외직구 같이 하실분~", "꼼대가르송 살사람 같이서 배송비 나눠요 ㅎ", "2017-01-01", 5, 250000, 4, 7, 1);

insert into buytogether(title, content, duedate, join_number, price, category_number, user_number, hunting_type_number)
values("아이폰7 같이 살사람 모여라 모여라", "인천지점에서 할인하고 있으니까 같이 가자 님들아", "2016-12-31", 10, 700000, 5,  4, 2);

insert into buytogether(title, content, duedate, join_number, price, category_number, user_number, hunting_type_number)
values("비행기 티켓 사실분 커플석", "제주도 항공권 커플석이 할인되요 같이 사실분 연락주세요", "2017-01-03", 1, 80000, 5, 4, 2);

insert into buytogether(title, content, duedate, join_number, price, category_number, user_number, hunting_type_number)
values("브라질산 인디아 커피가 1+1", "아메리카노마실껀데 핫초코 마실래?", "2016-12-25", 1, 8000, 1, 7, 2);

insert into buytogether(title, content, duedate, join_number, price, category_number, user_number, hunting_type_number)
values("강아지 분양 같이 하실분", "강아지가 너무 이뻐서 같이 사실분 근데 아직 안태어 났어", "2017-05-05", 5, 9999999, 5,  1, 1);

insert into buytogether(title, content, duedate, join_number, price, category_number, user_number, hunting_type_number)
values("미용실 할인 티켓을 같이 살 사람을 구하고 있어요", "이번에 오픈한 미용실이 있는데 같이 가자", "2016-12-12", 3, 12000, 5, 2, 2);

-- dip
insert into dip(user_number, buytogether_number)
values(10, 8);

insert into dip(user_number, buytogether_number)
values(1, 2);

insert into dip(user_number, buytogether_number)
values(2, 7);

insert into dip(user_number, buytogether_number)
values(6, 11);

insert into dip(user_number, buytogether_number)
values(10, 1);

insert into dip(user_number, buytogether_number)
values(10, 5);

-- joinin
insert into joinin(user_number, matching_status_number, buytogether_number)
values(10,1,2);

insert into joinin(user_number, matching_status_number, buytogether_number)
values(4,2,11);

insert into joinin(user_number, matching_status_number, buytogether_number)
values(2,2,11);

insert into joinin(user_number, matching_status_number, buytogether_number)
values(8,1,6);

-- commenttype
insert into commenttype(comment_type_name)
values("전체댓글");

insert into commenttype(comment_type_name)
values("참여자댓글");

-- comment
insert into comment(comment_content, buytogether_number, user_number,comment_type_number)
values("비행기 언제 타실 건가여??",8,10,1);

insert into comment(comment_content, buytogether_number, user_number,comment_type_number)
values("와 내가 걸리다니!!!",8,6,2);

insert into comment(comment_content, buytogether_number, user_number,comment_type_number)
values("저랑 같이 해요 ",11,4,2);

insert into comment(comment_content, buytogether_number, user_number,comment_type_number)
values("거기 원장님 잘 하시나요?",11,6,1);

insert into comment(comment_parent_number,comment_content, buytogether_number, user_number,comment_type_number)
values(4,"잘해요 ㅡㅡ",11,2,1);

-- declarecategory
insert into declarecategory(declare_category_name)
values("부적절한 홍보 게시물");

insert into declarecategory(declare_category_name)
values("음란성 또는 유해 게시물");

insert into declarecategory(declare_category_name)
values("욕설 및 비방 게시물");

insert into declarecategory(declare_category_name)
values("기타");

-- declaretype
insert into declaretype(type)
values("같이사냥");

insert into declaretype(type)
values("댓글");

-- declareboard
insert into declareboard(comment_number, type_number, declare_category_number, user_number, declare_status)
values(5, 2, 3, 6, true);

insert into declareboard(buytogether_number, type_number, declare_category_number, user_number, declare_status)
values(6, 1, 4, 4, false);

-- boardtype
insert into boardtype(board_type_number, board_name)
values(1, "공지사항");

insert into boardtype(board_type_number, board_name)
values(2, "FaQ");

insert into boardtype(board_type_number, board_name)
values(3, "정보사냥");

insert into boardtype(board_type_number, board_name)
values(4, "튜토리얼");

insert into boardtype(board_type_number, board_name)
values(5, "같이사냥");

-- board
insert into board(board_title, board_content, admin_number, board_type_number)
values("공지사항", "우리사이트는 같이사는 사이트 입니다.", 2 , 1);

insert into board(board_title, board_content, admin_number, board_type_number)
values("[사냥관련] FaQ 어떤 방식으로 사냥을 하는건가요.", "만나서 해야지", 2 , 2);

insert into board(board_title, board_content, admin_number, board_type_number)
values("[사냥관련] FaQ 사냥 이 뭐죠?", "사냥 사냥", 2 , 2);

insert into board(board_title, board_content, admin_number, board_type_number)
values("[정보관련] FaQ", "어떤 방식으로 사냥을 하는건가요.", 2 , 2);

insert into board(board_title, board_content, admin_number, board_type_number)
values("[정보관련] FaQ", "어떤 방식으로 사냥을 하는건가요.", 2 , 2);

insert into board(board_title, board_content, admin_number, board_type_number)
values("[고객센터] FaQ", "어떤 방식으로 사냥을 하는건가요.", 2 , 2);

insert into board(board_title, board_content, admin_number, board_type_number)
values("[고객센터] FaQ 고객센터 질문", "고객센터 고객센터.", 2 , 2);

insert into board(board_title, board_content, admin_number, board_type_number)
values("[회원관련] FaQ 회원이 뭐죠?", "회원은 이거다", 2 , 2);

insert into board(board_title, board_content, admin_number, board_type_number)
values("[회원관련] FaQ 어떤 방식으로 회원을 하는건가요", "회원회원.", 2 , 2);

insert into board(board_title, board_content, admin_number, board_type_number)
values("정보사냥", "지금 이마트 1+1 데이!!", 2 , 3);

insert into board(board_title, board_content, admin_number, board_type_number)
values("튜토리얼", "잘 따라 하세요.", 2 , 4);

-- attachedphoto
insert into attachedphoto(photo_number, path, buytogether_number, board_type_number)
values(1, "C:\picture/2015-07-18_11;34;39.jpg", 1, 5);

insert into attachedphoto(photo_number, path, board_number, board_type_number)
values(2, "C:\picture/2015-07-18_11;34;39.jpg", 3, 3);

update attachedphoto set path = "C:\\picture/2015-07-18_11;34;39.jpg" where photo_number = 2;
update attachedphoto set path = "C:\\picture/2015-07-18_11;34;39.jpg" where photo_number = 2;

-- search
insert into search(keyword)
values("햄버거");

-- useraddress
insert into useraddress(user_sido, user_sigungu, user_road_address, user_number)
values("경기", "부천시 원미구", "부천시 원미구 상동로", 7);

insert into useraddress(user_sido, user_sigungu, user_road_address, user_number)
values("인천시", "남동구", "인천시 남동구 장승남로", 4);

-- buytogetheraddress
insert into buytogetheraddress(latitude, longitude, buytogether_address_sido, buytogether_address_sigungu, buytogether_address_road_address, buytogether_address_detail, buytogether_number)
values(37.5658091, 126.9729574, "서울시", "중구", "서울시 중구 소곡동 세종대로 99", "덕수궁 아무데나", 1);

insert into buytogetheraddress(latitude, longitude, buytogether_address_sido, buytogether_address_sigungu, buytogether_address_road_address, buytogether_address_detail, buytogether_number)
values(37.4425839, 126.7390241, "인천시", "남동구", "인천시 남동구 장승남로 82", "롤pc방 앞", 2);

insert into buytogetheraddress(latitude, longitude, buytogether_address_sido, buytogether_address_sigungu, buytogether_address_road_address, buytogether_address_detail, buytogether_number)
values(37.4997717, 126.7484669, "경기", "부천시 원미구", "부천시 원미구 상동로 25", "상동역 앞", 3);

insert into buytogetheraddress(latitude, longitude, buytogether_address_sido, buytogether_address_sigungu, buytogether_address_road_address, buytogether_address_detail, buytogether_number)
values(37.2937887, 126.9703299, "경기", "수원시 장안구", "수원시 장안구 서부로 2066", "성균관대", 4);

insert into buytogetheraddress(latitude, longitude, buytogether_address_sido, buytogether_address_sigungu, buytogether_address_road_address, buytogether_address_detail, buytogether_number)
values(37.5075322, 126.7153239, "인천시", "부평구", "인천시 부평구 길주로 496", "쌍용아파트", 5);

insert into buytogetheraddress(latitude, longitude, buytogether_address_sido, buytogether_address_sigungu, buytogether_address_road_address, buytogether_address_detail, buytogether_number)
values(37.4674447, 126.799337, "경기", "부천시 소사구", "서울시 강서구 까치산로20", "덕수궁 아무데나", 6);

insert into buytogetheraddress(latitude, longitude, buytogether_address_sido, buytogether_address_sigungu, buytogether_address_road_address, buytogether_address_detail, buytogether_number)
values(35.1577096, 129.1446685, "부산", "해운대구", "부산광역시 해운대구 해운대해변로 120", "우리은행 마린시티점", 7);

insert into buytogetheraddress(latitude, longitude, buytogether_address_sido, buytogether_address_sigungu, buytogether_address_road_address, buytogether_address_detail, buytogether_number)
values(33.5559872, 126.7944529, "제주", "구좌읍", "제주시 구좌읍 월정리 717", "원정리 해변", 8);

insert into buytogetheraddress(latitude, longitude, buytogether_address_sido, buytogether_address_sigungu, buytogether_address_road_address, buytogether_address_detail, buytogether_number)
values(37.5186862, 130.7914842, "경상북도", "울릉군", "경상북도 서면 태하등대길188 ", "울릉도", 9);

insert into buytogetheraddress(latitude, longitude, buytogether_address_sido, buytogether_address_sigungu, buytogether_address_road_address, buytogether_address_detail, buytogether_number)
values(35.1398296 , 126.8087774, "전라북도", "광주 광산구", "전라북도 광주시 광산구 상무대로 420", "광주 국제 공항", 10);

insert into buytogetheraddress(latitude, longitude, buytogether_address_sido, buytogether_address_sigungu, buytogether_address_road_address, buytogether_address_detail, buytogether_number)
values(35.827981, 127.1199938, "전라북도", "전주", "전라북도 전주시 완산구 감나무로 2", "우리은행 마린시티점", 11);

-- declareuser
insert into declareuser(user_number, delcare_count)
values(2, 1);

update user set pw="03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4" where user_number=1; 