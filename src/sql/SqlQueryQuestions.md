* Min - Max Salary Using top keyword

**N minimum salary:**

SELECT MIN(EmpSalary)
FROM Salary
WHERE EmpSalary IN(SELECT TOP N EmpSalary FROM Salary ORDER BY EmpSalary DESC) 

_for Ex: 3 minimum salary:_

SELECT MIN(EmpSalary)
FROM Salary
WHERE EmpSalary IN(SELECT TOP 3 EmpSalary FROM Salary ORDER BY EmpSalary DESC) 

**N maximum salary:**

SELECT MAX(EmpSalary)
FROM Salary
WHERE EmpSalary IN(SELECT TOP N EmpSalary FROM Salary ORDER BY EmpSalary ASC)

_for Ex: 3 maximum salary:_

SELECT MAX(EmpSalary)
FROM Salary
WHERE EmpSalary IN(SELECT TOP 3 EmpSalary FROM Salary ORDER BY EmpSalary ASC)

* nth Max salary using subquery

SELECT *
FROM Employee Emp1
WHERE (N-1) = (
               SELECT COUNT(DISTINCT(Emp2.Salary))
               FROM Employee Emp2
               WHERE Emp2.Salary > Emp1.Salary
               )
