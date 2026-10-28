CREATE TABLE Doctor (
    id NUMBER,
    name VARCHAR2(20),
    salary NUMBER(10,2),
    address VARCHAR2(30)
);



INSERT INTO Doctor (id, name, salary, address)
VALUES (1, 'Ahmed', 15000, 'Cairo');

INSERT INTO Doctor (id, name, salary, address)
VALUES (2, 'Mohamed', 18000, 'Alexandria');

INSERT INTO Doctor (id, name, salary, address)
VALUES (3, 'Sara', 20000, 'Menoufia');

INSERT INTO Doctor (id, name, salary, address)
VALUES (4, 'Mona', 17000, 'Giza');

INSERT INTO Doctor (id, name, salary, address)
VALUES (5, 'Omar', 22000, 'Tanta');

INSERT INTO Doctor (id, name, salary, address)
VALUES (6, 'Nour', 16000, 'Cairo');

INSERT INTO Doctor (id, name, salary, address)
VALUES (7, 'Youssef', 25000, 'Mansoura');

INSERT INTO Doctor (id, name, salary, address)
VALUES (8, 'Salma', 19000, 'Alexandria');

INSERT INTO Doctor (id, name, salary, address)
VALUES (9, 'Ali', 14000, 'Menoufia');

INSERT INTO Doctor (id, name, salary, address)
VALUES (10, 'Hana', 21000, 'Giza');










UPDATE  DOCTOR set salary=3000 WHERE id =3; 

DELETE FROM   DOCTOR WHERE  id =9; 

SELECT name || ' ' || salary AS doctor_info
FROM Doctor;

SELECT id,
       name,
       (salary * 2) AS CustomSalary,
       address
FROM Doctor;

SELECT *
FROM DOCTOR
WHERE salary = 1000
   OR salary = 2000
   OR salary = 3000;

RENAME  DOCTOR  TO PRD_DOCTOR
SELECT * FROM PRD_DOCTOR
COMMIT;