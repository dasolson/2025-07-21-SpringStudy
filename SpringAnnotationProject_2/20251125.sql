SELECT * FROM dept ORDER BY deptno;
-- List
SELECT * FROM dept WHERE deptno=10;
-- DeptVO           매개변수 int deptno
SELECT loc FROM dept WHERE deptno=10;
-- String
SELECT loc FROM dept;
-- List<String>
SELECT deptno FROM dept;
-- List<Integer>


DROP TABLE student;

CREATE TABLE student(
    hakbun NUMBER,
    name VARCHAR2(50) CONSTRAINT std_name_nn NOT NULL,
    kor NUMBER(3),
    eng NUMBER(3),
    math NUMBER(3),
    CONSTRAINT std_bun_pk PRIMARY KEY(hakbun)
);