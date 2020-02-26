drop table boardFile;

-- ���� ���ε� ���� ���̺� ����
CREATE TABLE boardFile
(
    FILE_NO NUMBER PRIMARY KEY,                         --���� ��ȣ
    NO NUMBER not null,                    --�Խ��� ��ȣ
    ORG_FILE_NAME VARCHAR2(260) NOT NULL,   --���� ���� �̸�
    STORED_FILE_NAME VARCHAR2(36) NOT NULL, --����� ���� �̸�
    FILE_SIZE NUMBER,                       --���� ũ��
    REGDATE DATE DEFAULT SYSDATE NOT NULL,  --���ϵ����
    DEL_GB VARCHAR2(1) DEFAULT 'N' NOT NULL--��������
);
COMMIT;
--�ڵ� �� ����
drop sequence boardfile_seq;
create sequence boardFile_seq;

--insert test
insert into boardFile (file_no, NO, ORG_FILE_NAME, STORED_FILE_NAME, FILE_SIZE, DEL_GB) 
values(boardFile_seq.nextval, 607, 'files', 'files', 30, 'N');
select * from boardFile;