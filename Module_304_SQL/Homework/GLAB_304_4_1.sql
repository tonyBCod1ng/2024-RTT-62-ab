SELECT order_id, order_line_number, quantity_ordered * price_each
FROM    orderdetails
ORDER BY   quantity_ordered * price_each DESC;

SELECT 
    order_id,
    order_line_number,
    quantity_ordered * price_each AS subtotal
FROM orderdetails
ORDER BY subtotal DESC;

SELECT firstname, lastname, reports_to
FROM employees
ORDER BY reports_to;

SELECT firstname, lastname, reports_to
FROM    employees
ORDER BY reports_to DESC;
