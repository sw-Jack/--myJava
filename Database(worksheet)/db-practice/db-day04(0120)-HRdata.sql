desc employees;
select * from employees;
-----------------------------------------------------------------------------------------------------------------------------
select * from employees where last_name = 'King';
-----------------------------------------------------------------------------------------------------------------------------
select first_name as 이름, job_id as 업무ID, department_id as 부서ID
from employees
where job_id like '%MAN%';
-----------------------------------------------------------------------------------------------------------------------------
select first_name as 이름, job_id as 업무ID, department_id as 부서ID
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
select first_name as 이름, job_id as 업무ID, salary as 급여 
from employees
where job_id = 'SA_REP' or job_id = 'AD_PRES';
-----------------------------------------------------------------------------------------------------------------------------
select distinct job_id 
from  employees;
-----------------------------------------------------------------------------------------------------------------------------
select employee_id as 사원번호, first_name as 이름, hire_date as 입사일
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
select salary*12 as 연봉 
from employees
order by 연봉 desc;
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
select length('코리아') from dual;
select lengthb('korea') from dual;
select lengthb('코리아') from dual;
-----------------------------------------------------------------------------------------------------------------------------
select instr('helloWorld', 'W') from dual;
select instr('helloWorld', 'o', -5) from dual;
-----------------------------------------------------------------------------------------------------------------------------
select substr('I am very happy', 6, 4) from dual;
select substr('I am very happy', 6) from dual;
-----------------------------------------------------------------------------------------------------------------------------
select width_bucket(74, 0, 100, 10) from dual; -- 0~100까지의 범위를 10개의 구간으로 나누고 74가 어떤 구간에 포함되는지 
-----------------------------------------------------------------------------------------------------------------------------
select 'test   ' || 'exam' from dual
union --합집합
select rtrim('test   ') || 'exam' from dual;
-----------------------------------------------------------------------------------------------------------------------------
select '   test' || 'exam' from dual
union
select ltrim('   test') || 'exam' from dual;
-----------------------------------------------------------------------------------------------------------------------------
select to_char(sysdate, 'YYYY"년" MM"월" DD"일"') as 오늘날짜 from dual;
select to_char(sysdate, 'HH"시" MI"분" SS"초"') as 오늘날짜 from dual;
select to_char(sysdate, 'HH24"시" MI"분" SS"초"') as 오늘날짜 from dual;
-----------------------------------------------------------------------------------------------------------------------------
select add_months(sysdate, 7) from dual; --add_months(date, 달수) : 날짜(date)에 달수 더하기
-----------------------------------------------------------------------------------------------------------------------------
select last_day(sysdate) from dual; -- 해당 달의 마지막 날
select last_day('2002-02-02') from dual; 
-----------------------------------------------------------------------------------------------------------------------------
select round(months_between('94-12-31', sysdate), 0) from dual; --months_between(date1, date2) : 두 날짜 사이의 달수
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
select count(department_id) from employees; --null값 빼고 카운트
select count(distinct department_id) from employees; --중복 값 빼고 카운트
select count(distinct nvl(department_id, 0)) from employees;
select distinct nvl(department_id, 0) from employees; 
select nvl(department_id ,0) from employees; --department_id 값이 null이면 0으로 채워 출력
-----------------------------------------------------------------------------------------------------------------------------
select job_id, decode(job_id, 'SA_MAN', 'Sales_Dept', 'SA_REP', 'Sales Dept', 'Another') as 분류
from employees; --job_id가 SA_MAN 이면 Sales_Dept, SA_REP 이면 Sales, 그 이외는 Another로 분류 필드 출력
select job_id, case job_id --job_id가
                when 'SA_MAN' then 'Sales_Dept' --SA_MAN 이면 Sales_Dept
                when 'SA_REP' then 'Sales_Dept' --SA_REP 이면 Sales_Dept
                else 'Another' --그 이외는 Another로
                end 분류 --분류
from employees 
order by 1;
-----------------------------------------------------------------------------------------------------------------------------
desc employees;
select employee_id as 사원번호, last_name as 사원이름,
                    case when salary < 10000 then '초급'
                         when salary < 20000 then '중급'
                         else '고급' 
                         end 구분
from employees
order by 구분, first_name;


























