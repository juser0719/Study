-- world DB 사용설정.
use world;
-- city,country, countrylanguage 테이블 구조 파악. 구조 파악 = desc.
desc city;
desc country;
desc countrylanguage;
-- coutry table에서 code가 KOR인 자료를 조회하시오.
select * from country where code= 'KOR';
select code,name,region from country where code = 'KOR';
-- country에서 gnp변동량(gnp-gnpold)이 양수인 국가에 대해 아래 형식으로 출력하시오.
select code, name , gnp, gnpold, gnp-gnpold gnp변동량 from country where gnp-gnpold > 0;
--  country table에서 continent를 중복 없이 조회하시오. distinct 를 이용하면 중복 자료를 제거할 수 있다.
select sistinct(continent) from country;
-- country에서 asia 대륙에 속하는 국가들의 정보를 아래와 같이 출력하시오. mysql에서 문자열을 열결할 경우는 concat 함수를 사용한다.
select concat(name,'은',region,'에 속하며, 인구는 ', population,' 명 이다.') as "정보" from country where continent = 'asia';
--  country에서 독립 년도에 대한 기록이 없고 인구가 10000이상인 국가의 정보를 아래와 같이 인구의 오름차순으로 출력하시오. 값이 null인지 확인할 경우 is null을 사용한다. 또한 and or를 이용해서 여러 조건을 복합적으로 사용할 수 있다.
select name,continent,gnp,population, indepyear from country where population > 10000 and indepyear is null order by. population asc;
--  인구가 1억 <= x <=2억 인 나라 기준 상위 3개 내림차순.
select code,name, population from country where population between 100000000 and 200000000
order by 3 desc limit 3;
-- 800 1810 1811 1901 1901 에 독립년 기준으로 정렬.
select code, name , indepyear from country 
where indepyear = '800' or indepyear = '1810' or indepyear = '1811' or indepyear = '1901'
order by 3 asc , code desc;
-- region에 asia가 들어가고 name의 두번째 글자가 o인 정보를 출력
select code,name ,region from country where region like "%asia%" and name like '_o%';
-- 글자 길이 출력.
select char_length('홍길동') as "한글" , char_length('hong') as "영문";
-- governmentform에 republic 이 들어가있고 name 길이가 10 이상. instr(목표str, 검색str)
select code, name, governmentform from country 
where char_length(name)>=10 and instr(governmentform, 'republic') 
order by char_length(name) desc limit 10;
-- code 가 모음으로 시작하는 나라의 정보 출력. substr(타겟,시작인덱스,갯수)
select code, name from country 
where substr(code, 1, 1) in ('a', 'e','i','o','u') 
order by name limit 2, 3; 
-- 이름을 맨앞 맨뒤 2글자 제외하고는 *로 처리
select name, concat(left(name, 2),   lpad('*', char_length(name)-4, '*'), right(name, 2)) 'guess' from country;
-- 중복없이 가져오는데 공백을 _ 로 대체
select distinct(replace(region, ' ', '_')) "지역들" from country order by length(region) desc;
-- 반올림 3자리 오름차순.
select name, surfacearea, population, round(surfacearea/population, 3) '1인당 점유면적' 
from country where population >=100000000 order by 2;
-- 현재 날짜와 올해가 며칠이 지났는지 100일 후는 며칠인지 출력.
select curdate() "오늘",
datediff(curdate(),'2021-01-01') "올해 지난 날", 
date_add(curdate(), interval 100 day) "100일 후";
