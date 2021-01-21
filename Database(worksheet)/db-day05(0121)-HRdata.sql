-----------------------------------------------------------------------------------------------------------------------------
--rank(ǥ����) within group(order by ǥ����)
select rank(3000) within group(order by salary desc) rank 
from employees; --�޿��� 3000�� ����� ���� �޿�����
-----------------------------------------------------------------------------------------------------------------------------
--rank() over(������Ƽ��) : ��ü ����
select employee_id �����ȣ, to_char(salary*12*1250, 'L999,999,999') ����, rank() over(order by salary desc) as ��������
from employees;
-----------------------------------------------------------------------------------------------------------------------------
--��ü ����� �޿��� �� �μ��� �ְ� �޿�
select  department_id �μ�ID, employee_id �����ȣ, to_char(salary*12*1250, 'L999,999,999') ����, 
first_value(to_char(salary*12*1250, 'L999,999,999')) over(partition by department_id order by to_char(salary*12*1250, 'L999,999,999') desc) �ֻ�������
from employees;
-----------------------------------------------------------------------------------------------------------------------------
--Quiz 7
desc employees;
select employee_id as �����ȣ, last_name as �̸�, salary as �޿�, commission_pct as Ŀ�̼�, 
       to_char(salary*12 + (salary*12*(nvl(commission_pct,0))), '$999,999,999') as ����
from employees;
-----------------------------------------------------------------------------------------------------------------------------
--�Ŵ����� ���� ����� �Ŵ���ID�� null�� ��� 1000���� ǥ��
select employee_id as �����ȣ, last_name as �̸�, nvl(manager_id, 1000) as �Ŵ���ID
from employees;
-----------------------------------------------------------------------------------------------------------------------------
select to_char(trunc(avg(salary), 0), '9,999') as "�޿� ���"
from employees;
-----------------------------------------------------------------------------------------------------------------------------
select nvl(department_id, 0900) as �μ��ڵ�, to_char(round(avg(salary), 0), 'L999,999,999') as "��� �޿�"
from employees
group by department_id 
having avg(salary) >= 5000
order by department_id;
-----------------------------------------------------------------------------------------------------------------------------
select department_id as �μ��ڵ�, to_char(round(avg(salary), 0), 'L999,999,999') as "�޿� ���"
from employees
group by department_id 
order by department_id;
-----------------------------------------------------------------------------------------------------------------------------
desc employee;
select job_id as ����ID, to_char(sum(salary), 'L999,999') as "�޿� �հ�"
from employees
group by job_id
order by sum(salary) desc;
-----------------------------------------------------------------------------------------------------------------------------
select department_id as "�μ� �ڵ�", max(salary) as "�ִ� �޿�"
from employees
where department_id in (10, 20)
group by department_id
order by max(salary);
-----------------------------------------------------------------------------------------------------------------------------
--<inner join>
desc employees;
desc departments;
--Oracle version1
select employee_id, employees.department_id, department_name
from employees, departments
where employees.department_id = departments.department_id;
--Oracle version2
select e.employee_id, e.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id;
--ANSI ǥ��
select employee_id, department_id, department_name
from employees join departments using(department_id);
-----------------------------------------------------------------------------------------------------------------------------
desc departments;
desc Locations;
--Oracle
select department_id, city
from departments d, Locations l
where d.location_id = l.location_id;
--ANSI ǥ��
select d.department_id, l.city
from departments d join Locations l using(location_id);
-----------------------------------------------------------------------------------------------------------------------------
--<outer join>
--left outer join
--Oracle
select e.last_name, d.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id(+);
--ANSI ǥ��
select last_name, department_id, department_name
from employees left join departments using(department_id);
--(right outer join)
--Oracle
select e.last_name, d.department_id, d.department_name
from employees e, departments d
where e.department_id(+) = d.department_id;
--ANSI ǥ��
select last_name, department_id, department_name
from employees right join departments using(department_id);
-----------------------------------------------------------------------------------------------------------------------------
--<full join>
--ANSI ǥ�� -> Oracle ������ ����
select last_name, department_id, department_name
from employees full join departments using(department_id);
-----------------------------------------------------------------------------------------------------------------------------


