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
Emri varchar(50),
Mbiemri varchar(50),
Pozita varchar(50),
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
