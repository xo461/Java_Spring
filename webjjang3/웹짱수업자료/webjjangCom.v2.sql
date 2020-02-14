/* 게시판 */
DROP TABLE board 
	CASCADE CONSTRAINTS;

/* 공지사항 */
DROP TABLE notice 
	CASCADE CONSTRAINTS;

/* 회원 */
DROP TABLE member 
	CASCADE CONSTRAINTS;

/* 메시지 */
DROP TABLE message 
	CASCADE CONSTRAINTS;

/* 이미지 */
DROP TABLE image 
	CASCADE CONSTRAINTS;

/* 질문답변 */
DROP TABLE qna 
	CASCADE CONSTRAINTS;

/* 게시판 */
CREATE TABLE board (
	no NUMBER NOT NULL, /* 글번호 */
	title VARCHAR2(300) NOT NULL, /* 제목 */
	content VARCHAR2(2000) NOT NULL, /* 내용 */
	writer VARCHAR2(30) NOT NULL, /* 작성자 */
	writeDate DATE DEFAULT sysdate, /* 작성일 */
	hit NUMBER DEFAULT 0 /* 조회수 */
);

COMMENT ON TABLE board IS '게시판';

COMMENT ON COLUMN board.no IS '글번호';

COMMENT ON COLUMN board.title IS '제목';

COMMENT ON COLUMN board.content IS '내용';

COMMENT ON COLUMN board.writer IS '작성자';

COMMENT ON COLUMN board.writeDate IS '작성일';

COMMENT ON COLUMN board.hit IS '조회수';

CREATE UNIQUE INDEX PK_board
	ON board (
		no ASC
	);

ALTER TABLE board
	ADD
		CONSTRAINT PK_board
		PRIMARY KEY (
			no
		);

/* 공지사항 */
CREATE TABLE notice (
	no NUMBER NOT NULL, /* 공지번호 */
	title VARCHAR2(300) NOT NULL, /* 제목 */
	content VARCHAR2(2000) NOT NULL, /* 내용 */
	startDate DATE DEFAULT sysdate, /* 공지시작일 */
	endDate DATE DEFAULT '9999-12-31', /* 공지종료일 */
	writeDate DATE DEFAULT sysdate /* 작성일 */
);

COMMENT ON TABLE notice IS '공지사항';

COMMENT ON COLUMN notice.no IS '공지번호';

COMMENT ON COLUMN notice.title IS '제목';

COMMENT ON COLUMN notice.content IS '내용';

COMMENT ON COLUMN notice.startDate IS '공지시작일';

COMMENT ON COLUMN notice.endDate IS '공지종료일';

COMMENT ON COLUMN notice.writeDate IS '작성일';

CREATE UNIQUE INDEX PK_notice
	ON notice (
		no ASC
	);

ALTER TABLE notice
	ADD
		CONSTRAINT PK_notice
		PRIMARY KEY (
			no
		);

/* 회원 */
CREATE TABLE member (
	id VARCHAR2(20) NOT NULL, /* 아이디 */
	pw VARCHAR2(20) NOT NULL, /* 비밀번호 */
	name VARCHAR2(30) NOT NULL, /* 성명 */
	birthday DATE, /* 생일 */
	gender VARCHAR2(6) NOT NULL, /* 성별 */
	tel VARCHAR2(13) NOT NULL, /* 연락처 */
	email VARCHAR2(50) NOT NULL, /* 이메일 */
	photo VARCHAR2(50), /* 사진 */
	grade NUMBER(2) DEFAULT 1, /* 등급 */
	state VARCHAR2(6) DEFAULT '일반', /* 상태 */
	loginDate DATE DEFAULT sysdate, /* 최종로그인 */
	regDate DATE DEFAULT sysdate, /* 가입일 */
	message NUMBER DEFAULT 0 /* 메시지 */
);

COMMENT ON TABLE member IS '회원';

COMMENT ON COLUMN member.id IS '아이디';

COMMENT ON COLUMN member.pw IS '비밀번호';

COMMENT ON COLUMN member.name IS '성명';

COMMENT ON COLUMN member.birthday IS '생일';

COMMENT ON COLUMN member.gender IS '성별';

COMMENT ON COLUMN member.tel IS '연락처';

COMMENT ON COLUMN member.email IS '이메일';

COMMENT ON COLUMN member.photo IS '사진';

COMMENT ON COLUMN member.grade IS '등급';

COMMENT ON COLUMN member.state IS '상태';

COMMENT ON COLUMN member.loginDate IS '최종로그인';

COMMENT ON COLUMN member.regDate IS '가입일';

COMMENT ON COLUMN member.message IS '메시지';

CREATE UNIQUE INDEX PK_member
	ON member (
		id ASC
	);

ALTER TABLE member
	ADD
		CONSTRAINT PK_member
		PRIMARY KEY (
			id
		);

