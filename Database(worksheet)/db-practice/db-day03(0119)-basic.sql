-----------------------------------------------------------------------------------------------------------------
create table professor (
    profno number(5,0) not null,
    name varchar2(10) not null,
    ename varchar2(20) not null,
    position varchar2(20) not null,
    sal number(4,0) not null,
    hiredate date not null,
    age number(3,0) not null,
    deptno number(3,0) not null,
    constraint "professor_pk" primary key (profno)
);

desc professor;
select * from department;
select * from professor;
alter table professor add constraint "professor_fk"
foreign key (deptno)
references department (deptno);

