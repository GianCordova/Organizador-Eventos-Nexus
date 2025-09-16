drop database if exists organizador_eventos_db;
create database organizador_eventos_db;
use organizador_eventos_db;

create table Usuarios (
	idUsuario int auto_increment,
	nombre varchar(100) not null,
	apellido varchar(128) not null,
	email varchar(100) not null unique,
	password varchar(255) not null,
	rol enum('cliente','administrador') default 'cliente',
	constraint pk_usuarios primary key (idUsuario)
);

create table Recursos (
	idRecurso int auto_increment,
	nombreRecurso varchar(128) not null,
	categoria enum('Mobiliario','Cubiertas y estructuras','Iluminacion','Sonido y multimedia','Decoracion','Cocina y catering','Entretenimiento','otro') default 'otro',
	stock int not null,
	precioAlquiler decimal(10,2) not null,
	constraint pk_recursos primary key (idRecurso)
);

create table Proveedores (
	idProveedor int auto_increment,
	nombreProveedor varchar(128) not null,
	servicio varchar(128) not null,
	contacto varchar(128),
	constraint pk_proveedores primary key (idProveedor)
);

create table Eventos (
	idEvento int auto_increment,
	nombreEvento varchar(100) not null,
	descripcion varchar(255) not null,
	fecha date not null,
	lugar varchar(100) not null,
	estado enum('pendiente','en progreso','completada') default 'pendiente',
	duracion time not null,
	tipoEvento enum('social','corporativo','cultural','recreativo','otro') default 'otro',
	costoEvento decimal(10, 2) not null,
	idUsuario int not null,
	constraint pk_eventos primary key (idEvento),
	constraint fk_eventos_usuarios foreign key (idUsuario)
		references Usuarios(idUsuario)
);

create table Invitados (
	idInvitado int auto_increment,
	nombre varchar(50) not null,
	apellido varchar(50) not null,
	correo varchar(100),
	telefono varchar(20),
	estadoAsistencia enum('pendiente','confirmado','rechazado') default 'pendiente',
	idEvento int not null,
	constraint pk_invitados primary key (idInvitado),
	constraint fk_invitados_eventos foreign key (idEvento)
		references Eventos(idEvento)
	);

create table DetalleRecursos (
	idDetalleRecurso int auto_increment,
	idEvento int not null,
	idRecurso int not null,
	cantidad int not null,
	constraint pk_detalle_recursos primary key (idDetalleRecurso),
	constraint fk_detalle_recursos_eventos foreign key (idEvento)
		references Eventos(idEvento),
	constraint fk_detalle_recursos_recursos foreign key (idRecurso)
		references Recursos(idRecurso)
);

create table DetalleProveedores (
	idDetalleProveedor int auto_increment,
	idEvento int not null,
	idProveedor int not null,
	costo decimal(10,2),
	observaciones varchar(255),
	constraint pk_detalle_proveedores primary key (idDetalleProveedor),
	constraint fk_detalle_proveedores_eventos foreign key (idEvento)
		references Eventos(idEvento),
	constraint fk_detalle_proveedores_proveedores foreign key (idProveedor)
		references Proveedores(idProveedor)
);