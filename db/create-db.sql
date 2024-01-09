drop database if exists stundenplaner;
create database stundenplaner;
use stundenplaner;

create table class(
    classId integer auto_increment,
    className varchar(1000) not null,
    basislehrjahr boolean not null,
    primary key (classId)
);

create table module(
    moduleId integer auto_increment,
    moduleName varchar(1000) not null,
    shortcut varchar(100) not null,
    duration varchar(100) not null,
    primary key (moduleId)
);

create table teacher(
    teacherId integer auto_increment,
    firstname varchar(1000) not null,
    lastname varchar(1000) not null,
    shortcut varchar(100) not null,
    pensum integer not null,
    primary key (teacherId)
);

create table room(
    roomId integer auto_increment,
    roomName varchar(1000) not null,
    roomType varchar(1000) not null,
    primary key (roomId)
);

create table teacher_weekday(
    id int auto_increment,
    teacherId int not null,
    weekday varchar(1000) not null,
    primary key (id)
);

create table class_weekday(
    id int auto_increment,
    classId int not null,
    weekday varchar(1000) not null,
    primary key (id)
);

create table teacher_modules(
    teacherModuleId integer auto_increment,
    fk_teacherId integer not null,
    fk_moduleId integer not null,
    primary key (teacherModuleId),
    foreign key (fk_teacherId) references teacher(teacherId),
    foreign key (fk_moduleId) references module(moduleId)
);

create table class_modules(
    classModuleId integer auto_increment,
    fk_classId integer not null,
    fk_moduleId integer not null,
    primary key (classModuleId),
    foreign key (fk_classId) references class(classId),
    foreign key (fk_moduleId) references module(moduleId)
);

