drop table boardFile;

-- 파일 업로드 위한 테이블 생성
CREATE TABLE boardFile
(
    FILE_NO NUMBER PRIMARY KEY,                         --파일 번호
    NO NUMBER not null,                    --게시판 번호
    ORG_FILE_NAME VARCHAR2(260) NOT NULL,   --원본 파일 이름
    STORED_FILE_NAME VARCHAR2(36) NOT NULL, --변경된 파일 이름
    FILE_SIZE NUMBER,                       --파일 크기
    REGDATE DATE DEFAULT SYSDATE NOT NULL,  --파일등록일
    DEL_GB VARCHAR2(1) DEFAULT 'N' NOT NULL--삭제구분
);
COMMIT;
--자동 수 증가
drop sequence boardfile_seq;
create sequence boardFile_seq;

--insert test
insert into boardFile (file_no, NO, ORG_FILE_NAME, STORED_FILE_NAME, FILE_SIZE, DEL_GB) 
values(boardFile_seq.nextval, 607, 'files', 'files', 30, 'N');
select * from boardFile;