-----------------------------------------------------------------------------------------------------------------
create table mytable(
    num number(5, 0) primary key, --주석 : number(전체자리수, 소수점자리수)
    name varchar2(15) not null, --varchar2 형은 쓰고 남는 부분을 반납함
    age number(3) default 0, --데이터 입력하지 않으면 default 값 0으로 처리
    address varchar2(15),
    birth date default sysdate --아무것도 안쓰면 sysdate : 오늘 날짜
);
-----------------------------------------------------------------------------------------------------------------
select * from tab; --테이블 목록 확인
desc mytable; --테이블 형식 확인
desc mytable;
---------------------------------------------------------------------------------------------------------------
insert into mytable values(1, '손흥민', 30, 'London/UK', '1992-01-15');
insert into mytable values(3, '박주호', 34, 'Ulsan/Korea', '1988-12-04');
select * from mytable;
insert into mytable(name, num, age, address) values('황희찬', 4, 26, 'Leipz/Germany');
insert into mytable(name, num) values('이강인', 2);
update mytable set address = 'Balencia/Spain' where name = '이강인';
-----------------------------------------------------------------------------------------------------------------
-- insert/update/delete 하는 데이터들은 기본적으로 log file에 저장
commit; --commit을 해야 log file에 저장된 데이터가 data file에 실질적으로 저장, 실질적인 데이터 저장소는 data file
        --commit 하면 log file에서는 사라짐

delete from mytable; --테이블 내의 데이터만 삭제
rollback; --commit 이전 시점까지 되돌리기 




