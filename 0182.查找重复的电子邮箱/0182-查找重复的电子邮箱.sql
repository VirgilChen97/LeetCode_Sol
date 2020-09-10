# Write your MySQL query statement below
select Email
from
    (select Id, Email, count(Email) as e 
     from Person group by Email
    ) as x
where x.e > 1;