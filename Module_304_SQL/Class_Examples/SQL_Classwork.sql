SELECT customer_name, state 
FROM customers 
WHERE country = 'Japan' 
ORDER BY customer_name;

INSERT INTO customers VALUE(246, 'A123456', '2005-01-01', 40000.00);

UPDATE payments 
SET amount = 50000.00 
WHERE payments.customer_id = 112 
AND payment_date = '2005-01-01';

SELECT * FROM offices;

SELECT customer_id "Customer Id", 
check_number "Check #" ,
amount "Amount Spent" 
FROM payments 
WHERE payment_date 
BETWEEN '2003-03-03' AND '2005-12-01';

SELECT e.* 
FROM employees e, offices o 
WHERE  e.office_id = o.id AND NOT o.country = 'USA' AND NOT o.country = 'JAPAN';

SELECT * FROM orders;
SELECT od.* , (quantity_ordered * price_each) "Total Price", 
p.product_name "Product Name", 
o.order_date AS "Date Ordered", 
c.customer_name 'Name' 
FROM orderdetails od, products p, orders o, customers c 
WHERE od.product_id = p.id AND o.id = od.order_id AND c.id = o.customer_id 
ORDER BY order_line_number;
SELECT sum(quantity_ordered * price_each) total_order_price,
min(quantity_ordered) as min_quantity_ordered,
max(quantity_ordered) as max_quantity_ordered,
avg(quantity_ordered * price_each) average_line_cost,
avg(quantity_ordered) avg_quantity_ordered
FROM orderdetails od
WHERE od.order_id = 10103;



SELECT order_id, sum(quantity_ordered * price_each) total_order_cost,
min(quantity_ordered) as min_qty_ordered,
count(*) as number_of_products
FROM orderdetails
GROUP BY order_id;

SELECT c.customer_name, o.id order_id 
from customers c, orders o where c.id = o.customer_id
ORDER BY c.customer_name;

SELECT c.customer_name, o.id order_id, od.product_id 
from customers c, orders o, orderdetails od where c.id = o.customer_id and od.order_id = o.id
ORDER BY customer_name, order_id, product_id;

SELECT c.customer_name, o.id order_id, od.product_id, price_each, (quantity_ordered * price_each) total_line_cost
from customers c, orders o, orderdetails od where c.id = o.customer_id and od.order_id = o.id
ORDER BY customer_name, order_id, product_id;

SELECT c.id,c.customer_name ,sum(quantity_ordered * price_each) total_customer_spend
from customers c, orders o, orderdetails od where c.id = o.customer_id and od.order_id = o.id
GROUP BY c.id
ORDER BY total_customer_spend desc;

SELECT c.id,c.customer_name, o.id order_id ,sum(quantity_ordered * price_each) total_customer_spend
from customers c, orders o, orderdetails od where c.id = o.customer_id and od.order_id = o.id
GROUP BY c.id, o.id
ORDER BY c.customer_name;


SELECT c.id,c.customer_name, o.id order_id ,sum(quantity_ordered * price_each) total_customer_spend
from customers c, orders o, orderdetails od where c.id = o.customer_id and od.order_id = o.id
GROUP BY c.id, o.id
HAVING total_customer_spend > 50000
ORDER BY c.customer_name;

