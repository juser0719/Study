use world;

select @@autocommit;
set autocommit=false;
 
--  1. country 에서 전체 자료의 수와 독립 연도가 있는 자료의 수를 각각 출력하시오.
--  count는 요소의 개수를 반환하는데 null인 값은 처리하지 않는다.

--  2. country 에서 기대 수명의 합계, 평균, 최대, 최소를 출력하시오. 평균은 소수점 2 자리로 반올림한다.
--  합계는 sum, 평균은 round, 최대는 max, 최소는 min을 사용한다.

--  3. country 에서 continent 별 국가의 개수와 인구의 합을 구하시오. 국가 수로 정렬 처리한다.(7 건)
--  일반 컬럼과 집계 함수를 함께 사용할 때는 group by 절에 일반 컬럼을 표시한다.

--  4. country 에서 대륙별 국가 표면적의 합을 구하시오. 면적의 합으로 내림차순 정렬하고 상위 3 건만 출력한다.
--  일반 컬럼과 집계 함수를 함께 사용할 때는 group by 절에 일반 컬럼을 표시한다.

-- 5. country 에서 대륙별로 인구가 50,000,000 이상인 나라의 gnp 총 합을 구하시오. 합으로 오름차순 정렬한다.(5 건)
--  일반 컬럼과 집계 함수를 함께 사용할 때는 group by 절에 일반 컬럼을 표시한다.

--  6. country 에서 대륙별로 인구가 50,000,000 이상인 나라의 gnp 총 합을 구하시오. 이때 gnp 의 합이
--  5,000,000 이상인 것만 구하시오.
--  group by의 결과에 조건을 줄 때는 where가 아닌 having 절을 이용한다.


--  7. country 에서 연도별로 10 개 이상의 나라가 독립한 해는 언제인가?
--  group by의 결과에 조건을 줄 때는 where가 아닌 having 절을 이용한다.


-- 8. country 에서 국가별로 gnp 와 함께 전세계 평균 gnp, 대륙 평균 gnp 를 출력하시오.(239 건)
--  집계 함수의 over 절은 grouping 대상을 지정하며 여러 행에 표시될 수 있다.


--  9. countrylanguage 에 countrycode='AAA', language='외계어', isOfficial='F', percentage=10 을
--  추가하시오. 

--  값을 추가할 수 없는 이유를 생각하고 필요한 부분을 수정해서 다시 추가하시오.
--  countrycode는 country 테이블을 참조하는  F.K이므로 country 테이블에 있는 값만 사용할 수 있다.


--  10. countrylanguage 에 countrycode='ABW', language='Dutch', isOfficial='F', percentage=10 을
--  추가하시오. 


--  값을 추가할 수 없는 이유를 생각하고 필요한 부분을 수정해서 다시 추가하시오.
--  countrycode와 language가 조합키로 P.K를 구성하므로 이미 있는 값은 추가될 수 없다.


--  11. country 에 다음 자료를 추가하시오.
--   Code='TCode', Region='TRegion',Code2='TC'
--   값을 추가할 수 없는 이유를 생각하고 필요한 부분을 수정해서 다시 추가하시오.
--  Code는 최대 3글자만 들어갈 수 있고 name은 not null이고 default가 없으므로 값이 꼭 필요하다.

--  12. city 에서 id 가 2331 인 자료의 인구를 10% 증가시킨 후 조회하시오.


--  13. country 에서 code 가 'USA'인 자료를 삭제하시오.
--  삭제가 안되는 이유를 생각하고 성공하려면 어떤 절차가 필요한지 생각만 하시오.
--  country의 code는 F.K로 참조되고 있으므로 먼저 참조하고 있는 테이블의 데이터를 삭제후 country 데이터를 삭제해야 한다.
	select *from country;
	select *from countrylanguage;
	select *from city;
	delete from country where code = 'USA';
	
--  14. 이제 까지의 DML 작업을 모두 되돌리기 위해 rollback 처리하시오.


--  15. ssafy_ws_5th 라는 이름으로 새로운 schema 를 생성하시오.
--  schema나 table 등을 생성하기 위해서는 create 명령을 사용한다.
	
--  16. 만약 user 라는 테이블이 존재한다면 삭제하시오.
--  schema나 table 등을 삭제하기 위해서는 drop 명령을 사용한다.
	drop table if exists user;
--  17. ssafy_ws_5th 에 다음 조건을 만족하는 테이블을 생성하시오.
--  table을 생성할 때는 create 명령을 사용하며 column을 선언할 때 이름과 타입, 제약사항을 명시할 수 있다.
--  테이블명: user
--	테이블 생성/수정/복사 
-- 1.테이블생성
-- create table 테이블명(컬럼명1   컬럼타입  [제약조건],컬럼명2  컬럼타입  [제약조건],.....);

--  -  문자로 시작: 영문 대소문자,숫자,특수문자( _ , $ , # ),한글
--  -  중복되는 이름은 사용안됨
--  -  예약어(create, table, column등)은 사용할수 없다

--  -  자료형
--    varchar(M):  문자,문자열(가변형) ==> M은 1~255
--    char(M)   :  문자,문자열(고정형) ==> M은 1~65535
--    text(M)   :  문자,문자열        ==> 최대 65535 
--    int(M)    :  정수형 숫자
--    float / double(M,D) : 실수형 숫자
--    datetime :    YYYY-MM-DD HH:MM:SS('1001-01-01 00:00:00' ~ '9999-12-31 23:59:59')
--    timestamp(M) : 1970-01-01 ~ 2037년 임의 시간(1970-01-01 00:00:00 를 0으로 해서 1초단위로 표기

--  18. user 테이블에 다음의 자료를 추가하시오.
--  - 제약조건
--     not null:  해당컬럼에 NULL을 포함되지 않도록 함 
--     unique:  해당컬럼 또는 컬럼 조합값이 유일하도록 함
--     primary key: 각 행을 유일하게 식별할수 있도록함(P.K:기본키)
--     foreign key: references를 이용하여 어떤 컬럼에 어떤 데이터를 참조하는지 반드시 지정(F.K:참조키,외래키)
--     default: NULL값이 들어올 경우 기본 설정되는 값을 지정
--     check : 해당컬럼에 특정 조건을 항상 만족시키도록함
--             MySQL의 경우 작성은 가능하지만(에러발생 x) 적용은 안됨
	create table user(
		id varchar(50) primary key,
		name varchar(100) not null default '익명',
		pass varchar(100) not null
	);
	show tables;
	desc user;
	
	insert into user values ('ssafy', '1234', '김싸피'), ('hong','5678','홍길동'),('test','test','테스트');
	select * from user;
--     [참고]  primary key = unique + not null

--     ex)       idx          int          auto_increment    자동 값증가   
--               userid       varchar(16)  not null          아이디 
--               username     varchar(20)                    이름
--                 userpwd      varchar(16)                    비밀번호
--               emailid      varchar(16)                    이메일아이디
--               emaildomain  varchar(16)                    이메일도메인
--               joindate     timestamp    current_timestamp 가입일 
--  id: ssafy, pass: 1234, name:김싸피
--  id: hong, pass: 5678, name:홍싸피
--  id: test, pass: test, name:테스트



--  19. id 가 test 인 계정의 pass 를 id@pass 형태로 변경하고 조회하시오.
	update user set pass = concat(id,'@',pass) where id = 'test';
	select * from user where id = 'test';
--  20. id 가 test 인 계정의 자료를 삭제하고 조회하시오.


--  21. 현재까지의 내용을 영구 저장하기 위해서 commit 처리하시오
	commit;