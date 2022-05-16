use SMO;

drop table if exists User;
drop table if exists Studenti;
drop table if exists Grupet;
drop table if exists Lendet;
drop table if exists StafiAkademik;
drop table if exists Salla;
drop table if exists AssignedSubjectDrejtimi;
drop table if exists Drejtimi;
drop table if exists VitiAkademik;
drop table if exists Oraret;
drop table if exists Assigned;
drop table if exists AssignedSubjectTeacher;

-- SMO -> Sistemi per Menaxhimin e Orareve
use SMO;
create table Grupet(
Id integer not null auto_increment,
Emri varchar(50),
Viti integer,
primary key(Id)
);

create table Studenti(
Id integer not null auto_increment,
Emri varchar(15),
Mbiemri varchar(15),
Viti integer,
Grupi integer,
Primary Key(Id),
foreign key(Grupi) references Grupet(Id));

create table User(
Id integer not null,
Username varchar(100),
SaltedHash varchar(256),
Salted varchar(100),
primary key(Id),
foreign key(Id)references Studenti(Id)
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

create table Drejtimi(
Id integer not null auto_increment,
Emri varchar(50),
primary key(Id)
);

create table VitiAkademik(
Id integer not null auto_increment,
Viti varchar(10),
primary key(Id)
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

create table AssignedSubjectDrejtimi(
Id integer not null auto_increment,
DrejtimiId integer,
VitiAkademikId integer,
primary key(Id),
foreign key(DrejtimiId) references Drejtimi(Id),
foreign key(VitiAkademikId) references VitiAkademik(Id)
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


alter table Studenti add column Drejtimi integer after Mbiemri;
alter table Studenti add foreign key(Drejtimi) references drejtimi(Id);
alter table Studenti add column StudentId varchar(30) after Mbiemri;
alter table stafiakademik auto_increment=1;
