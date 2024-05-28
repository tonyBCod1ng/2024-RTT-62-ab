-- Homework 1
-- Question 0.1
-- I want to see the count of the number of products in each product line
SELECT pl.id, pl.product_line, COUNT(*) total_products
FROM productlines pl, products p
WHERE pl.id = p.productline_id
GROUP BY pl.id
ORDER BY total_products DESC;
-- question 0.2
-- I want to see a list of employees and all of the customers for that employee.   Employee name will be duplicated in the result set.   I want to see the employee first and last name
-- and the customer contact first and last name as well as the customer name
SELECT CONCAT(e.lastname,", ", e.firstname) employee_name,
c.customer_name,
c.contact_firstname, 
c.contact_lastname 
FROM customers c, employees e
WHERE c.sales_rep_employee_id = e.id
ORDER BY e.id;
-- question 0.3
-- I want to see a list of employees in each office.   Show the office name and the employee name
SELECT o.id, CONCAT(e.lastname,", ", e.firstname) employee_name
FROM employees e, offices o
WHERE e.office_id = o.id
ORDER BY o.id;
-- question 0.4
-- I want to see the totaly number of each employee type based on job title.. result should the job title and the number of employess with that job title.
SELECT e.job_title, COUNT(*)
FROM employees e
GROUP BY job_title;
-- question 0.5
-- I want to see a list of all payments each customer has made.  Order the list by custoemr name ascending, then by the payment amount descending
SELECT c.customer_name, p.customer_id, p.check_number, p.payment_date, p.amount
FROM payments p, customers c
ORDER BY p.customer_id ASC, p.amount DESC;
-- question 0.6
-- I want to see a list of products that have never been sold.   use ... not in ( select product_id from order_details ) in your where clause
SELECT *
FROM products p
WHERE p.id NOT IN (
SELECT product_id from orderdetails
);

-- question 0.7
-- are there any customers that have never made an order
SELECT *
FROM customers c
WHERE c.id NOT IN (
SELECT customer_id FROM orders
);

-- Question 1
-- How many customer are handled by each office.  I want to see the office name and the count of the number of customers in that office.
SELECT e.office_id,  COUNT(*) "Active Customers"
FROM employees e, customers c
WHERE c.sales_rep_employee_id = e.id
GROUP BY e.office_id;
-- Question 2
-- I want to see the products with the most margin at the top of the table.  Include the product name, buy price, msrp, and margin in the results.  Margin is calculated (MSPR - buy_price) 
SELECT p.product_name, 
p.buy_price, msrp, 
(p.msrp - p.buy_price) margin 
FROM products p
ORDER BY margin DESC
LIMIT 5;
-- Question 2.5
-- I want to see the top 5 customers in each state based on margin 
SELECT *
FROM(
SELECT  c.state, RANK() OVER(PARTITION BY c.state ORDER BY sum((p.msrp - p.buy_price) * od.quantity_ordered) DESC) state_rank, c.customer_name, c.id,
sum((p.msrp - p.buy_price) * od.quantity_ordered) total_margin
FROM customers c, orderdetails od, orders o, products p
WHERE c.id = o.customer_id AND o.id = od.order_id AND p.id = od.product_id AND c.country = 'USA'
GROUP BY c.id
)t
GROUP BY t.total_margin, t.customer_name, t.id
HAVING t.state_rank < 6
ORDER BY t.state, state_rank;

-- Question 3
--  I want to see the top 5 salesmen in the company based on the total amount sold
SELECT t.id, sum(t.total_margin)
from(
SELECT e.id, c.customer_name, sum(od.price_each * od.quantity_ordered) total_margin
FROM employees e, customers c, products p, orderdetails od, orders o
where c.sales_rep_employee_id = e.id and c.id = o.customer_id AND o.id = od.order_id AND p.id = od.product_id
GROUP BY e.id, c.customer_name
order by e.id)t
GROUP BY t.id
LIMIT 5;

-- Question 4
-- I want to see the top 5 salesmen based on overall profit (margin)
SELECT t.id, sum(t.total_margin)
from(
SELECT e.id, c.customer_name, sum((p.msrp - p.buy_price) * od.quantity_ordered) total_margin
FROM employees e, customers c, products p, orderdetails od, orders o
where c.sales_rep_employee_id = e.id and c.id = o.customer_id AND o.id = od.order_id AND p.id = od.product_id
GROUP BY e.id, c.customer_name
order by e.id)t
GROUP BY t.id
LIMIT 5;
-- Question 5 
-- I want to see all of the orders that happened in 2004.   You can use a function called year(order_date) = 2004
SELECT *
FROM orders
WHERE year(order_date) = 2004;
-- Question 6
-- I want to see the total amount of all orders grouped by the year
SELECT year(o.order_date), COUNT(*)
FROM orders o
GROUP BY year(o.order_date)
ORDER BY year(order_date) desc;
-- Question 7
-- I want to see the top 5 products based on quantity sold across all orders

-- question 7.5
-- how many times has each product appeared in an order reguardless of how many were purchased.

-- question 7.6
-- how many products would be out of stock baed on the amount sold acrosss tiem.  -- not sure if the data will spoort this .. basically 
-- looking for any product where the sum of the quantity sold is greater than the quantity in stock

-- question 7.9
-- I want to see the distinct order status ordered alphabetically

-- Question 8
-- I want to see the office name and the distinct product lines that have been sold in that office.  This will require joining almost all of the tables.  




