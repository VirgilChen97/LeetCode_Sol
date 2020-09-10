# Write your MySQL query statement below
select a.Id
from Weather a,
     Weather b
where a.RecordDate in (select interval 1 day + b.RecordDate)
    and a.Temperature > b.Temperature;