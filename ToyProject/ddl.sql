
-- system
create user toy identified by oracle;
grant connect, resource, dba to toy;


-- ToyProject > ddl.sql

-- 게시판

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
















