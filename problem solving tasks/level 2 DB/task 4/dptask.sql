SELECT  * from Employee  where  EmployeeId BETWEEN 100 and 105;

SELECT  * from Employee  where  EmployeeId in ( 151 , 152, 153, 154 , 155) ;

SELECT  * from Employee  WHERE FirstName  LIKE 'P%' OR FirstName LIKE 'p%';

SELECT  * from Employee  WHERE LOWER(FirstName)  LIKE '%a';

SELECT  * from Employee  WHERE UPPER(FirstName)  LIKE '%A%';

 SELECT  * from Employee  WHERE UPPER(FirstName)  LIKE '__E%';
 
 ALTER TABLE Employee ADD COLUMN manager_id INTEGER;
 
 SELECT  * from Employee  WHERE manager_id is NULL  ;
 
 SELECT  * from Employee  WHERE manager_id is NOT  NULL  ;
 
 INSERT INTO Employee (EmployeeId, FirstName, LastName, manager_id)VALUES (160, 'Peter', 'Smith', NULL);
 
  SELECT  * from Employee  WHERE UPPER(FirstName)  LIKE '__E%';

  SELECT * FROM Employee WHERE JOB_ID = 'AD_VP' OR JOB_ID = 'IT_PROG';
  
  SELECT   * from Employee  ORDER BY  LastName ASC ;
  
  SELECT   * from Employee  ORDER BY  HireDate desc ;
  
  SELECT   * from Employee  ORDER BY  department  ASC salary desc ;
  
  select EmployeeId, FirstName,LOWER(LastName)from Employee;
  
  select EmployeeId, UPPER(FirstName),LastName from Employee;
  
SELECT
    UPPER(SUBSTR(FirstName , 1, 1)) ||
    LOWER(SUBSTR(FirstName , 2)) AS first_name,
    UPPER(SUBSTR(LastName , 1, 1)) ||
    LOWER(SUBSTR(LastName , 2)) AS last_name
FROM Employee;


 SELECT  * from Employee  WHERE UPPER(LastName)  = 'smith' ;



 
 
