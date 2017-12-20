**N minimum salary:**

SELECT MIN(EmpSalary)
FROM Salary
WHERE EmpSalary IN(SELECT TOP N EmpSalary FROM Salary ORDER BY EmpSalary DESC) 
for Ex: 3 minimum salary:

SELECT MIN(EmpSalary)
FROM Salary
WHERE EmpSalary IN(SELECT TOP 3 EmpSalary FROM Salary ORDER BY EmpSalary DESC) 

N maximum salary:

SELECT MAX(EmpSalary)
FROM Salary
WHERE EmpSalary IN(SELECT TOP N EmpSalary FROM Salary ORDER BY EmpSalary ASC)
for Ex: 3 maximum salary:

SELECT MAX(EmpSalary)
FROM Salary
WHERE EmpSalary IN(SELECT TOP 3 EmpSalary FROM Salary ORDER BY EmpSalary ASC)