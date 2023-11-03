
-- system
create user toy identified by oracle;
grant connect, resource, dba to toy;


-- ToyProject > ddl.sql



--회원
create table tblUser(
    id varchar2(50) not null,
    pw varchar2(50) not null,
    name varchar2(50) not null,
    email varchar2(100) not null,
    lv char(1) not null,
    pic varchar2(100) default 'pic.png' not null,
    intro varchar2(500) not null,
    ing char(1) default 'y' not null,
    constraint tbluser_pk primary key(id)
    
);

COMMIT;


-- 게시판
CREATE TABLE tblBoard (
	seq NUMBER NOT NULL,
	subject varchar2(300) NOT NULL,
	content varchar2(4000) NOT NULL,
	regdate DATE DEFAULT sysdate NOT NULL,
	readcount NUMBER DEFAULT 0 NOT NULL,
	id varchar2(50) NOT NULL,
	
	CONSTRAINT tblboard_pk PRIMARY key(seq),
	CONSTRAINT tblboard_fk FOREIGN key(id) REFERENCES tblUser(id)
	
);

CREATE SEQUENCE seqBoard;
drop SEQUENCE seqBoard;


CREATE OR REPLACE VIEW vwBoard
AS
SELECT
	seq, subject, id, readcount, content,
	CASE
		WHEN to_char(sysdate, 'YYYY-MM-DD') = to_char(regdate, 'YYYY-MM-DD') 
				THEN to_char(regdate, 'hh24:mi:ss')
		ELSE to_char(regdate, 'YYYY-MM-DD')
	END AS regdate,
	(SELECT name FROM tbluser WHERE id = tblboard.id) AS name,
	CASE
		WHEN (sysdate - regdate) < 30 / 24 / 60 THEN 1
		ELSE 0
	END AS isnew,
	(SELECT count(*) FROM tblcomment WHERE bseq = tblBoard.seq) AS ccnt
FROM tblboard ORDER BY seq DESC;


SELECT * FROM vwboard;




--댓글 테이블
CREATE TABLE tblComment (
	seq NUMBER NOT NULL,
	content varchar2(1000) NOT NULL,
	regdate DATE DEFAULT sysdate NOT NULL,
	id varchar2(50) NOT NULL, -- 글쓴이
	bseq NUMBER NOT NULL, -- 부모 글번호
	
	CONSTRAINT tblcomment_pk PRIMARY KEY(seq),
	CONSTRAINT tblboard_fk_id FOREIGN key(id) REFERENCES tblUser(id),
	CONSTRAINT tblboard_fk_bseq FOREIGN key(bseq) REFERENCES tblBoard(seq)
);


CREATE SEQUENCE seqComment;















