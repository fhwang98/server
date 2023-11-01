
-- ToyProject > dml.sql

-- 회원

insert into tblUser (id, pw, name, email, lv, pic, intro, ing)
    values('hong', '1111', '홍길동', 'hong@gamil.com', '1', default, '자바를 공부하는 학생입니다', default);
    
select * from tblUser;


UPDATE tblUser SET pic = 'pic.png' WHERE id ='hahaha';

commit;


--게시판
INSERT INTO tblboard (seq, subject, content, regdate, readcount, id)
	VALUES (seqboard.nextVal, '게시판입니다.', '내용입니다.', DEFAULT, DEFAULT, 'hong');

SELECT * FROM tblboard;




SELECT * FROM vwboard;

UPDATE tblboard SET regdate = regdate - 1 WHERE seq <= 2;



COMMIT;