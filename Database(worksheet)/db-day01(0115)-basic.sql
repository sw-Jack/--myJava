-----------------------------------------------------------------------------------------------------------------
create table mytable(
    num number(5, 0) primary key, --�ּ� : number(��ü�ڸ���, �Ҽ����ڸ���)
    name varchar2(15) not null, --varchar2 ���� ���� ���� �κ��� �ݳ���
    age number(3) default 0, --������ �Է����� ������ default �� 0���� ó��
    address varchar2(15),
    birth date default sysdate --�ƹ��͵� �Ⱦ��� sysdate : ���� ��¥
);
-----------------------------------------------------------------------------------------------------------------
select * from tab; --���̺� ��� Ȯ��
desc mytable; --���̺� ���� Ȯ��
desc mytable;
---------------------------------------------------------------------------------------------------------------
insert into mytable values(1, '�����', 30, 'London/UK', '1992-01-15');
insert into mytable values(3, '����ȣ', 34, 'Ulsan/Korea', '1988-12-04');
select * from mytable;
insert into mytable(name, num, age, address) values('Ȳ����', 4, 26, 'Leipz/Germany');
insert into mytable(name, num) values('�̰���', 2);
update mytable set address = 'Balencia/Spain' where name = '�̰���';
-----------------------------------------------------------------------------------------------------------------
-- insert/update/delete �ϴ� �����͵��� �⺻������ log file�� ����
commit; --commit�� �ؾ� log file�� ����� �����Ͱ� data file�� ���������� ����, �������� ������ ����Ҵ� data file
        --commit �ϸ� log file������ �����

delete from mytable; --���̺� ���� �����͸� ����
rollback; --commit ���� �������� �ǵ����� 




