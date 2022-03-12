create database orari;
use orari;

create table grupet(
gid integer not null auto_increment,
emri varchar(50),
viti integer,
primary key(gid)
);

create table lendet(
lid integer not null auto_increment,
lname varchar(50),
primary key(lid)
);

create table profesori(
pid integer not null auto_increment,
panme varchar(50),
psname varchar(50),
primary key(pid)
);

create table asistent(
aid integer not null auto_increment,
aname varchar(50),
asname varchar(50),
primary key(aid)
);

create table salla(
sid integer not null auto_increment,
sname varchar(50),
primary key(sid)
);

create table assigned_subject_teacher(
a_s_id integer not null auto_increment,
lid integer,
pid integer,
aid integer,
sid integer,
primary key(a_s_id),
foreign key(lid) references lendet(lid),
foreign key(pid) references profesori(pid),
foreign key(aid) references asistent(aid),
foreign key(sid) references salla(sid)
);

create table drejtimi(
did integer not null auto_increment,
dname varchar(50),
primary key(did)
);

create table viti_akademik(
vid integer not null auto_increment,
viti integer,
primary key(vid)
);

create table assigned_subject_drejtimi(
a_s_d_id integer not null auto_increment,
did integer,
vid integer,
primary key(a_s_d_id),
foreign key(did) references drejtimi(did),
foreign key(vid) references viti_akademik(vid)
);

create table oraret(
oid integer not null auto_increment,
orari varchar(30),
primary key(oid)
);

create table assigned(
assigned_id integer not null auto_increment,
gid integer,
lid integer,
oid integer,
primary key(assigned_id),
foreign key(gid) references grupet(gid),
foreign key(lid) references lendet(lid),
foreign key(oid) references oraret(oid)
);
