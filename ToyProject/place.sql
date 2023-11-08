delete from tblPlace;

insert into tblPlace values (seqPlace.nextVal, 37.49946254149899, 127.03350821415333, '스타벅스 역삼포스코점', 'cafe');
insert into tblPlace values (seqPlace.nextVal, 37.5000214774923, 127.03238887639358, '블루보틀 역삼 카페', 'cafe');
insert into tblPlace values (seqPlace.nextVal, 37.4999672212306, 127.03309566275318, '할리스 역삼 테헤란점', 'cafe');
insert into tblPlace values (seqPlace.nextVal, 37.49971222207651, 127.03471555274336, '스타벅스 아크플레이스점', 'cafe');
insert into tblPlace values (seqPlace.nextVal, 37.49960495388392, 127.0316818901042, '스타벅스 국기원사거리점', 'cafe');
insert into tblPlace values (seqPlace.nextVal, 37.49909547011733, 127.03319423022872, '해머스미스 커피', 'cafe');
insert into tblPlace values (seqPlace.nextVal, 37.500404087936744, 127.03352559842763, '요술포차', 'food');
insert into tblPlace values (seqPlace.nextVal, 37.49817406332744, 127.03364616982121, '을밀대컵냉면', 'food');
insert into tblPlace values (seqPlace.nextVal, 37.49810897418154, 127.03281495289778, '우밀가 안동국시', 'food');
insert into tblPlace values (seqPlace.nextVal, 37.49963755476663, 127.03583509996064, '바스버거 역삼점', 'food');
insert into tblPlace values (seqPlace.nextVal, 37.50112907045147, 127.03465966304452, '호타루', 'food');
insert into tblPlace values (seqPlace.nextVal, 37.50108394690212, 127.03490844293854, '나주 곰탕', 'food');
insert into tblPlace values (seqPlace.nextVal, 37.499977809864845, 127.03541965834984, '신한은행 강남중앙점', 'private');
insert into tblPlace values (seqPlace.nextVal, 37.49925092460049, 127.0330840377675, 'IBK 기업은행 테헤란로지점', 'private');
insert into tblPlace values (seqPlace.nextVal, 37.49973763498563, 127.032482052401, 'GS25 강남N타워점', 'private');
insert into tblPlace values (seqPlace.nextVal, 37.50009046016296, 127.03533772148997, '역삼역 3번출구', 'default');
insert into tblPlace values (seqPlace.nextVal, 37.49809426246327, 127.02876361388746, '강남역 1번출구', 'default');
insert into tblPlace values (seqPlace.nextVal, 37.49839584023911, 127.02980978614593, '삼성서초역삼세무서', 'default');

select * from tblPlace;

commit;