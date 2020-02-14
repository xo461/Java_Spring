/* 시퀀스 제거 */
 DROP SEQUENCE board_seq;
 DROP SEQUENCE image_seq;
 DROP SEQUENCE message_seq;
 DROP SEQUENCE notice_seq;
 DROP SEQUENCE qna_seq;
 
/* 시퀀스 생성 */
 CREATE SEQUENCE board_seq;
 CREATE SEQUENCE image_seq;
 CREATE SEQUENCE message_seq;
 CREATE SEQUENCE notice_seq;
 CREATE SEQUENCE qna_seq;
 

/* 샘플데이터 입력 */
/** 회원 **/

INSERT INTO member(id, pw, name, birthday, gender, tel, email)
VALUES('jjang', '1111', '이영환', '1967-01-01', '남자', '010-6324-5873', 'leelj1@nate.com');

INSERT INTO member(id, pw, name, birthday, gender, tel, email)
VALUES('angel', '1111', '김혜수', '1970-09-01', '여자', '010-1111-1111', 'angel@nate.com');

/* 이미지 게시판 */
INSERT INTO image(no, title, content, id, fileName)
VALUES(image_seq.nextval, '귀여운 강아지', '귀여운 강아지입니다.', 'jjang', 'dog01.jpg');


/* 결과 적용 */
commit;
