-----------------------------------------------------------------------------------------------------------------------------
--rank(표현식) within group(order by 표현식)
select rank(3000) within group(order by salary desc) rank 
from employees; --급여가 3000인 사람의 상위 급여순위
-----------------------------------------------------------------------------------------------------------------------------
--rank() over(쿼리파티션) : 전체 순위
select employee_id 사원번호, to_char(salary*12*1250, 'L999,999,999') 연봉, rank() over(order by salary desc) as 연봉순위
from employees;
-----------------------------------------------------------------------------------------------------------------------------
--전체 사원의 급여와 각 부서의 최고 급여
select  department_id 부서ID, employee_id 사원번호, to_char(salary*12*1250, 'L999,999,999') 연봉, 
first_value(to_char(salary*12*1250, 'L999,999,999')) over(partition by department_id order by to_char(salary*12*1250, 'L999,999,999') desc) 최상위연봉
from employees;
-----------------------------------------------------------------------------------------------------------------------------
--Quiz 7
desc employees;
select employee_id as 사원번호, last_name as 이름, salary as 급여, commission_pct as 커미션, 
       to_char(salary*12 + (salary*12*(nvl(commission_pct,0))), '$999,999,999') as 연봉
from employees;
-----------------------------------------------------------------------------------------------------------------------------
--매니저가 없는 사원의 매니저ID를 null값 대신 1000번을 표시
select employee_id as 사원번호, last_name as 이름, nvl(manager_id, 1000) as 매니저ID
from employees;
-----------------------------------------------------------------------------------------------------------------------------
select to_char(trunc(avg(salary), 0), '9,999') as "급여 평균"
from employees;
-----------------------------------------------------------------------------------------------------------------------------
select nvl(department_id, 0900) as 부서코드, to_char(round(avg(salary), 0), 'L999,999,999') as "평균 급여"
from employees
group by department_id 
having avg(salary) >= 5000
order by department_id;
-----------------------------------------------------------------------------------------------------------------------------
select department_id as 부서코드, to_char(round(avg(salary), 0), 'L999,999,999') as "급여 평균"
from employees
group by department_id 
order by department_id;
-----------------------------------------------------------------------------------------------------------------------------
desc employee;
select job_id as 업무ID, to_char(sum(salary), 'L999,999') as "급여 합계"
from employees
group by job_id
order by sum(salary) desc;
-----------------------------------------------------------------------------------------------------------------------------
select department_id as "부서 코드", max(salary) as "최대 급여"
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
--ANSI 표준
select employee_id, department_id, department_name
from employees join departments using(department_id);
-----------------------------------------------------------------------------------------------------------------------------
desc departments;
desc Locations;
--Oracle
select department_id, city
from departments d, Locations l
where d.location_id = l.location_id;
--ANSI 표준
select d.department_id, l.city
from departments d join Locations l using(location_id);
-----------------------------------------------------------------------------------------------------------------------------
--<outer join>
--left outer join
--Oracle
select e.last_name, d.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id(+);
--ANSI 표준
select last_name, department_id, department_name
from employees left join departments using(department_id);
--(right outer join)
--Oracle
select e.last_name, d.department_id, d.department_name
from employees e, departments d
where e.department_id(+) = d.department_id;
--ANSI 표준
select last_name, department_id, department_name
from employees right join departments using(department_id);
-----------------------------------------------------------------------------------------------------------------------------
--<full join>
--ANSI 표준 -> Oracle 버전은 없음
select last_name, department_id, department_name
from employees full join departments using(department_id);
-----------------------------------------------------------------------------------------------------------------------------


