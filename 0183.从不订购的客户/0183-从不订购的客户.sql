# Write your MySQL query statement below
select c.Name as Customers 
from Customers as c
where c.Id not in 
    (select n.CustomerId
     from 
        (select CustomerId, c.Id, Name from 
            Orders o,
            Customers c
         where c.Id = CustomerId
        ) as n
    );