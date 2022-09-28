drop table employee;
drop sequence employee_id_seq;
CREATE SEQUENCE employee_id_seq start with 1;

CREATE TABLE employee (
  id  NUMBER(4)  PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(30),
  phone VARCHAR(30),
  salary NUMBER(8) default 0
);
insert into employee(id,name,email,phone) 
values(employee_id_seq.nextval,'KIM','kim@spring.org','011-111-1111');
insert into employee(id,name,email,phone) 
values(employee_id_seq.nextval,'LEE','lee@spring.org','011-222-2222');
insert into employee(id,name,email,phone) 
values(employee_id_seq.nextval,'PARK','park@spring.org','011-333-3333');
insert into employee(id,name,email,phone) 
values(employee_id_seq.nextval,'CHOI','choi@spring.org','011-444-4444');
insert into employee(id,name,email,phone) 
values(employee_id_seq.nextval,'SIM','sim@spring.org','011-555-5555');
commit;