# Write your MySQL query statement below
-- select * from Cinema
-- where id%2!=0 and description!="boring"
-- order by rating desc ;
SELECT * FROM Cinema
WHERE id%2!= 0 and description != "boring"
ORDER BY rating DESC;