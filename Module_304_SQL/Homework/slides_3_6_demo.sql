SELECT
	T1.product_code,
	T1.product_name ,
	T2.description
FROM
	products T1
INNER JOIN productlines T2 ON
	T1.productline_id = T2.id;

SELECT
	T1.id,
	STATUS,
	SUM(quantity_ordered * price_each) total
FROM
	orders AS T1
INNER JOIN orderdetails AS T2 ON
	T1.id = T2.order_id
GROUP BY
	T1.id;

SELECT
	od.order_id,
	o.order_date,
	od.order_line_number,
	p.product_name,
	od.quantity_ordered,
	od.price_each
FROM
	orders o
INNER JOIN orderdetails od ON
	o.id = order_id
INNER JOIN products p ON
	p.id = od.product_id
ORDER BY
	o.id ,
	od.order_line_number;

SELECT
	order_id,
	SUM(price_each * quantity_ordered) as total
FROM
	orderdetails od
INNER JOIN orders o ON
	o.id = od.order_id
GROUP BY
	o.id
HAVING
	SUM(od.price_each * od.quantity_ordered) > 60000;
-- Problem statement: Write a query to display the customer number, customer name, order number, order date, product code, product name, and price.
-- You can use the JOIN, GROUP By, and HAVING  clauses.

SELECT
	o.customer_id,
	c.customer_name,
	o.id order_id,
	o.order_date,
	p.id,
	p.product_name,
	p.buy_price
FROM
	customers c
INNER JOIN orders o ON
	c.id = o.customer_id
INNER JOIN orderdetails od ON
	o.id = od.order_id
INNER JOIN products p ON
	p.id = od.product_id
GROUP BY
	od.id;
