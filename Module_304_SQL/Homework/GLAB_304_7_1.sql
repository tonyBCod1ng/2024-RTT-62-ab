-- Suppose you have to find all employees who are located at the location with the ID 1700. You might come up with the following solution.
-- First, find all departments located at the location_id is 1700:

SELECT  * FROM  departments WHERE  location_id = 1700;

-- According to the result, the departments of 1, 3, 9, 10, and 11 are located at 1700 ID.
-- Secondly, to find employees that belong to the location 1700, we can use the department id list from the previous query, as depicted in the query below.

SELECT  employee_id, first_name, last_name, department_id
FROM   employees
WHERE  department_id IN (1, 3, 9, 10, 11)
ORDER BY first_name, last_name;

-- Result:
-- The above solution has two problems. To start with, you have looked at the department’s table to check which department belongs to location 1700. 
-- However, the original question was not referring to any specific departments — it referred to location 1700. 
-- Because of the small data volume, you can easily get a list of departments. 
-- However, in a real system with high volumes of data, it might be problematic.
-- Another problem was that you had to revise the queries whenever you wanted to find employees who were located in a different location. 
-- A much better solution to this problem is to use a "subquery."

-- Example: Subquery with Where Clause 
-- Let’s utilize the IN or NOT IN operator.
-- You can rewrite and combine the queries above as follows:

SELECT   employee_id, first_name, last_name, department_id
FROM employees
WHERE department_id IN (SELECT department_id
        FROM      departments
        WHERE location_id = 1700)
ORDER BY first_name, last_name;

-- The following example uses a subquery with the NOT IN operator to find all employees' information who do not locate at location 1700.

SELECT employee_id, first_name, last_name
FROM  employees
WHERE  department_id NOT IN (SELECT department_id
        FROM   departments
        WHERE location_id = 1700)
ORDER BY first_name , last_name;

-- Let's utilize the comparison operator (=, >, =, <= , !=)
-- The following example finds the employees who have the highest salary:

SELECT employee_id, first_name, last_name, salary
FROM   employees
WHERE salary = (SELECT MAX(salary) FROM  employees)
ORDER BY first_name, last_name;

-- In the above subquery, the subquery returns the highest salary of all employees, 
-- and the outer query finds the employees whose salary is equal to the highest one.

-- The following query finds the employee number, name, and salary 
-- for the employees whose salary is higher than the average salary throughout the company:

SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary)FROM employees);

-- Let's utilize the EXISTS or NOT EXISTS operators.
-- The EXISTS operator checks for the existence of rows returned from the subquery. 
-- It returns true if the subquery contains any rows. Otherwise, it returns false

-- The following example finds that all departments have at least one employee with a salary greater than 10,000. 
-- We will use the Where clause and the EXISTS operator.

SELECT department_name
FROM departments d
WHERE EXISTS ( SELECT * FROM employees e 
	WHERE salary > 10000 AND e.department_id = d.department_id)
ORDER BY department_name; 

-- Similarly, the following query finds all departments that do not have an employee with a salary greater than 10,000, 
-- We will use the Where clause, and the NOT EXISTS operator.

SELECT department_name
FROM departments d
WHERE NOT EXISTS ( SELECT * FROM employees e
        WHERE salary > 10000 AND e.department_id = d.department_id) ORDER BY department_name; 
        
-- *** For this section, you must have a “classicmodels” database selected. (I recommend downloading the one from the slide for simplicity)***

-- Example 1:
-- This one asked to calculate the average salary of each employee however there is no Salary or dept Id column so 
-- I used the job_title to replace dept id and the vacation hours to replace the salary:

SELECT AVG(VacationHours) average_vacation_hours_earned
FROM employees GROUP BY jobTitle;

-- You can use the above query as a subquery in the FROM clause to calculate the average salary of departments as follows:

SELECT ROUND( AVG(average_vacation_hours_earned), 0)
FROM ( SELECT AVG(VacationHours) as average_vacation_hours_earned FROM employees   GROUP BY jobTitle) department_vacay_hrs;

-- Example 2: 
-- The following query gets the top five products by sales revenue in 2003 from the orders and orderdetails tables.

SELECT productCode, ROUND(SUM(quantityOrdered * priceEach)) AS sales
FROM orderdetails
	INNER JOIN orders USING (orderNumber)
WHERE YEAR(shippedDate) = 2003
GROUP BY productCode
ORDER BY sales DESC
LIMIT 5;

-- You can use the result of this query as a derived table and join it with the products table as follows:

SELECT productName, sales
FROM  (SELECT productCode, ROUND(SUM(quantityOrdered * priceEach)) AS sales
    FROM orderdetails  INNER JOIN orders USING (orderNumber)
    WHERE YEAR(shippedDate) = 2003
    GROUP BY productCode
    ORDER BY sales DESC
    LIMIT 5) as top5products2003
INNER JOIN products USING (productCode);

-- In this example:
-- First, the subquery is executed to create a result set or derived table.
-- Then the outer query is executed that joins the top5product2003 derived table with the products table using the productCode column.

