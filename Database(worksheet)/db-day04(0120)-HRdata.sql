desc employees;
select * from employees;
-----------------------------------------------------------------------------------------------------------------------------
select * from employees where last_name = 'King';
-----------------------------------------------------------------------------------------------------------------------------
select first_name as �̸�, job_id as ����ID, department_id as �μ�ID
from employees
where job_id like '%MAN%';
-----------------------------------------------------------------------------------------------------------------------------
select first_name as �̸�, job_id as ����ID, department_id as �μ�ID
from employees
where job_id like 'IT%';
-----------------------------------------------------------------------------------------------------------------------------
select last_name, salary, commission_pct 
from employees
where commission_pct is not null;
-----------------------------------------------------------------------------------------------------------------------------
select last_name, salary, commission_pct 
from employees
where commission_pct is null;
-----------------------------------------------------------------------------------------------------------------------------
select employee_id, last_name, job_id 
from employees
where job_id in ('FI_MGR', 'FI_ACCOUNT');
-----------------------------------------------------------------------------------------------------------------------------
select employee_id, last_name, salary
from employees
where salary between 10000 and 20000;
----------------------------------------------------------------------------------------------------------------------------
select first_name as �̸�, job_id as ����ID, salary as �޿� 
from employees
where job_id = 'SA_REP' or job_id = 'AD_PRES';
-----------------------------------------------------------------------------------------------------------------------------
select distinct job_id 
from  employees;
-----------------------------------------------------------------------------------------------------------------------------
select employee_id as �����ȣ, first_name as �̸�, hire_date as �Ի���
from employees
where hire_date between '2005-01-01' and '2005-12-31';
-----------------------------------------------------------------------------------------------------------------------------
select last_name, department_id, hire_date
from employees
order by 2 desc;
-----------------------------------------------------------------------------------------------------------------------------
select last_name, department_id, hire_date
from employees
order by last_name, department_id desc;
-----------------------------------------------------------------------------------------------------------------------------
select salary*12 as ���� 
from employees
order by ���� desc;
-----------------------------------------------------------------------------------------------------------------------------
select employee_id, first_name, department_id 
from employees
where lower(last_name) = 'kochhar';
-----------------------------------------------------------------------------------------------------------------------------
select mod(10,3) from dual;
-----------------------------------------------------------------------------------------------------------------------------
select concat('hello', 'World') from dual;
-----------------------------------------------------------------------------------------------------------------------------
select length('korea') from dual;
select length('�ڸ���') from dual;
select lengthb('korea') from dual;
select lengthb('�ڸ���') from dual;
-----------------------------------------------------------------------------------------------------------------------------
select instr('helloWorld', 'W') from dual;
select instr('helloWorld', 'o', -5) from dual;
-----------------------------------------------------------------------------------------------------------------------------
select substr('I am very happy', 6, 4) from dual;
select substr('I am very happy', 6) from dual;
-----------------------------------------------------------------------------------------------------------------------------
select width_bucket(74, 0, 100, 10) from dual; -- 0~100������ ������ 10���� �������� ������ 74�� � ������ ���ԵǴ��� 
-----------------------------------------------------------------------------------------------------------------------------
select 'test   ' || 'exam' from dual
union --������
select rtrim('test   ') || 'exam' from dual;
-----------------------------------------------------------------------------------------------------------------------------
select '   test' || 'exam' from dual
union
select ltrim('   test') || 'exam' from dual;
-----------------------------------------------------------------------------------------------------------------------------
select to_char(sysdate, 'YYYY"��" MM"��" DD"��"') as ���ó�¥ from dual;
select to_char(sysdate, 'HH"��" MI"��" SS"��"') as ���ó�¥ from dual;
select to_char(sysdate, 'HH24"��" MI"��" SS"��"') as ���ó�¥ from dual;
-----------------------------------------------------------------------------------------------------------------------------
select add_months(sysdate, 7) from dual; --add_months(date, �޼�) : ��¥(date)�� �޼� ���ϱ�
-----------------------------------------------------------------------------------------------------------------------------
select last_day(sysdate) from dual; -- �ش� ���� ������ ��
select last_day('2002-02-02') from dual; 
-----------------------------------------------------------------------------------------------------------------------------
select round(months_between('94-12-31', sysdate), 0) from dual; --months_between(date1, date2) : �� ��¥ ������ �޼�
-----------------------------------------------------------------------------------------------------------------------------
select to_char(to_date('1997-09-30', 'YY-MM-DD'), 'YYYY-MON-DD') from dual;
select to_char(to_date('1997-09-30', 'RR-MM-DD'), 'RRRR-MON-DD') from dual;
select to_char(to_date('1997-09-30', 'YY-MM-DD'), 'YYYY-MON-DD') from dual;
select to_char(to_date('1997-09-30', 'RR-MM-DD'), 'RRRR-MON-DD') from dual;
----------------------------------------------------------------------------------------------------------------------------
select last_name, hire_date
from employees
where hire_date < '2003-01-01';
-----------------------------------------------------------------------------------------------------------------------------
select max(salary), min(salary), trunc(avg(salary), 0), to_char(sum(salary), 'L9,999,999')
from employees;
-----------------------------------------------------------------------------------------------------------------------------
select department_id from employees;
select count(department_id) from employees; --null�� ���� ī��Ʈ
select count(distinct department_id) from employees; --�ߺ� �� ���� ī��Ʈ
select count(distinct nvl(department_id, 0)) from employees;
select distinct nvl(department_id, 0) from employees; 
select nvl(department_id ,0) from employees; --department_id ���� null�̸� 0���� ä�� ���
-----------------------------------------------------------------------------------------------------------------------------
select job_id, decode(job_id, 'SA_MAN', 'Sales_Dept', 'SA_REP', 'Sales Dept', 'Another') as �з�
from employees; --job_id�� SA_MAN �̸� Sales_Dept, SA_REP �̸� Sales, �� �ܴ̿� Another�� �з� �ʵ� ���
select job_id, case job_id --job_id��
                when 'SA_MAN' then 'Sales_Dept' --SA_MAN �̸� Sales_Dept
                when 'SA_REP' then 'Sales_Dept' --SA_REP �̸� Sales_Dept
                else 'Another' --�� �ܴ̿� Another��
                end �з� --�з�
from employees 
order by 1;
-----------------------------------------------------------------------------------------------------------------------------
desc employees;
select employee_id as �����ȣ, last_name as ����̸�,
                    case when salary < 10000 then '�ʱ�'
                         when salary < 20000 then '�߱�'
                         else '���' 
                         end ����
from employees
order by ����, first_name;


























