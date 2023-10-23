-- AuthTest > script.sql

DROP TABLE tblUser;

SELECT * FROM tblUser;

CREATE TABLE tblUser (
	id varchar2(30) PRIMARY KEY, -- 아이디(PK)
	pw varchar2(30) NOT NULL,	 -- 암호
	name varchar2(30) NOT NULL,	 -- 이름
	lv number(1) NOT NULL		 -- 등급(1 일반, 2 관리자)
	
);

INSERT INTO tblUser VALUES ('hong', '1111', '홍길동', 1);
INSERT INTO tblUser VALUES ('test', '1111', '테스트', 1);
INSERT INTO tblUser VALUES ('admin', '1111', '관리자', 2);

COMMIT;

SELECT * FROM tblUser WHERE id = '' AND pw = '';

SELECT * FROM ALL_tables WHERE owner='hr';

SELECT * FROM all_users;