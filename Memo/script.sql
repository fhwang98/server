-- Memo > script.sql

DROP TABLE tblMemo;
DROP SEQUENCE seqMemo;

CREATE TABLE tblMemo (
	seq NUMBER PRIMARY KEY,				-- 번호
	name varchar2(30) NOT NULL,			-- 이름
	pw varchar2(30) NOT NULL,			-- 암호(메모)
	memo varchar2(2000) NOT NULL,			-- 메모
	regdate DATE DEFAULT sysdate NOT NULL	-- 날짜
	
);

CREATE SEQUENCE seqMemo;

-- 메모 쓰기
INSERT INTO tblMemo (seq, name, pw, memo, regdate)
	VALUES (seqMemo.nextVal, '홍길동', '1111', '메모입니다.', default);

-- 메모 목록
SELECT * FROM tblMemo ORDER BY seq DESC;

-- 메모 읽기
SELECT * FROM tblMemo WHERE seq = 1;

-- 메모 수정
UPDATE tblMemo SET memo = '수정할 내용' WHERE seq = 1;

-- 메모 삭제
DELETE FROM tblMemo WHERE seq = 1;