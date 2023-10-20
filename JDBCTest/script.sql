-- hr

SELECT * FROM tblAdress;
DROP TABLE tblAddress;

CREATE TABLE tblAddress (
	seq NUMBER PRIMARY KEY,
	name varchar2(30) NOT NULL,
	age NUMBER NOT NULL,
	gender char(1) NOT NULL,
	address varchar2(300) NOT NULL,
	regdate DATE DEFAULT sysdate NOT null
);

CREATE SEQUENCE seqAddress ;
DROP SEQUENCE seqAddress;

INSERT INTO tblAddress (seq, name, age, gender, address, regdate)
	VALUES (seqAddress.nextVal, '홍길동', 20, 'm', '서울시 강남구 역삼동', default);
	
SELECT * FROM tblAddress;


COMMIT;


--INSERT INTO tblAddress (seq, name, age, gender, address, regdate)
--	VALUES (seqAddress.nextVal, '하하하', 20, 'm', '서울시 강남구 역삼동 's 아파트', default);
INSERT INTO tblAddress (seq, name, age, gender, address, regdate)
	VALUES (seqAddress.nextVal, '하하하', 20, 'm', '서울시 강남구 역삼동 ''s 아파트', default);



--Ex05.java

--m1. 인자값(X), 반환값(X)
CREATE OR REPLACE PROCEDURE procM1
IS
BEGIN
	UPDATE tblAddress SET age = age + 1;
END procM1;

-- m2. 인자값(O), 반환값(X)
SELECT * FROM tblAddress;

CREATE OR REPLACE PROCEDURE procM2 (
	pname		tblAddress.name%TYPE,
	page		tblAddress.age%TYPE,
	pgender		tblAddress.gender%TYPE,
	paddress	tblAddress.address%TYPE
)
IS
BEGIN
	INSERT INTO tblAddress
		VALUES (seqAddress.nextVal, pname, page, pgender, paddress, default);
END procM2;


-- m3 인자값(X), 반환값(O)
CREATE OR REPLACE PROCEDURE procM3 (
	pcnt OUT NUMBER
)
IS
BEGIN
	SELECT count(*) INTO pcnt FROM tblAddress;	
END procM3;


-- m4 인자값(X), 반환값(O)여러개
CREATE OR REPLACE PROCEDURE procM4 (
	pname OUT varchar2,
	page OUT NUMBER,
	paddress OUT varchar2	
)
IS
BEGIN
	SELECT name, age, address INTO pname, page, paddress FROM tblAddress
		WHERE rownum = 1;
END procM4;


-- m5 인자값(X), 반환값(O) 레코드가 여러개
CREATE OR REPLACE PROCEDURE procM5 (
	pcursor OUT sys_refcursor
)
IS
BEGIN
	OPEN pcursor
	FOR
		SELECT * FROM tblAddress;
END procM5;


