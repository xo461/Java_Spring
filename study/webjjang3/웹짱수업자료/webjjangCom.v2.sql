/* �Խ��� */
DROP TABLE board 
	CASCADE CONSTRAINTS;

/* �������� */
DROP TABLE notice 
	CASCADE CONSTRAINTS;

/* ȸ�� */
DROP TABLE member 
	CASCADE CONSTRAINTS;

/* �޽��� */
DROP TABLE message 
	CASCADE CONSTRAINTS;

/* �̹��� */
DROP TABLE image 
	CASCADE CONSTRAINTS;

/* �����亯 */
DROP TABLE qna 
	CASCADE CONSTRAINTS;

/* �Խ��� */
CREATE TABLE board (
	no NUMBER NOT NULL, /* �۹�ȣ */
	title VARCHAR2(300) NOT NULL, /* ���� */
	content VARCHAR2(2000) NOT NULL, /* ���� */
	writer VARCHAR2(30) NOT NULL, /* �ۼ��� */
	writeDate DATE DEFAULT sysdate, /* �ۼ��� */
	hit NUMBER DEFAULT 0 /* ��ȸ�� */
);

COMMENT ON TABLE board IS '�Խ���';

COMMENT ON COLUMN board.no IS '�۹�ȣ';

COMMENT ON COLUMN board.title IS '����';

COMMENT ON COLUMN board.content IS '����';

COMMENT ON COLUMN board.writer IS '�ۼ���';

COMMENT ON COLUMN board.writeDate IS '�ۼ���';

COMMENT ON COLUMN board.hit IS '��ȸ��';

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

/* �������� */
CREATE TABLE notice (
	no NUMBER NOT NULL, /* ������ȣ */
	title VARCHAR2(300) NOT NULL, /* ���� */
	content VARCHAR2(2000) NOT NULL, /* ���� */
	startDate DATE DEFAULT sysdate, /* ���������� */
	endDate DATE DEFAULT '9999-12-31', /* ���������� */
	writeDate DATE DEFAULT sysdate /* �ۼ��� */
);

COMMENT ON TABLE notice IS '��������';

COMMENT ON COLUMN notice.no IS '������ȣ';

COMMENT ON COLUMN notice.title IS '����';

COMMENT ON COLUMN notice.content IS '����';

COMMENT ON COLUMN notice.startDate IS '����������';

COMMENT ON COLUMN notice.endDate IS '����������';

COMMENT ON COLUMN notice.writeDate IS '�ۼ���';

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

/* ȸ�� */
CREATE TABLE member (
	id VARCHAR2(20) NOT NULL, /* ���̵� */
	pw VARCHAR2(20) NOT NULL, /* ��й�ȣ */
	name VARCHAR2(30) NOT NULL, /* ���� */
	birthday DATE, /* ���� */
	gender VARCHAR2(6) NOT NULL, /* ���� */
	tel VARCHAR2(13) NOT NULL, /* ����ó */
	email VARCHAR2(50) NOT NULL, /* �̸��� */
	photo VARCHAR2(50), /* ���� */
	grade NUMBER(2) DEFAULT 1, /* ��� */
	state VARCHAR2(6) DEFAULT '�Ϲ�', /* ���� */
	loginDate DATE DEFAULT sysdate, /* �����α��� */
	regDate DATE DEFAULT sysdate, /* ������ */
	message NUMBER DEFAULT 0 /* �޽��� */
);

COMMENT ON TABLE member IS 'ȸ��';

COMMENT ON COLUMN member.id IS '���̵�';

COMMENT ON COLUMN member.pw IS '��й�ȣ';

COMMENT ON COLUMN member.name IS '����';

COMMENT ON COLUMN member.birthday IS '����';

COMMENT ON COLUMN member.gender IS '����';

COMMENT ON COLUMN member.tel IS '����ó';

COMMENT ON COLUMN member.email IS '�̸���';

