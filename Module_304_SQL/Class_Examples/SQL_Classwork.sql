SELECT customer_number 
AS ID, customer_name, state 
FROM customers 
WHERE country = 'Japan' 
ORDER BY customer_number;

INSERT INTO customers VALUE(246, 'A123456', '2005-01-01', 40000.00);

UPDATE payments 
SET amount = 50000.00 
WHERE customer_number = 112 
AND payment_date = '2005-01-01';

SELECT * FROM offices;

SELECT customer_number "Customer Id", 
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

SELECT sum(total_order_cost) grand_total
FROM(
SELECT order_id, sum(quantity_ordered * price_each) total_order_cost,
min(quantity_ordered) as min_qty_ordered,
count(*) as number_of_products
FROM orderdetails
GROUP BY order_id
);
