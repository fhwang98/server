
-- 고양이 좌표
CREATE TABLE tblCat (
	
	seq NUMBER PRIMARY KEY,
	catid varchar2(50) NOT NULL,
	x NUMBER NOT NULL,
	y NUMBER NOT NULL

);

INSERT INTO tblCat VALUES (1, 'cat1', 0, 0);
INSERT INTO tblCat VALUES (2, 'cat2', 0, 0);
INSERT INTO tblCat VALUES (3, 'cat3', 0, 0);
INSERT INTO tblCat VALUES (4, 'cat4', 0, 0);
INSERT INTO tblCat VALUES (5, 'cat5', 0, 0);

SELECT * FROM tblCat;

COMMIT;





-- Ex08 예제

SELECT * FROM tbladdress;
