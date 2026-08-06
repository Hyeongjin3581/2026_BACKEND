-- 1. 회원 테이블 존재시 삭제/초기화
DROP DATABASE IF EXISTS member0806;
--2. 회원 테이블 생성
CREATE DATABASE member0806;
--3. 회원 테이블 사용
USE member0806;
--4. 회원 테이블 생성 
CREATE Table memberTable(
    MemberID INT AUTO_INCREMENT,
    constraint PRIMARY KEY(MemberID),
    userID VARCHAR(15) NOT NULL UNIQUE,
    userPW VARCHAR(15) NOT NULL,
    userNAME VARCHAR(10) NOT NULL UNIQUE,
    userPHOTO VARCHAR(50) NOT NULL
)
