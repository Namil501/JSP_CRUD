CREATE TABLE department  (
  dept_id NUMBER(2) PRIMARY KEY,
  dept_name VARCHAR2(15 CHAR) NOT NULL
);
CREATE TABLE employee (
  emp_id NUMBER(5) PRIMARY KEY,
  emp_pass VARCHAR2(16 CHAR) NOT NULL,
  emp_name VARCHAR2(30 CHAR) NOT NULL,
  gender NUMBER(1) NOT NULL,
  address VARCHAR(60 CHAR) NOT NULL,
  birthday DATE NOT NULL,
  authority NUMBER(1) NOT NULL,
  dept_id NUMBER(2) NOT NULL REFERENCES department(dept_id)
);
CREATE SEQUENCE seq_emp NOCACHE;
INSERT INTO department VALUES(1, '�c�ƕ�');
INSERT INTO department VALUES(2, '�o����');
INSERT INTO department VALUES(3, '������');
INSERT INTO employee VALUES(seq_emp.nextval,'1111','��ؑ��Y',1,'�����s','1986/10/12',1,1);
INSERT INTO employee VALUES(seq_emp.nextval,'2222','�c����Y',1,'��t��','1979/07/02',2,2);
INSERT INTO employee VALUES(seq_emp.nextval,'3333','�n�ӉԎq',2,'���{','1988/04/23',2,2);

COMMIT;
select * from employee;