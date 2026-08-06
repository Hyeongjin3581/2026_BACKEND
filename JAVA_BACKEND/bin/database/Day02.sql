#[1] 데이터베이스 삭제

DROP DATABASE IF EXISTS mydb0805;

#[2] 데이터베이스 생성
CREATE DATABASE mydb0805

# [3] 데이터베이스 목록
SHOW DATABASES ;

#[4] 데이터베이스 사용
USE  mydb0805;

# -------------------------------------- #
# DDL : 데이터베이스 / 테이블 생성 / 삭제 / 수정 질의어 ( ** auto comit  ** )(트랜잭션 불가능)(오토커밋)
# 1) 테이블 생성 : 1. 테이블생성탭 ; 데이터베이스 활성화 2) create table 테이블명 (속성명 타입, 속성명 타입);
CREATE Table test1( 필드명1 int, 필드명2 double, 필드명3 text );

# 2) 테이블 목록 조회
show tables;

# 3) 특정 테이블 속성 확인
describe test1;

# 4) 특정 테이블 삭제
drop Table test1;

# 5) 테이블 수정
# 5-1> 필드/ 속성 추가
ALTER Table test1 ADD 필드명4 FLOAT;

# 5-2> 필드/속성 수정
ALTER Table test1 MODIFY 필드명3 longtext;

# 5-3> 필드/속성명 , 타입 수정
alter table test1 change 필드명1 필드명5 bigint;

#6) 테이블 이름 변경
RENAME table test1 to new_test1;

# 7) 테이블 모든 레코드(행/데이터) 삭제
TRUNCATE Table new_test1; # vs delete 

# --------------------------------------------------- #
# 테이블의 속성/ 필드 타입 * DBMS 예시마다 차이 *
use mydb0805;

-- CREATE TABLE test2(필드명 타입, 필드명 타입, 필드명 타입 );

CREATE TABLE test2(
    점수필드1 TINYINT               -- byte +- 128까지
   ,점수필드2 SMALLINT              -- short랑 유사, 2byte
   ,점수필드3 MEDIUMINT             -- 3byte
   ,점수필드4 INT                   -- 4byte
   ,점수필드5 BIGINT                -- 8byte
   ,점수필드6 TINYINT UNSIGNED      -- 부호가 없다. (0 ~ 255) 1byte

   ,실수필드1 FLOAT                 -- 4byte
   ,실수필드2 DOUBLE                -- 8byte
   ,실수필드3 DECIMAL(10, 2)         -- 소수점 오차 없는 고정소수점 (자릿수 지정 권장)

   ,날짜필드1 DATE                  -- 날짜
   ,시간필드1 TIME                  -- 시간

   ,문자필드1 CHAR(3)               -- 고정길이 (괄호 필요)
   ,문자필드2 VARCHAR(3)            -- 가변길이 (괄호 필요)
   ,문자필드3 TEXT
   ,문자필드4 LONGTEXT

   ,논리필드1 BOOLEAN               -- 마지막 필드 뒤에는 쉼표(,)를 붙이지 않음
);

describe test2;

#--------------------------------------------------------------------#
# 속성/필드 제약조건

CREATE Table test3(
    필드명1 TINYINT NOT NULL  ,  -- 해당 속성에는  null 저장할 수 없도록 설정. * 값이 null 이면 오류발생
    필드명2 SMALLINT UNIQUE,    -- 해당 필드/속성 에는 중복값을 지정할 수 없도록 설정 * 값이 다른 레코드와 같다면 오류발생 *
    필드명3 INT DEFAULT 100 ,        -- 해당 필드/속성 에 레코드 생성시 기본값이 10 대입된다.
    필드명4 DATETIME DEFAULT now(), -- 레코드 삽입 시 현재 날짜/시간을 자동 대입된다.
    필드명5 BIGINT AUTO_INCREMENT,
    -- BIGINT AUTO_INCREMENT 레코드(행) 삽입 시 자동으로 순서/번호가 할당됨.  , 1 2 3 4 5 6 ~
    -- PRIMARY key(pk) : 기본/식별 키 , 식별가능한 고유 한 값 갖는 필드 (not null + unique 내장됨) 
    constraint PRIMARY KEY(  필드명5 ) 
        -- constraint  => 특정 필드/속성 pk로 설정한다.
        -- FOREIGN KEY(fk) : 참조/ 외래 키 (pk가 다른테이블에 위치한 경우), 다른 테이블의 기본키 참조하는 키
            -- 수강신청한 학번,  급여 지급사번 ,  판매된 제품코드
            -- 참조 옵션 : pk가 삭제/수정된 경우 어떻게????
                -- on delete/update CASCADE     : pk가 삭제되면 fk도 같이 삭제/수정
                -- on delete/update set null         : pk가 삭제/수정되면 fk도 null로 수정
                -- on delete/update restrict         : (생략시 기본값) pk가 fk로부터 참조 중이면 삭제/수정 불가능
);

DROP Table test3;

CREATE Table test4(
    필드명1 BIGINT, constraint FOREIGN KEY (필드명1) REFERENCES test3(필드명5) on delete CASCADE on update CASCADE
     -- FOREIGN key => fk 외래키/참조키 REFERENCES => 참조하다
);
-- mysql workbench 또는 vscode 

drop table test4

# 예제1 회원제 게시판 서비스------------------ #
drop DATABASE if EXISTS boardService0805;   -- 1) 데이터베이스 초기화 / 삭제 한다. 

CREATE DATABASE boardService0805;   --  2) 데이터베이스 생성하낟.

USE boardService0805;   --  3) 데이터베이스 활성화한다.

CREATE Table member(                                        
    mno int  AUTO_INCREMENT ,                --  자동회원번호 ) 실무에서는 오류때문에 잘 쓰지 않음.
    constraint PRIMARY KEY (mno) ,                -- 회원번호 pk 설정
    mid VARCHAR(30) not null UNIQUE ,        -- 회원 아이디면서, 최대 30글자, 공백불가능(not null), 중복 불가능(unique)
    mpwd VARCHAR(20) NOT null,                    -- 비밀번호이면서, 최대20글자, 공백불가능, 중복가능
    mname VARCHAR(10) NOT NULL ,              -- 회원닉네임
    mdate DATETIME DEFAULT now()                 -- 회원 가입 날짜/시간  , 현재 날짜/시간을 자동으로 기본값 설정 * 관례적 *
  );                                                                     -- 레코드삽입/시간 수정날짜/시간 (관례적으로 테이블 하나당 두개씩 사용. (날짜/시간))


create Table board(                                        
    bno int AUTO_INCREMENT,                       
    constraint PRIMARY KEY( bno ),                 -- 게시물번호 pk 설정 * 테이블1개당 pk1개 이상 권장 *
    btitle VARCHAR(255),
    bcontent longtext,
    bdate DATETIME DEFAULT now(),
    bview int DEFAULT 0,
    mno int,                                                                      -- 작성자(mid/회원아이디가 아니고 mno/회원번호)
    constraint FOREIGN KEY( mno ) REFERENCES member( mno )
        on delete CASCADE
)