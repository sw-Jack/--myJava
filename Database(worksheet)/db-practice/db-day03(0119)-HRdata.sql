select * from tab;
desc employees;
select employee_id as �����ȣ, last_name as �̸�, salary*12 as ���� from employees;
select first_name || ' ' || last_name as �̸� from employees;
select employee_id as �����ȣ, last_name || ' ' || first_name as �̸�, salary*12 as ���� from employees
where employee_id = 100;
select distinct department_id from employees;

select last_name || ' ' || first_name as �����, '$' || salary as "��  ��", department_id as �μ��ڵ�
from employees
where salary  <= 2500 or (salary >= 3000 and department_id = 90);
