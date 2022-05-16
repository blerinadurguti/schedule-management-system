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
Emri varchar(50),
primary key(Id)
);

insert into Lendet(Emri) values
("Gjuhe Angleze"),
("Shkathtesi Komunikuese"),
("Gjuhe programuese"),
("Matematike 1"),
("Fizike 1:"),
("Bazat e elektronikes"),
("Algoritmet dhe struktura e te dhenave"),
("Qarqe digjitale"),
("Fizike 2"),
("Matematike 2"),
("Qarqet elektrike"),
("Bazat e te dhenave"),
("Elektronike"),
("Sinjale dhe sisteme"),
("Matematike 3K"),
("Interneti"),
("Programimi i orientuar ne objekte"),
("Programimi ne internet"),
("Rrjetat kompjuterike"),
("Siguria e te dhenave"),
("Komunikimi njeri-kompjuter"),
("Arkitektura e kompjutereve"),
("Menaxhimi i projekteve"),
("Matjet Elektrike"),
("Automatike"),
("Matematike 3E"),
("Materialet elektroteknike"),
("Centralet elektrike"),
("Instrumentacion mates"),
("Fushat dhe valet"),
("Makina elektrike 1"),
("Komponentet elektronike"),
("Elektroenergjetike"),
("Telekomunikacion"),
("Fushat dhe valet elektromagnetike"),
("Ndermarresi"),
("Mikroprocesoret dhe mikrokontrolleret"),
("Modeli i te dhenave dhe gjuhet e pyetesoreve"),
("Internet Security"),
("Inxhinieri Softuerike"),
("Sisteme Operative"),
("Data Mining"),
("Praktika e Rrjetave kompjuterike"),
("Sistemet e shperndara"), 
("Programimi i pajisjeve mobile"),
("Bazat e inteligjences artificiale"), 
("Information retrevial"),
("Praktika profesionale"),
("Instalimet elektrike"),
("Elektronika Energjetike"),
("Energjia dhe Mjedisi"),
("Stabilimentet Elektroenergjetike"),
("Makinat elektrike 2"),
("Bartja dhe shperndarja e energjise elektrike"),
("Aplikacionet softuerike ne SEE-Matlab"),
("Burimet e energjise se riperteritshme"),
("Dinamika e punes se centraleve elektrike"),
("Makinat Elektrike Speciale"),
("Ngasjet Elektrike"),
("Tregu i Energjise"),
("Mbrojtje Rele"),
("Sistemet digjitale te rregullimit"),
("Komunikimet ne automatike"),
("Dirigjuesit e programueshem logjik(PLC)"),
("Senzoret dhe aktuatoret"),
("Aktuatoret e mencur dhe ngasjet"),
("Senzoret e mencur"),
("Modelimi dhe simulimi"),
("Sistemet jolineare te rregullimit"),
("Rregullimi i proceseve kimike"),
("Proceset e vazhduara dhe grupore"),
("Rregullimi ne kohe reale"),
("Automatizimi i objekteve te banimit"),
("Bazat e robotikes"), 
("Komunikimet elektronike"),
("Instrumentacioni mates dhe DAQ"),
("Elektronika digjitale"),
("Optoelektronika"),
("Perpunimi digjital i sinjaleve"),
("Teknologjia e komunikimeve optike"),
("Mikroelektronika"),
("Projektimi i sistemeve elektronike me kompjuter"),
("Elektronika analoge"),
("Bazat e multimedias"),
("Bazat e robotikes"),
("Hyrja ne bioelektromagnetike"),
("Komunikimet mobile"),
("Mikrovale dhe antena"),
("Televizioni digjital"),
("Sistemet transmetuese"),
("Transmetimi i te dhenave"),
("Qarqet komunikuese analoge"),
("Sistemet e shperndara"),
("Protokollet komunikuese"),
("Sistemet komutuese"),
("Rrjetet telekomunikuese");

select * from lendet;


create table StafiAkademik(
Id integer not null auto_increment,
Emri varchar(30),
Mbiemri varchar(30),
Pozita varchar(10),
primary key(Id)
);

