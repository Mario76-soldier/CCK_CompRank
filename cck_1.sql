create table UserAccount(
	Id varchar(15) Primary key not null,
    UserName varchar(30) not null,
    EnUserName varchar(30) not null,
    Passwd varchar(21) not null,
    Nation varchar(40),
    Sex varchar(6),
    Position varchar(10),
    goldaward int default 0,
    silveraward int default 0,
    bronzeaward int default 0
);

create table CompList(
	Idx int primary key not null Auto_increment,
    CompName varchar(100) not null,
    CompDate date not null
);

create table CubeEvent(
	idx int primary key not null Auto_increment,
    eventname varchar(21) not null,
    avgcalc char(6) not null
);

insert into cubeevent(eventname, avgcalc) values
('3x3x3', 'ao5'),
('2x2x2', 'ao5'),
('4x4x4', 'ao5'),
('5x5x5', 'ao5'),
('6x6x6', 'mo3'),
('7x7x7', 'mo3'),
('3x3x3 BLD', 'mo3'),
('3x3x3 FMC', 'mo3'),
('3x3x3 OH', 'ao5'),
('clock', 'ao5'),
('megaminx', 'ao5'),
('pyraminx', 'ao5'),
('skewb', 'ao5'),
('square-1', 'ao5'),
('4x4x4 BLD', 'mo3'),
('5x5x5 BLD', 'mo3'),
('3x3x3 MULTBLD', 'count');

create table round(
	compidx int not null,
    seq int not null,
    eventidx int not null,
    round varchar(20) not null,
    eventstart datetime not null,
    eventend datetime not null,
    constraint round_pk primary key(compidx, seq)
);

create table participate(
	idx int primary key not null auto_increment,
    id varchar(15) not null,
    round int not null,
    m1 int,
    s1 float,
    m2 int,
    s2 float,
    m3 int,
    s3 float,
    m4 int,
    s4 float,
    m5 int,
    s5 float,
    singlem int,
    singles float,
    avgm int,
    avgs float,
    checker1 varchar(15) default null,
    checker2 varchar(15) default null,
    checker3 varchar(15) default null
);