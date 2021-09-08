use HW;

insert into Product (pcode,pname,price) value (1,'SAMSUNG TV',500000);
insert into Product (pcode,pname,price) value (2,'NoteBook',5000000);
insert into Product (pcode,pname,price) value (3,'LG TV',500000);
insert into Product (pcode,pname,price) value (4,'LG NoteBook',770000);
insert into Product (pcode,pname,price) value (5,'SAMSUNG NoteBook',120000);

select pcode , pname, round(price/100 * 75) from Product;

update Product set price = round(Product.price/100 *80) where pname like "%TV%";
select * from Product;

select sum(price) from Product;