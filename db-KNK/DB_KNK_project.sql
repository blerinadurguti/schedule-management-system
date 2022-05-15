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

insert into Lendet(Id, Emri) values
(1, "Gjuhe Angleze"),
(2, "Shkathtesi Komunikuese"),
(3, "Gjuhe programuese"),
(4, "Matematike 1"),
(5, "Fizike 1:"),
(6, "Bazat e elektronikes"),
(7, "Algoritmet dhe struktura e te dhenave"),
(8, "Qarqe digjitale"),
(9, "Fizike 2"),
(10, "Matematike 2"),
(11, "Qarqet elektrike"),
(12, "Bazat e te dhenave"),
(13, "Elektronike"),
(14, "Sinjale dhe sisteme"),
(15, "Matematike 3K"),
(16, "Interneti"),
(17, "Programimi i orientuar ne objekte"),
(18, "Programimi ne internet"),
(19, "Rrjetat kompjuterike"),
(20, "Siguria e te dhenave"),
(21, "Komunikimi njeri-kompjuter"),
(22, "Arkitektura e kompjutereve"),
(23, "Menaxhimi i projekteve"),
(24, "Matjet Elektrike"),
(25, "Automatike"),
(26, "Matematike 3E"),
(27, "Materialet elektroteknike"),
(28, "Centralet elektrike"),
(29, "Instrumentacion mates"),
(30, "Fushat dhe valet"),
(31, "Makina elektrike 1"),
(32, "Komponentet elektronike"),
(33, "Elektroenergjetike"),
(34, "Telekomunikacion"),
(35, "Fushat dhe valet elektromagnetike"),
(36, "Ndermarresi"),
(37, "Mikroprocesoret dhe mikrokontrolleret"),
(38, "Modeli i te dhenave dhe gjuhet e pyetesoreve"),
(39, "Internet Security"),
(40, "Inxhinieri Softuerike"),
(41, "Sisteme Operative"),
(42, "Data Mining"),
(43, "Praktika e Rrjetave kompjuterike"),
(44, "Sistemet e shperndara"), 
(45, "Programimi i pajisjeve mobile"),
(46, "Bazat e inteligjences artificiale"), 
(47, "Information retrevial"),
(48, "Praktika profesionale"),
(49, "Instalimet elektrike"),
(50, "Elektronika Energjetike"),
(51, "Energjia dhe Mjedisi"),
(52, "Stabilimentet Elektroenergjetike",
(53, "Makinat elektrike 2"),
(54, "Bartja dhe shperndarja e energjise elektrike"),
(55, "Aplikacionet softuerike ne SEE-Matlab"),
(56, "Burimet e energjise se riperteritshme"),
(57, "Dinamika e punes se centraleve elektrike"),
(58, "Makinat Elektrike Speciale"),
(59, "Ngasjet Elektrike"),
(60, "Tregu i Energjise"),
(61, "Mbrojtje Rele"),
(62, "Sistemet digjitale te rregullimit"),
(63, "Komunikimet ne automatike"),
(64, "Dirigjuesit e programueshem logjik(PLC)"),
(65, "Senzoret dhe aktuatoret"),
(66, "Aktuatoret e mencur dhe ngasjet"),
(67, "Senzoret e mencur"),
(68, "Modelimi dhe simulimi"),
(69, "Sistemet jolineare te rregullimit"),
(70, "Rregullimi i proceseve kimike"),
(71, "Proceset e vazhduara dhe grupore"),
(72, "Rregullimi ne kohe reale"),
(73, "Automatizimi i objekteve te banimit"),
(74, "Bazat e robotikes"), 
(75, "Komunikimet elektronike"),
(76, "Instrumentacioni mates dhe DAQ"),
(77, "Elektronika digjitale"),
(78, "Optoelektronika"),
(79, "Perpunimi digjital i sinjaleve"),
(80, "Teknologjia e komunikimeve optike"),
(81, "Mikroelektronika"),
(82, "Projektimi i sistemeve elektronike me kompjuter"),
(83, "Elektronika analoge"),
(84, "Bazat e multimedias"),
(85, "Bazat e robotikes"),
(86, "Hyrja ne bioelektromagnetike"),
(87, "Komunikimet mobile"),
(88, "Mikrovale dhe antena"),
(89, "Televizioni digjital"),
(90, "Sistemet transmetuese"),
(91, "Transmetimi i te dhenave"),
(92, "Qarqet komunikuese analoge"),
(93, "Sistemet e shperndara"),
(94, "Protokollet komunikuese"),
(95, "Sistemet komutuese"),
(96, "Rrjetet telekomunikuese"));


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

