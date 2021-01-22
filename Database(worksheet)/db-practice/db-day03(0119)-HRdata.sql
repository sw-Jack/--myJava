select * from tab;
desc employees;
select employee_id as 사원번호, last_name as 이름, salary*12 as 연봉 from employees;
select first_name || ' ' || last_name as 이름 from employees;
select employee_id as 사원번호, last_name || ' ' || first_name as 이름, salary*12 as 연봉 from employees
where employee_id = 100;
select distinct department_id from employees;

select last_name || ' ' || first_name as 사원명, '$' || salary as "월  급", department_id as 부서코드
from employees
where salary  <= 2500 or (salary >= 3000 and department_id = 90);
