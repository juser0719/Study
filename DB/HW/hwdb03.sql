use SCOTT;

-- emp와 dept Table을 JOIN하여 이름, 급여, 부서명을 검색하세요.
select ename "이름", sal "급여", dname "부서명"
from emp
join dept using(deptno);

-- 이름이 ‘KING’인 사원의 부서명을 검색하세요.
select dname
from dept
where deptno = (select deptno from emp where ename = 'KING');

-- dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.
select ename "사원이름", deptno "부서번호", dname "부서이름", sal "급여"
from emp
join dept
using(deptno);

-- emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력되도록 쿼리를 작성하세요. ‘SCOTT의 매니저는 JONES이다’.
select concat(a.ename,"의 매니저는 ", b.ename , "이다 ." )
from emp a
join emp b
on a.mgr = b.empno; # b를 조인 하는데 on 조건에 만족하는 데이터만 합체 시킴.

-- 'SCOTT'의 직무와 같은 사람의 이름, 부서명, 급여, 직무를 검색하세요.
select ename "이름" , dname "부서명" , sal "급여" , job "직무"
from emp
join dept
using(deptno)
where job = (select job from emp where ename = 'SCOTT');

-- 'SCOTT’가 속해 있는 부서의 모든 사람의 사원번호, 이름, 입사일, 급여를 검색하세요.
select empno "사원번호",ename "이름",hiredate "입사일", sal "급여"
from emp
where deptno = (select deptno from emp where ename = 'SCOTT' );

-- 전체 사원의 평균급여보다 급여가 많은 사원의 사원번호, 이름,부서명, 입사일, 지역, 급여를 검색하세요.
select empno "", ename "", dname "", hiredate "", loc "", sal ""
from emp
join dept using(deptno)
where sal >(select avg(sal) from emp);

-- 30번 부서와 같은 일을 하는 사원의 사원번호, 이름, 부서명,지역, 급여를 급여가 많은 순으로 검색하세요.
select empno "사원번호", ename "이름", dname "부서명", loc "지역", sal "급여"
from emp
join dept using(deptno)
where deptno = '30'
order by 5 desc;

-- 10번 부서 중에서 30번 부서에는 없는 업무를 하는 사원의 사원번호, 이름, 부서명, 입사일, 지역을 검색하세요.
select empno "사원 번호", ename "이름", dname "부서명", hiredate "입사일",loc "지역" 
from emp join dept using(deptno)
where deptno = 10 and job not in
(select distinct(job)
 from  emp
where deptno = 30);
 
-- ‘KING’이나 ‘JAMES'의 급여와 같은 사원의 사원번호, 이름,급여를 검색하세요.
select empno "사원 번호", ename "이름", sal "급여"
from emp
where sal in (select sal
			 from emp
             where ename = "KING" or ename = "JAMES"
			 );

--  급여가 30번 부서의 최고 급여보다 높은 사원의 사원번호,이름, 급여를 검색하세요. 
select empno "사원 번호", ename "이름", sal "급여"
from emp 
where sal > (select max(sal) from emp  where deptno = 30);

-- 이름 검색을 보다 빠르게 수행하기 위해 emp 테이블 ename에 인덱스를 생성하시오. 
create index idx on emp(ename);

-- 이름이 'ALLEN'인 사원의 입사연도가 같은 사원들의 이름과 급여를 출력하세요.
select ename "이름", sal "급여"
from emp
where year(hiredate) = (select year(hiredate) from emp where ename = "ALLEN" ); 

-- 부서별 급여의 합계를 출력하는 View를 작성하세요.
create view SumOfSal as select dname "부서", sum(sal) "급여의 합" from EMP join dept using(deptno) group by deptno; 
select * from SumOfSal;

--  14번에서 작성된 View를 이용하여 부서별 급여의 합계가 큰 1~3순위를 출력하세요.
select * from SumOfSal order by 2 desc limit 3;