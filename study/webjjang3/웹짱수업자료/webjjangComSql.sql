/* ������ ���� */
 DROP SEQUENCE board_seq;
 DROP SEQUENCE image_seq;
 DROP SEQUENCE message_seq;
 DROP SEQUENCE notice_seq;
 DROP SEQUENCE qna_seq;
 
/* ������ ���� */
 CREATE SEQUENCE board_seq;
 CREATE SEQUENCE image_seq;
 CREATE SEQUENCE message_seq;
 CREATE SEQUENCE notice_seq;
 CREATE SEQUENCE qna_seq;
 

/* ���õ����� �Է� */
/** ȸ�� **/

INSERT INTO member(id, pw, name, birthday, gender, tel, email)
VALUES('jjang', '1111', '�̿�ȯ', '1967-01-01', '����', '010-6324-5873', 'leelj1@nate.com');

INSERT INTO member(id, pw, name, birthday, gender, tel, email)
VALUES('angel', '1111', '������', '1970-09-01', '����', '010-1111-1111', 'angel@nate.com');

/* �̹��� �Խ��� */
INSERT INTO image(no, title, content, id, fileName)
VALUES(image_seq.nextval, '�Ϳ��� ������', '�Ϳ��� �������Դϴ�.', 'jjang', 'dog01.jpg');


/* ��� ���� */
commit;
