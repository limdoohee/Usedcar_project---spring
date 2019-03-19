
=======================================================
<계정 생성 순서>
1. cmd에서 sqlplus scott/tiger 접속
2. 아래의 sql문을 전체 복사 / 붙혀넣기 한다
3. 끝-
=======================================================

CONN system/1234	;

CREATE USER final_project
IDENTIFIED BY car;

GRANT DBA TO final_project;

SELECT * FROM USER_ROLE_PRIVS;




SELECT USERNAME, DEFAULT_TABLESPACE
FROM DBA_USERS
WHERE USERNAME = 'car';

ALTER USER final_project
QUOTA UNLIMITED ON SYSTEM;

CONN final_project/car
SHOW USER;

