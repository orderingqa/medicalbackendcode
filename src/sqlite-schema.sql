
    drop table if exists Apgar;

    drop table if exists Baby;

    drop table if exists Cases;

    drop table if exists Doctor;

    drop table if exists Gravida;

    create table Apgar (
        id  integer,
        apgarInterval integer,
        Appearance integer,
        Pulse integer,
        Grimace integer,
        Activity integer,
        Respiration integer,
        babyId bigint,
        primary key (id)
    );

    create table Baby (
        id  integer,
        birthTime varchar,
        gender integer,
        momId bigint,
        primary key (id)
    );

    create table Cases (
        id bigint not null,
        doctorId bigint,
        createDate varchar,
        primary key (id)
    );

    create table Doctor (
        id  integer,
        doctorName varchar,
        primary key (id)
    );

    create table Gravida (
        id  integer,
        age integer,
        medicalNo integer,
        name varchar,
        primary key (id)
    );
