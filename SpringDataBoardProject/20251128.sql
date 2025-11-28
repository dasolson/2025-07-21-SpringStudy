SELECT no FROM recipedetail ORDER BY no;
WHERE no IN(select no FROM recipe INTERSECT SELECT no FROM recipedetail);

SELECT COUNT(*) FROM recipedetail;

DROP TABLE recipedetail;

SELECT CEIL(COUNT(*)/12.0) FROM recipe WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail);

-- DataBoard : 자료실 
CREATE TABLE springDataBoard(
    no NUMBER,
    name VARCHAR2(51) CONSTRAINT sdb_name_nn NOT NULL,
    subject VARCHAR2(2000) CONSTRAINT sdb_sub_nn NOT NULL,
    content CLOB CONSTRAINT sdb_cont_nn NOT NULL,
    pwd VARCHAR2(10) CONSTRAINT sdb_pwd_nn NOT NULL,
    regdate DATE DEFAULT SYSDATE,
    hit NUMBER DEFAULT 0,
    filename VARCHAR2(1000),
    filesize VARCHAR2(500),
    filecount NUMBER,
    CONSTRAINT sdb_no_pk PRIMARY KEY(no)
);

CREATE SEQUENCE sdb_no_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
DESC SpringDataBoard;    

select * from SpringDataBoard;