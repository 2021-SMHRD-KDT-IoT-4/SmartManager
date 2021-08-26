select * from DETAIL_INFO;
select * from MEMBERS;
select * from output;

select*from K_DETAIL_INFO;
select*from Z_DETAIL_INFO;

insert into OUTPUT values(11,to_date(sysdate,'yyyy.mm.dd'),200);
SELECT date_search,sum(prod) FROM OUTPUT group by date_search;
select * from output;