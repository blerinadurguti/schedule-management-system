create database smo;
use smo;

create table VitiAkademik(
Id integer not null auto_increment,
Viti varchar(10),
primary key(Id)
);

insert into vitiakademik(Viti)values
("Viti 1"),
("Viti 2"),
("Viti 3");


create table Grupet(
Id integer not null auto_increment,
Emri varchar(10),
a_b varchar(1),
Viti integer,
primary key(Id)
);

insert into grupet(Emri, a_b, Viti)values
("Grupi 1", "A", 1),
("Grupi 1", "B", 1),
("Grupi 2", "A", 1),
("Grupi 2", "B", 1),
("Grupi 3", "A", 1),
("Grupi 3", "B", 1),
("Grupi 4", "A", 1),
("Grupi 4", "B", 1),
("Grupi 5", "A", 1),
("Grupi 5", "B", 1),
("Grupi 1", "A", 2),
("Grupi 1", "B", 2),
("Grupi 2", "A", 2),
("Grupi 2", "B", 2),
("Grupi 1", "A", 3),
("Grupi 1", "B", 3),
("Grupi 2", "A", 3),
("Grupi 2", "B", 3);


create table Drejtimi(
Id integer not null auto_increment,
Emri varchar(40),
primary key(Id)
);

insert into Drejtimi(Emri)values
("Automatikë e Kompjuterizuar dhe Robotikë"),
("Elektroenergjetikë"),
("Elektronikë"),
("Inxhinieri Kompjuterike"),
("Telekomunikacion");


create table Studenti(
Id integer not null auto_increment,
Emri varchar(15),
Mbiemri varchar(15),
StudentId varchar(30),
Drejtimi integer,
Viti integer,
Grupi integer,
Primary Key(Id),
foreign key(Drejtimi) references drejtimi(ID),
foreign key(Viti) references vitiakademik(ID),
foreign key(Grupi) references Grupet(Id));

insert into studenti (Emri, Mbiemri) value
("Admin","Admin");

create table User(
Id integer not null,
Username varchar(100),
SaltedHash varchar(256),
Salted varchar(100),
primary key(Id),
foreign key(Id)references Studenti(Id)
);

insert into User(Id,Username,SaltedHash,Salted) value
(1,"admin","1966c0c9281ce8b3d199fe7c2b1a1f49b8e461b80e3a12dda06f0d214ff2ee5f","hsZxr8V2rZOPz6rlE4yfLoGxlIvHwVf36hsXH7XdZrkqjR3rVc8oklwDb1gWIuq0");

create table Lendet(
Id integer not null auto_increment,
Emri varchar(30),
primary key(Id)
);

create table StafiAkademik(
Id integer not null auto_increment,
Emri varchar(30),
Mbiemri varchar(30),
Pozita varchar(10),
primary key(Id)
);

create table Salla(
Id integer not null auto_increment,
Emri varchar(10),
primary key(Id)
);


create table Oraret(
Id integer not null auto_increment,
Profesori_Asistenti integer,
Grupi integer,
Koha time,
dita integer,
primary key(Id),
foreign key(Profesori_Asistenti) references StafiAkademik(Id),
foreign key(Grupi) references Grupet(Id)
);

