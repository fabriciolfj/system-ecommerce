CREATE table cart (
id bigserial primary key not null,
code varchar(255) not null,
customer varchar(255) not null,
total numeric(15,4) not null,
status varchar(255) not null
);

CREATE table cartitems (
id bigserial primary key not null,
cart_id bigserial not null,
product varchar(255) not null,
amount bigint not null,
price numeric(15,4) not null,
foreign key (cart_id) references cart (id)
);