create table ssafy_product
(
    idx int not null auto_increment,
    product_id varchar(7) not null,
    product_name varchar(20) not null,
    product_price int default 0,
    product_desc varchar(2000),
    register_date timestamp not null default current_timestamp,
    primary key (idx)
);