USE SCOTT;

select *
from dept;

select *
from emp;

# 1. 부서위치가 CHICAGO인 모든 사원에 대해 이름,업무,급여 출력하는 SQL을 작성하세요.
select e.ename, e.job, e.sal, d.loc
from emp e join dept d
where d.loc = 'CHICAGO';


# 2. 부하직원이 없는 사원의 사원번호,이름,업무,부서번호 출력하는 SQL을 작성하세요.
-- mgr에 없는 사원을 뽑아...
select empno as "사원번호", ename as "이름", job as "업무", deptno as "부서번호"
from EMP a
where empno not in
(select mgr
from EMP
where mgr is not null);


# 3. BLAKE와 같은 상사를 가진 사원의 이름,업무,상사번호 출력하는 SQL을 작성하세요.

select ename "이름", job "업무", empno "상사번호"
from emp
where mgr = ( select mgr from emp where ename = "BLAKE");

# 4. 입사일이 가장 오래된 사람 5명을 검색하세요.

select ename, hiredate
from emp
order by 2 asc limit 5;

# 5. JONES 의 부하 직원의 이름, 업무, 부서명을 검색하세요.

select e.ename, e.job , d.dname
from emp e join dept d
using (deptno)
where mgr = all(select empno from emp where ename = "JONES");
