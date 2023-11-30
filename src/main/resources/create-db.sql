use master;
drop database if exists stundenplaner;
create database stundenplaner;
use stundenplaner;

create table class(
    classId integer auto_increment,
    className varchar(1000) not null,
    primary key (classId)
);

create table module(
    moduleId integer auto_increment,
    moduleName varchar(1000) not null,
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
    primary key (roomId)
);

create table teacher_available_days(
    teacherAvailableDayId integer auto_increment,
    fk_teacherId integer not null,
    day varchar(250) not null,
    primary key (teacherAvailableDayId),
    foreign key (fk_teacherId) references teacher(teacherId)
);

create table class_unavailable_days(
    classUnavailableDayId integer auto_increment,
    fk_classId integer not null,
    day varchar(250) not null,
    primary key (classUnavailableDayId),
    foreign key (fk_classId) references class(classId)
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
)

