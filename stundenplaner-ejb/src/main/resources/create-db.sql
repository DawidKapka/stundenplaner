use master;
drop database if exists stundenplaner;
create database stundenplaner;
use stundenplaner;

create table class(
    classId integer,
    className varchar(1000) not null,
    primary key (classId)
);

create table module(
    moduleId integer,
    moduleName varchar(1000) not null,
    duration varchar(100) not null,
    primary key (moduleId)
);

create table teacher(
    teacherId integer,
    firstname varchar(1000) not null,
    lastname varchar(1000) not null,
    shortcut varchar(100) not null,
    pensum integer not null,
    primary key (teacherId)
);

create table room(
    roomId integer,
    roomName varchar(1000) not null,
    primary key (roomId)
);

create table teacher_available_days(
    teacherAvailableDayId integer,
    fk_teacherId integer not null,
    day varchar(250) not null,
    primary key (teacherAvailableDayId),
    foreign key (fk_teacherId) references teacher(teacherId)
);

create table class_unavailable_days(
    classUnavailableDayId integer,
    fk_classId integer not null,
    day varchar(250) not null,
    primary key (classUnavailableDayId),
    foreign key (fk_classId) references class(classId)
);

create table teacher_modules(
    teacherModuleId integer,
    fk_teacherId integer not null,
    fk_moduleId integer not null,
    primary key (teacherModuleId),
    foreign key (fk_teacherId) references teacher(teacherId),
    foreign key (fk_moduleId) references module(moduleId)
);

create table class_modules(
    classModuleId integer,
    fk_classId integer not null,
    fk_moduleId integer not null,
    primary key (classModuleId),
    foreign key (fk_classId) references class(classId),
    foreign key (fk_moduleId) references module(moduleId)
)

