--insert into exchange_value(id,from_code,to_code,conversion_multiple,port) values(1,'USD','INR',65,0);
--insert into exchange_value(id,from_code,to_code,conversion_multiple,port) values(2,'USD','EUR',70,0);
--insert into exchange_value(id,from_code,to_code,conversion_multiple,port) values(3,'AUS','INR',25,0);

--insert into countries(id,country_code,country_name)  values(101,'USD','USA');
--insert into countries(id,country_code,country_name)  values(102,'USD','USA');

insert into student(s_id,name) values(101,'Kumar');
insert into student(s_id,name) values(102,'RamKumar');

insert into school(sl_id,address,name,s_id) values(201,'Erode','GBHSS',101);
insert into school(sl_id,address,name,s_id) values(202,'Tiruchengode','GBHSS',101);
insert into school(sl_id,address,name,s_id) values(203,'Tiruchengode','GBHSS',102);