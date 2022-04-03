create database SistemiPerMenaxhimTeOrareve;
use SistemiPerMenaxhimTeOrareve;

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

create table VitiAkademik(
Id integer not null auto_increment,
Viti integer,
primary key(Id)
);

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
Email varchar(30),
Viti integer,
Grupi integer,
Primary Key(Id),
foreign key(Grupi) references Grupet(Id));

create table User(
Id integer not null auto_increment,
Username varchar(100),
SaltedHash varchar(256),
Salted varchar(100),
primary key(Id),
foreign key(Id)references Studenti(Id)
);
