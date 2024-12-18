drop database if exists db_constructora;
create database db_constructora;
use db_constructora;

create table if not exists tbl_usuario(
id_usuario int not null auto_increment,
primary key(id_usuario),
unique(id_usuario),
nombre varchar(100),
correo varchar(100),
pass varchar(100)
);

create table if not exists tbl_usuarioAdmin(
id_admin int not null auto_increment,
primary key(id_admin),
unique(id_admin),
nombre_admin varchar(100),
correo_admin varchar(100),
pass_admin varchar(50)
);

create table if not exists tbl_cliente(
id_cliente int not null auto_increment,
primary key(id_cliente),
unique(id_cliente),
NIT int(20),
DPI varchar(20),
nombre varchar(150),
telefono int(20),
direccion varchar(200)
);

create table if not exists tbl_config(
id_config int not null auto_increment,
primary key(id_config),
unique(id_config),
NIT int(25),
nombre varchar(255),
telefono int(11),
direccion varchar(200)
);

create table if not exists tbl_producto(
id_producto int not null auto_increment,
primary key(id_producto),
unique(id_producto),
codigo varchar(20),
descripcion varchar(150),
nombre varchar(200),
stock int(20),
precio double(255,2)
);

create table if not exists tbl_venta(
id_venta int not null auto_increment,
primary key(id_venta),
unique(id_venta),
cliente varchar(100),
vendedor varchar(100),
total double(255,2),
fecha varchar(20)
);

create table if not exists tbl_empresa(
id_empresa int not null auto_increment,
primary key(id_empresa),
unique(id_empresa),
nombre varchar(100),
telefono int(55),
correo varchar(100),
direccion varchar(200)
);

create table if not exists tbl_detalle(
id_detalle int not null auto_increment,
primary key(id_detalle),
unique(id_detalle),
cod_pro int(20),
cantidad int(20),
precio double(255,2),
id_de_venta int not null
);

show tables;

insert into tbl_usuario(id_usuario, nombre, correo, pass)
values
(1,'Miguel Yac','myac2022020@gmail.com','2019');

select * from tbl_usuario;

insert into tbl_usuarioAdmin(id_admin, nombre_admin, correo_admin, pass_admin)
values
(1,'Miguel Yac', 'myac@gmail.com','2019');

select * from tbl_usuarioAdmin;

insert into tbl_cliente(id_cliente,NIT,DPI,nombre,telefono,direccion)
values
(1,123456,'4533235474235','Miguel Yac',235454325,'Una casa con puertas y ventanas');

select * from tbl_cliente;

insert into tbl_producto(id_producto,codigo,descripcion,nombre,stock,precio)
values
(1,'001','Varilla de Hierro de 1/2 grado 40,6 mts','Hierro AGV','35',69.50);

select * from tbl_producto;

insert into tbl_venta(id_venta,cliente,vendedor,total,fecha)
values
(1,'Santiago Yac','Constructora OMEG4',1234.50,'25/22/2022');

select * from tbl_venta;

select * from tbl_detalle;

insert into tbl_empresa(id_empresa,nombre,telefono,correo,direccion)
values(1,'Constructora OMEG4',54672345,'OMEG4Cosntruccions@gmail.com','Travesía Palin, 539, Bajos');

select * from tbl_empresa;

select nombre from tbl_empresa;

delete from tbl_venta where id_venta =1;