select
	c.customer_name as 'Customer Name',
	concat(e.lastName, ', ', e.firstName) as 'Sales Rep'
from
	customers c
JOIN employees e 
on
	c.sales_rep_employee_id = e.id
order by
	c.customer_name asc;

select
	p.product_name as 'Product Name',
	sum(od.quantity_ordered) as 'Total # Ordered',
	sum(od.quantity_ordered * od.price_each) as 'Total Sale'
from
	products p
LEFT JOIN orderdetails od 
on
	p.id = od.product_id
group by
	p.id ,
	p.buy_price
order by
	3 desc;

select
	status as 'Order Status',
	count(status) as 'Total Orders'
from
	orders
group by
	status
order by
	status;

select
	pl.product_line as 'Product Line',
	count(od.product_id) as 'total Sold'
from
	productlines pl
join products p 
on
	pl.id = p.productline_id
JOIN orderdetails od on
	p.id = od.product_id
group by
	pl.id
order by
	2 desc;

select
	monthname(payment_date) AS Month,
	year(payment_date) AS Year,
	format(sum(amount), 2) AS 'Payments Received'
from
	payments
group by
	year(payment_date),
	monthname(payment_date)
order by
	payment_date;

SELECT
	p.product_name Name,
	l.product_line  AS `Product Line`,
	p.product_scale AS `Scale`,
	p.product_vendor AS `Vendor`
FROM
	productlines l
NATURAL JOIN products p
WHERE
	l.product_line IN( 'Classic Cars', 'Vintage Cars')
ORDER BY
	l.product_line DESC,
	p.product_name ASC;