insert into stafiakademik (emri, mbiemri, pozita) values
("Blerim", "Rexha", "Profesor i rregullt"),
("Enver", "Hamiti", "Profesor i rregullt"),
("Luan", "Ahma", "Profesor i rregullt"),
("Lule", "Ahmedi", "Profesor i rregullt"),
("Marjan", "Dema", "Profesor i rregullt"),
("Sabrije", "Osmanaj", "Profesor i rregullt"),
("Bujar", "Krasniqi", "Profesor i asocuar"),
("Isak", "Shabani", "Profesor i asocuar"),
("Kadri", "Sylejmani", "Profesor i asocuar"),
("Milaim", "Zabeli", "Profesor i asocuar"),
("Mimoza", "Ibrani", "Profesor i asocuar"),
("Qamil", "Kabashi", "Profesor i asocuar"),
("Qefsere", "Gjonbalaj", "Profesor i asocuar"),
("Shqipe", "Lohaj", "Profesor i asocuar"),
("Arben", "Gjukaj", "Profesor asistent"),
("Avni", "Rexhepi", "Profesor asistent"),
("Bahri", "Prebeza", "Profesor asistent"),
("Dhurate", "Hyseni", "Profesor asistent"),
("Drilon", "Bunjaku", "Profesor asistent"),
("Hena", "Maloku Berzati", "Profesor asistent"),
("Lavdim", "Kurtaj", "Profesor asistent"),
("Valdete", "Rexhebeqaj-Hamiti", "Profesor asistent"),
("Valon", "Raca", "Profesor asistent"),
("Vezir", "Rexhepi", "Profesor asistent"),
("Vjosa", "Shatri", "Profesor asistent"),
("Zana", "Limani-Faziu", "Profesor asistent"),
("Adrian", "Ymeri", "Asistent"),
("Arben", "Mashkulli", "Asistent"),
("Blend", "Arifaj", "Asistent"),
("Blerta", "Selimaj-Haziri", "Asistent"),
("Daline", "Vranovci", "Asistent"),
("Enkele", "Rama", "Asistent"),
("Jeta", "Dobruna", "Asistent"),
("Kushtrim", "Prodrimqaku", "Asistent"),
("Labeat", "Arbneshi", "Asistent"),
("Mergim", "Hoti", "Asistent"),
("Nuri", "Berisha", "Asistent"),
("Petrit", "Emini", "Asistent"),
("Rreze", "Halili", "Asistent"),
("Valon", "Veliu", "Asistent"),
("Adnan", "Maxhuni", "Profesoret/Asistentet e angazhuar"),
("Arben", "Lekaj", "Profesoret/Asistentet e angazhuar"),
("Arbnor", "Halili", "Profesoret/Asistentet e angazhuar"),
("Dardan", "Shabani", "Profesoret/Asistentet e angazhuar"),
("Doruntine", "Berisha", "Profesoret/Asistentet e angazhuar"),
("Driton", "Statovci", "Profesoret/Asistentet e angazhuar"),
("Fatos", "Peci", "Profesoret/Asistentet e angazhuar"),
("Gazmend", "Pula", "Profesoret/Asistentet e angazhuar"),
("Idriz", "Smaili", "Profesoret/Asistentet e angazhuar"),
("Ilir", "Gashi", "Profesoret/Asistentet e angazhuar"),
("Isak", "Kerolli", "Profesoret/Asistentet e angazhuar"),
("Kadrije", "Simnica-Aliu", "Profesoret/Asistentet e angazhuar"),
("Nysret", "Avdiu", "Profesoret/Asistentet e angazhuar"),
("Nysret", "Musliu", "Profesoret/Asistentet e angazhuar"),
("Ramadan", "Plakolli", "Profesoret/Asistentet e angazhuar"),
("Salem", "Lepaja", "Profesoret/Asistentet e angazhuar"),
("Skender", "Ahmetaj", "Profesoret/Asistentet e angazhuar"),
("Vjollca", "Komoni", "Profesoret/Asistentet e angazhuar"),
("Yllka", "Delija", "Profesoret/Asistentet e angazhuar"),
("Yllka", "Kabashi", "Profesoret/Asistentet e angazhuar"),
("Zenun", "Kastrati", "Profesoret/Asistentet e angazhuar"),
("Besmir", "Sejdiu", "Profesoret/Asistentet e angazhuar"),
("Haxhi", "Dacaj", "Profesoret/Asistentet e angazhuar"),
("Sevdie", "Alshiqi", "Profesoret/Asistentet e angazhuar");

select * from stafiakademik;
alter table stafiakademik
auto_increment=1;

create table Salla(
Id integer not null auto_increment,
Emri varchar(10),
primary key(Id)
);

insert into salla (Emri) values
("A3"),
("A408"),
("A411"),
("201"),
("310"),
("311"),
("611"),
("621"),
("626"),
("629"),
("636"),
("745");

select * from salla;

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

