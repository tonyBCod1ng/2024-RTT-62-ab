-- for this we can use the format function 
select p.product_name, format(max(quantity_ordered),2) as max_offer, format(min(quantity_ordered),2) as min_buy_price, 
format(round(avg(quantity_ordered),2),2) as avg_buy_price, count(*) as product_count
from products p, orderdetails od
where p.id = od.product_id
group by od.product_id;