/* 메시지 */
CREATE TABLE message (
	no NUMBER NOT NULL, /* 메시지번호 */
	sender VARCHAR2(20) NOT NULL, /* 보낸사람 */
	accepter VARCHAR2(20) NOT NULL, /* 받는사람 */
	sendDate DATE DEFAULT sysdate, /* 보낸날짜 */
	acceptDate DATE, /* 받은날짜 */
	content VARCHAR2(2000) NOT NULL /* 메시지 */
);

COMMENT ON TABLE message IS '메시지';

COMMENT ON COLUMN message.no IS '메시지번호';

COMMENT ON COLUMN message.sender IS '보낸사람';

COMMENT ON COLUMN message.accepter IS '받는사람';

COMMENT ON COLUMN message.sendDate IS '보낸날짜';

COMMENT ON COLUMN message.acceptDate IS '받은날짜';

COMMENT ON COLUMN message.content IS '메시지';

CREATE UNIQUE INDEX PK_message
	ON message (
		no ASC
	);

ALTER TABLE message
	ADD
		CONSTRAINT PK_message
		PRIMARY KEY (
			no
		);

/* 이미지 */
CREATE TABLE image (
	no NUMBER NOT NULL, /* 이미지번호 */
	title VARCHAR2(300) NOT NULL, /* 제목 */
	content VARCHAR2(2000) NOT NULL, /* 내용 */
	id VARCHAR2(20) NOT NULL, /* 작성자아이디 */
	fileName VARCHAR2(50) NOT NULL, /* 파일명 */
	writeDate DATE DEFAULT sysdate, /* 등록일 */
	hit NUMBER DEFAULT 0 /* 조회수 */
);

COMMENT ON TABLE image IS '이미지';

COMMENT ON COLUMN image.no IS '이미지번호';

COMMENT ON COLUMN image.title IS '제목';

COMMENT ON COLUMN image.content IS '내용';

COMMENT ON COLUMN image.id IS '작성자아이디';

COMMENT ON COLUMN image.fileName IS '파일명';

COMMENT ON COLUMN image.writeDate IS '등록일';

COMMENT ON COLUMN image.hit IS '조회수';

CREATE UNIQUE INDEX PK_image
	ON image (
		no ASC
	);

ALTER TABLE image
	ADD
		CONSTRAINT PK_image
		PRIMARY KEY (
			no
		);

/* 질문답변 */
CREATE TABLE qna (
	no NUMBER NOT NULL, /* 글번호 */
	title VARCHAR2(300) NOT NULL, /* 제목 */
	content VARCHAR2(2000) NOT NULL, /* 내용 */
	id VARCHAR2(20) NOT NULL, /* 작성자ID */
	writeDate DATE DEFAULT sysdate, /* 작성일 */
	hit NUMBER DEFAULT 0, /* 조회수 */
	refNo NUMBER, /* 관련글번호 */
	ordNo NUMBER, /* 순서번호 */
	levNo NUMBER, /* 들여쓰기번호 */
	parentNo NUMBER /* 부모글번호 */
);

COMMENT ON TABLE qna IS '질문답변';

COMMENT ON COLUMN qna.no IS '글번호';

COMMENT ON COLUMN qna.title IS '제목';

COMMENT ON COLUMN qna.content IS '내용';

COMMENT ON COLUMN qna.id IS '작성자ID';

COMMENT ON COLUMN qna.writeDate IS '작성일';

COMMENT ON COLUMN qna.hit IS '조회수';

COMMENT ON COLUMN qna.refNo IS '관련글번호';

COMMENT ON COLUMN qna.ordNo IS '순서번호';

COMMENT ON COLUMN qna.levNo IS '들여쓰기번호';

COMMENT ON COLUMN board2.parentNo IS '부모글번호';

CREATE UNIQUE INDEX PK_board2
	ON qna (
		no ASC
	);

ALTER TABLE qna
	ADD
		CONSTRAINT PK_qna
		PRIMARY KEY (
			no
		);

ALTER TABLE message
	ADD
		CONSTRAINT FK_member_TO_message
		FOREIGN KEY (
			sender
		)
		REFERENCES member (
			id
		)
        ON DELETE CASCADE;

ALTER TABLE message
	ADD
		CONSTRAINT FK_member_TO_message2
		FOREIGN KEY (
			accepter
		)
		REFERENCES member (
			id
		)
        ON DELETE CASCADE;

ALTER TABLE image
	ADD
		CONSTRAINT FK_member_TO_image
		FOREIGN KEY (
			id
		)
		REFERENCES member (
			id
		);

ALTER TABLE qna
	ADD
		CONSTRAINT FK_member_TO_qna
		FOREIGN KEY (
			id
		)
		REFERENCES member (
			id
		);

ALTER TABLE qna
	ADD
		CONSTRAINT FK_qna_TO_qna_refNo
		FOREIGN KEY (
			refNo
		)
		REFERENCES qna (
			no
		)
        ON DELETE CASCADE;
        
ALTER TABLE qna
	ADD
		CONSTRAINT FK_qna_TO_qna_parentNo
		FOREIGN KEY (
			parentNo
		)
		REFERENCES qna (
			no
		)
        ON DELETE CASCADE;
        