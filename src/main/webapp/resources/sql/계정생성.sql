
=======================================================
<���� ���� ����>
1. cmd���� sqlplus scott/tiger ����
2. �Ʒ��� sql���� ��ü ���� / �����ֱ� �Ѵ�
3. ��-
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

