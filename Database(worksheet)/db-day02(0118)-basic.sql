create table department(
    deptno number(3,0) not null,
    dname varchar2(30) not null,
    college number(3,0) not null,
    loc varchar2(10) not null,
    constraint department_pk primary key (deptno)
);
-----------------------------------------------------------------------------------------------------------------
select * from tab;
desc department;
select * from department;
-----------------------------------------------------------------------------------------------------------------
insert into department values(256, '��ǻ�Ͱ��а�', 300, '7ȣ��');