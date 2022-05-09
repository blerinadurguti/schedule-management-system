create database SMO;
use SMO;
drop database SMO;
-- SMO -> Sistemi per Menaxhimin e Orareve

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

select * from User;
select * from studenti;
select * from grupet;

create table Grupet(
Id integer not null auto_increment,
Emri varchar(50),
Viti integer,
primary key(Id)
);

create table Lendet(
Id integer not null auto_increment,
Emri varchar(50),
primary key(Id)
);

create table StafiAkademik(
Id integer not null auto_increment,
Emri varchar(50),
Mbiemri varchar(50),
Pozita varchar(50),
primary key(Id)
);

create table Salla(
Id integer not null auto_increment,
Emri varchar(50),
primary key(Id)
);

create table AssignedSubjectTeacher(
Id integer not null auto_increment,
LendetId integer,
StafiAkademikIdProfesori integer,
StafiAkademikIdAsistenti integer,
SallaId integer,
primary key(Id),
foreign key(LendetId) references Lendet(Id),
foreign key(StafiAkademikIdProfesori) references StafiAkademik(Id),
foreign key(StafiAkademikIdAsistenti) references StafiAkademik(Id),
foreign key(SallaId) references Salla(Id)
);

create table Drejtimi(
Id integer not null auto_increment,
Emri varchar(50),
primary key(Id)
);

select * from drejtimi;

insert into Drejtimi(Emri)values
("Automatikë e Kompjuterizuar dhe Robotikë"),
("Elektroenergjetikë"),
("Elektronikë"),
("Inxhinieri Kompjuterike"),
("Telekomunikacion");

create table VitiAkademik(
Id integer not null auto_increment,
Viti varchar(10),
primary key(Id)
);

select * from vitiakademik;

insert into vitiakademik(Viti)values
("Viti 1"),
("Viti 2"),
("Viti 3");

create table AssignedSubjectDrejtimi(
Id integer not null auto_increment,
DrejtimiId integer,
VitiAkademikId integer,
primary key(Id),
foreign key(DrejtimiId) references Drejtimi(Id),
foreign key(VitiAkademikId) references VitiAkademik(Id)
);

create table Oraret(
Id integer not null auto_increment,
Orari varchar(30),
primary key(Id)
);

create table Assigned(
Id integer not null auto_increment,
GrupetId integer,
LendetId integer,
OraretId integer,
primary key(Id),
foreign key(Id) references Grupet(Id),
foreign key(Id) references Lendet(Id),
foreign key(Id) references Oraret(Id)
);

create table Studenti(
Id integer not null auto_increment,
Emri varchar(15),
Mbiemri varchar(15),
Viti integer,
Grupi integer,
Primary Key(Id),
foreign key(Grupi) references Grupet(Id));

alter table Studenti add column Drejtimi integer after Mbiemri;
alter table Studenti add foreign key(Drejtimi) references drejtimi(Id);
alter table Studenti add column StudentId varchar(30) after Mbiemri;

insert into studenti (Emri, Mbiemri) value
("Admin","Admin");

select * from studenti;
select * from user;
