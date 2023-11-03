
-- ToyProject > dml.sql

-- 회원

insert into tblUser (id, pw, name, email, lv, pic, intro, ing)
    values('hong', '1111', '홍길동', 'hong@gamil.com', '1', default, '자바를 공부하는 학생입니다', default);
    
select * from tblUser;

UPDATE tblUser SET lv = 2 WHERE id = 'admin';

UPDATE tblUser SET pic = 'pic.png' WHERE id ='hahaha';

commit;


--게시판
INSERT INTO tblboard (seq, subject, content, regdate, readcount, id)
	VALUES (seqboard.nextVal, '게시판입니다.', '내용입니다.', DEFAULT, DEFAULT, 'hong');

SELECT * FROM tblboard;

UPDATE tblboard SET regdate = regdate - 1 WHERE seq <= 2;



SELECT * FROM vwboard; -- 목록보기

SELECT * FROM vwboard WHERE subject LIKE '%게시판%'; -- 검색하기

SELECT * FROM vwboard WHERE content LIKE '%게시판%'; -- 검색하기





COMMIT;




-- 페이징 > rownum 활용

SELECT * FROM (SELECT a.*, rownum AS rnum FROM vwBoard a) WHERE rnum BETWEEN 1 AND 10;
SELECT * FROM (SELECT a.*, rownum AS rnum FROM vwBoard a) WHERE rnum BETWEEN 11 AND 20;






-- 댓글
SELECT * FROM tblcomment;

INSERT INTO tblcomment (seq, content, regdate, id, bseq) VALUES (seqComment.nextVal, ?, DEFAULT, ?, ?);



