CREATE TABLE Employees (
    EmployeeID NUMBER,
    FirstName VARCHAR2(20),
    LastName VARCHAR2(20),
    Department VARCHAR2(20),
    Salary NUMBER(10,3)
);
INSERT INTO Employees (EmployeeID, FirstName, LastName, Department, Salary)
VALUES (101, 'John1', 'Doe1', 'HR', 20000);

INSERT INTO Employees (EmployeeID, FirstName, LastName, Department, Salary)
VALUES (102, 'John2', 'Doe2', 'IT', 50000);

INSERT INTO Employees (EmployeeID, FirstName, LastName, Department, Salary)
VALUES (103, 'John3', 'Doe3', 'CS', 40000);

INSERT INTO Employees (EmployeeID, FirstName, LastName, Department, Salary)
VALUES (104, 'John4', 'Doe4', 'IT', 10000);

INSERT INTO Employees (EmployeeID, FirstName, LastName, Department, Salary)
VALUES (105, 'John5', 'Doe5', 'ZX', 30000);

SELECT *
FROM Employees;


UPDATE EMPLOYEES  SET salary=600000 WHERE EmployeeID=101;

delete EMPLOYEES  WHERE EmployeeID=101;

SELECT *
FROM Employees
WHERE Department = 'IT';


SELECT EmployeeID,
       FirstName || ' ' || LastName AS Name,
       Department,
       Salary
FROM Employees;