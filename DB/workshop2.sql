use world;

select @@autocommit;
set autocommit=false;

# 1. country 에서 전체 자료의 수와 독립 연도가 있는 자료의 수를 각각 출력하시오.
# count는 요소의 개수를 반환하는데 null인 값은 처리하지 않는다.

# 2. country 에서 기대 수명의 합계, 평균, 최대, 최소를 출력하시오. 평균은 소수점 2 자리로 반올림한다.
# 합계는 sum, 평균은 round, 최대는 max, 최소는 min을 사용한다.

# 3. country 에서 continent 별 국가의 개수와 인구의 합을 구하시오. 국가 수로 정렬 처리한다.(7 건)
# 일반 컬럼과 집계 함수를 함께 사용할 때는 group by 절에 일반 컬럼을 표시한다.

# 4. country 에서 대륙별 국가 표면적의 합을 구하시오. 면적의 합으로 내림차순 정렬하고 상위 3 건만 출력한다.
# 일반 컬럼과 집계 함수를 함께 사용할 때는 group by 절에 일반 컬럼을 표시한다.

-- 5. country 에서 대륙별로 인구가 50,000,000 이상인 나라의 gnp 총 합을 구하시오. 합으로 오름차순 정렬한다.(5 건)
# 일반 컬럼과 집계 함수를 함께 사용할 때는 group by 절에 일반 컬럼을 표시한다.

# 6. country 에서 대륙별로 인구가 50,000,000 이상인 나라의 gnp 총 합을 구하시오. 이때 gnp 의 합이
# 5,000,000 이상인 것만 구하시오.
# group by의 결과에 조건을 줄 때는 where가 아닌 having 절을 이용한다.


# 7. country 에서 연도별로 10 개 이상의 나라가 독립한 해는 언제인가?
# group by의 결과에 조건을 줄 때는 where가 아닌 having 절을 이용한다.


-- 8. country 에서 국가별로 gnp 와 함께 전세계 평균 gnp, 대륙 평균 gnp 를 출력하시오.(239 건)
# 집계 함수의 over 절은 grouping 대상을 지정하며 여러 행에 표시될 수 있다.


# 9. countrylanguage 에 countrycode='AAA', language='외계어', isOfficial='F', percentage=10 을
# 추가하시오. 

# 값을 추가할 수 없는 이유를 생각하고 필요한 부분을 수정해서 다시 추가하시오.
# countrycode는 country 테이블을 참조하는  F.K이므로 country 테이블에 있는 값만 사용할 수 있다.


# 10. countrylanguage 에 countrycode='ABW', language='Dutch', isOfficial='F', percentage=10 을
# 추가하시오. 


# 값을 추가할 수 없는 이유를 생각하고 필요한 부분을 수정해서 다시 추가하시오.
# countrycode와 language가 조합키로 P.K를 구성하므로 이미 있는 값은 추가될 수 없다.


# 11. country 에 다음 자료를 추가하시오.
#  Code='TCode', Region='TRegion',Code2='TC'
#  값을 추가할 수 없는 이유를 생각하고 필요한 부분을 수정해서 다시 추가하시오.
# Code는 최대 3글자만 들어갈 수 있고 name은 not null이고 default가 없으므로 값이 꼭 필요하다.

# 12. city 에서 id 가 2331 인 자료의 인구를 10% 증가시킨 후 조회하시오.


# 13. country 에서 code 가 'USA'인 자료를 삭제하시오.
# 삭제가 안되는 이유를 생각하고 성공하려면 어떤 절차가 필요한지 생각만 하시오.
# country의 code는 F.K로 참조되고 있으므로 먼저 참조하고 있는 테이블의 데이터를 삭제후 country 데이터를 삭제해야 한다.

# 14. 이제 까지의 DML 작업을 모두 되돌리기 위해 rollback 처리하시오.


# 15. ssafy_ws_5th 라는 이름으로 새로운 schema 를 생성하시오.
# schema나 table 등을 생성하기 위해서는 create 명령을 사용한다.

# 16. 만약 user 라는 테이블이 존재한다면 삭제하시오.
# schema나 table 등을 삭제하기 위해서는 drop 명령을 사용한다.

# 17. ssafy_ws_5th 에 다음 조건을 만족하는 테이블을 생성하시오.
# table을 생성할 때는 create 명령을 사용하며 column을 선언할 때 이름과 타입, 제약사항을 명시할 수 있다.
# 테이블명: user


# 18. user 테이블에 다음의 자료를 추가하시오.
# id: ssafy, pass: 1234, name:김싸피
# id: hong, pass: 5678, name:홍싸피
# id: test, pass: test, name:테스트



# 19. id 가 test 인 계정의 pass 를 id@pass 형태로 변경하고 조회하시오.


# 20. id 가 test 인 계정의 자료를 삭제하고 조회하시오.


# 21. 현재까지의 내용을 영구 저장하기 위해서 commit 처리하시오