COMMENT ON COLUMN member.photo IS '����';

COMMENT ON COLUMN member.grade IS '���';

COMMENT ON COLUMN member.state IS '����';

COMMENT ON COLUMN member.loginDate IS '�����α���';

COMMENT ON COLUMN member.regDate IS '������';

COMMENT ON COLUMN member.message IS '�޽���';

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

/* �޽��� */
CREATE TABLE message (
	no NUMBER NOT NULL, /* �޽�����ȣ */
	sender VARCHAR2(20) NOT NULL, /* ������� */
	accepter VARCHAR2(20) NOT NULL, /* �޴»�� */
	sendDate DATE DEFAULT sysdate, /* ������¥ */
	acceptDate DATE, /* ������¥ */
	content VARCHAR2(2000) NOT NULL /* �޽��� */
);

COMMENT ON TABLE message IS '�޽���';

COMMENT ON COLUMN message.no IS '�޽�����ȣ';

COMMENT ON COLUMN message.sender IS '�������';

COMMENT ON COLUMN message.accepter IS '�޴»��';

COMMENT ON COLUMN message.sendDate IS '������¥';

COMMENT ON COLUMN message.acceptDate IS '������¥';

COMMENT ON COLUMN message.content IS '�޽���';

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

/* �̹��� */
CREATE TABLE image (
	no NUMBER NOT NULL, /* �̹�����ȣ */
	title VARCHAR2(300) NOT NULL, /* ���� */
	content VARCHAR2(2000) NOT NULL, /* ���� */
	id VARCHAR2(20) NOT NULL, /* �ۼ��ھ��̵� */
	fileName VARCHAR2(50) NOT NULL, /* ���ϸ� */
	writeDate DATE DEFAULT sysdate, /* ����� */
	hit NUMBER DEFAULT 0 /* ��ȸ�� */
);

COMMENT ON TABLE image IS '�̹���';

COMMENT ON COLUMN image.no IS '�̹�����ȣ';

COMMENT ON COLUMN image.title IS '����';

COMMENT ON COLUMN image.content IS '����';

COMMENT ON COLUMN image.id IS '�ۼ��ھ��̵�';

COMMENT ON COLUMN image.fileName IS '���ϸ�';

COMMENT ON COLUMN image.writeDate IS '�����';

COMMENT ON COLUMN image.hit IS '��ȸ��';

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

/* �����亯 */
CREATE TABLE qna (
	no NUMBER NOT NULL, /* �۹�ȣ */
	title VARCHAR2(300) NOT NULL, /* ���� */
	content VARCHAR2(2000) NOT NULL, /* ���� */
	id VARCHAR2(20) NOT NULL, /* �ۼ���ID */
	writeDate DATE DEFAULT sysdate, /* �ۼ��� */
	hit NUMBER DEFAULT 0, /* ��ȸ�� */
	refNo NUMBER, /* ���ñ۹�ȣ */
	ordNo NUMBER, /* ������ȣ */
	levNo NUMBER, /* �鿩�����ȣ */
	parentNo NUMBER /* �θ�۹�ȣ */
);

COMMENT ON TABLE qna IS '�����亯';

COMMENT ON COLUMN qna.no IS '�۹�ȣ';

COMMENT ON COLUMN qna.title IS '����';

COMMENT ON COLUMN qna.content IS '����';

COMMENT ON COLUMN qna.id IS '�ۼ���ID';

COMMENT ON COLUMN qna.writeDate IS '�ۼ���';

COMMENT ON COLUMN qna.hit IS '��ȸ��';

COMMENT ON COLUMN qna.refNo IS '���ñ۹�ȣ';

COMMENT ON COLUMN qna.ordNo IS '������ȣ';

COMMENT ON COLUMN qna.levNo IS '�鿩�����ȣ';

COMMENT ON COLUMN board2.parentNo IS '�θ�۹�ȣ';

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
        