CREATE TABLE springBoard(
    no NUMBER,
    name VARCHAR2(51) CONSTRAINT sb_name_nn NOT NULL,
    subject VARCHAR2(2000) CONSTRAINT sb_sub_nn NOT NULL,
    content CLOB CONSTRAINT sb_cont_nn NOT NULL,
    pwd VARCHAR2(10) CONSTRAINT sb_pwd_nn NOT NULL,
    regdate DATE DEFAULT SYSDATE,
    hit NUMBER DEFAULT 0,
    CONSTRAINT sb_no_pk PRIMARY KEY(no)
);

CREATE SEQUENCE sb_no_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
DESC springBoard;    

INSERT INTO springBoard(no, name, subject, content, pwd)
VALUES(sb_no_seq.nextval, '홍길동', 'spring 사용법',
'spring 사용법 요청 / 응답', '1234');

COMMIT;

SELECT * FROM springBoard;