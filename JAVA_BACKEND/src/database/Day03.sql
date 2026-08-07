DROP DATABASE IF EXISTS mydb0807;

CREATE DATABASE mydb0807;

USE mydb0807;       -- ctrl + shift + enter : 전체실행 , ctrl + enter : 한줄실행

CREATE Table test(  -- create table 테이블명(속성명 타입 제약조건, 속성명 타입 제약조건)
    번호 INT AUTO_INCREMENT ,                 -- constraint > 제약조건 추가
    constraint PRIMARY KEY( 번호 ),
    이름 VARCHAR(30) NOT NULL UNIQUE,
    개수  int DEFAULT 2
);
-- DML : 조작어 ,1) insert 레코드삽입 2) select 레코드조회 3) update 레코드 수정 4) delete 레코드삭제
-- 레코드란? 테이블내 행/가로 단위


# [1] insert : insert into 테이블명( 속성명1, 속성명2 ) values( 값1, 값2 )

insert into test( 번호 , 이름 , 개수 )VALUES(1, "유재석", 10 );
insert into test( 이름, 개수 ) VALUES( "강호동" , 20 );    -- 번호 값 제외한 삽입.
insert into test(이름)VALUES("신동엽");     -- 번호 값 제외 삽입 , auto_increment 자동번호

--insert into test(이름)VALUES("유재석"); -- 이름(unique)는 중복 불가능 / 오류
insert into test VALUES(4, "하하", 30);     -- 모든 속성값 순서대로 값 대입시 속성명 생략.
insert into test(이름)VALUES("박명수"), ("정형돈"), ("정준하");     -- 3개의 레코드 삽입.

# [2] select : select *[와일드카드] from 테이블명 where 조건 까지만(오늘)  /    중첩 & 조건이 들어갈 수 있음. / 
SELECT * FROM test;     -- 테이블 내 모든 속성[*] 의 레코드 조회
SELECT 이름 from test;      -- 테이블내 "name" 속성명의 레코드
SELECT 이름,개수 FROM test; -- "이름" , "개수"  속성명의 레코드 조회
SELECT * FROM test WHERE 이름 = "유재석";   -- 대입이 아닌 같다의 의미. (이름 속성명의 값이 유재석이면 조회.)
SELECT * FROM test WHERE 개수 >= 5; -- 개수 속성명의 값이 5 이상이면 조회

# [3] update : update 테이블명 set 속성명 = 새로운값, 속성명 = 새로운값 where 조건
update test set 개수 = 10;  -- 꼭 where 절을 사용하세용 (안그러면 전체 업데이트라서.)
update test set 개수 = 30 WHERE 이름 = "유재석";
update test set 개수 = 40 , 이름 = "강호동2" WHERE 번호 = 2;

# [4] delete : delete from 테이블명 where 조건 (조건이 없으면 테이블 전체 제거 유념.)
delete FROM test where 이름 = "유재석";     --이름 속성값이 유재석이면 삭제.
delete from test where 번호 = 2;    -- 번호 속성명이 2이면 삭제.
-- (DML) delete : 테이블내 레코드 삭제 [vs] (DDL) truncate table [vs] drop table : 테이블 자체 삭제
-- DDL은 취소 불가능 , DML은 취소(ROLBACK) 가능