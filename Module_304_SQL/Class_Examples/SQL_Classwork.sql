SELECT customer_number AS ID, customer_name AS Name, state AS State FROM customers AS test WHERE country = 'Japan' ORDER BY customer_number;
INSERT INTO customers VALUE(246, 'A123456', '2005-01-01', 40000.00);
UPDATE payments SET amount = 50000.00 WHERE customer_number = 112 AND payment_date = '2005-01-01';
SELECT * FROM offices;
SELECT customer_number "Customer Id", check_number "Check #" ,amount "Amount Spent" FROM payments WHERE payment_date BETWEEN '2003-03-03' AND '2005-12-01';
SELECT e.* FROM employees e, offices o WHERE  e.office_id = o.id AND NOT o.country = 'USA' AND NOT o.country = 'JAPAN';
SELECT * FROM orders;
SELECT od.* , (quantity_ordered * price_each) "Total Price", p.product_name "Product Name", o.order_date AS "Date Ordered", c.customer_name 'Name' FROM orderdetails od, products p, orders o, customers c WHERE od.product_id = p.id AND o.id = od.order_id AND c.id = o.customer_id ORDER BY order_line_number
