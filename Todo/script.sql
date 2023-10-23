-- todo > script.sql

-- 할일 테이블
DROP TABLE tblTodo;
DROP SEQUENCE seqTodo

CREATE TABLE tblTodo (
	seq number PRIMARY KEY,
	todo varchar2(1000) NOT NULL,			-- 할일
	state char(1) DEFAULT 'n' NOT NULL,		-- 미완료(n), 완료(y)
	regdate date DEFAULT sysdate NOT NULL	-- 날짜
);

CREATE SEQUENCE seqTodo;

INSERT INTO tblTodo (seq, todo, state, regdate)
	VALUES (seqTodo.nextVal, '할일입니다.', DEFAULT, DEFAULT);

SELECT * FROM tblTodo;

SELECT * FROM tblTodo order by seq DESC;

SELECT * FROM tblTodo ORDER BY state, seq DESC;

UPDATE tbltodo SET state = 'y' WHERE seq = 6;

DELETE FROM tbltodo WHERE seq = 1;


COMMIT;
