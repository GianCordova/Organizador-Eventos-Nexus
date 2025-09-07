drop database if exists organizadoreventosnexus_db;
create database organizadoreventosnexus_db;
use organizadoreventosnexus_db;

create table Usuario (
    idUsuario int auto_increment,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    correo varchar(100) unique not null,
    contrasena varchar(100) not null,
    rol enum('administrador','organizador','invitado') not null,
    constraint pk_usuario primary key (idUsuario)
);

create table Evento (
    idEvento int auto_increment,
    nombreEvento varchar(100) not null,
    descripcion text,
    fecha date not null,
    lugar varchar(100) not null,
    idUsuario int not null,
    constraint pk_evento primary key (idEvento),
    constraint fk_evento_usuario foreign key (idUsuario) references Usuario(idUsuario)
);

create table Invitado (
    idInvitado int auto_increment,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    correo varchar(100),
    telefono varchar(20),
    estadoAsistencia enum('pendiente','confirmado','rechazado') default 'pendiente',
    idEvento int not null,
    constraint pk_invitado primary key (idInvitado),
    constraint fk_invitado_evento foreign key (idEvento) references Evento(idEvento)
);

create table Tarea (
    idTarea int auto_increment,
    descripcion text not null,
    estado enum('pendiente','en progreso','completada') default 'pendiente',
    fechaLimite date,
    idEvento int not null,
    idUsuario int,
    constraint pk_tarea primary key (idTarea),
    constraint fk_tarea_evento foreign key (idEvento) references Evento(idEvento),
    constraint fk_tarea_usuario foreign key (idUsuario) references Usuario(idUsuario)
);

create table Actividad (
    idActividad int auto_increment,
    nombreActividad varchar(100) not null,
    horaInicio time not null,
    horaFin time not null,
    idEvento int not null,
    constraint pk_actividad primary key (idActividad),
    constraint fk_actividad_evento foreign key (idEvento) references Evento(idEvento)
);

create table Recurso (
    idRecurso int auto_increment,
    tipoRecurso varchar(50) not null,
    descripcion text,
    idEvento int not null,
    constraint pk_recurso primary key (idRecurso),
    constraint fk_recurso_evento foreign key (idEvento) references Evento(idEvento)
);
