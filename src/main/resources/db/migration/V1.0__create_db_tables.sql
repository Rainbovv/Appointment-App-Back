drop table if exists daily_schedule;
create table if not exists daily_schedule
(
    id bigint not null
        primary key
        auto_increment,
    end time not null,
    start time not null
);

drop table if exists department;
create table if not exists department
(
    id bigint not null
        primary key
        auto_increment,
    name varchar(255) not null
);

create table if not exists hibernate_sequence
(
    next_val bigint null
);

create table if not exists role
(
    id bigint not null
        primary key
        auto_increment,
    name varchar(255) null
);

create table if not exists speciality
(
    id bigint not null
        primary key
        auto_increment,
    name varchar(255) not null,
    department_id bigint not null,
    foreign key (department_id) references department (id)
);

create table if not exists user
(
    id bigint auto_increment
        primary key,
    created datetime(6) null,
    last_update datetime(6) null,
    login varchar(255) not null,
    password varchar(255) not null,
    status int not null,
    unique (login)
);

create table if not exists appointments
(
    id bigint not null
        primary key
        auto_increment,
    created datetime(6) null,
    end_time datetime(6) not null,
    last_update datetime(6) null,
    remark varchar(255) null,
    start_time datetime(6) not null,
    doctor_id bigint not null,
    patient_id bigint not null,
    foreign key (doctor_id) references user (id),
    foreign key (patient_id) references user (id)
);

create table if not exists user_roles
(
    user_id bigint not null,
    role_id bigint not null,
    foreign key (user_id) references user (id),
    foreign key (role_id) references role (id)
);

create table if not exists weekly_schedule
(
    id bigint not null
        primary key
        auto_increment,
    friday bigint null,
    monday bigint null,
    saturday bigint null,
    sunday bigint null,
    thursday bigint null,
    tuesday bigint null,
    wednesday bigint null,
    foreign key (monday) references daily_schedule (id),
    foreign key (saturday) references daily_schedule (id),
    foreign key (friday) references daily_schedule (id),
    foreign key (tuesday) references daily_schedule (id),
    foreign key (wednesday) references daily_schedule (id),
    foreign key (thursday) references daily_schedule (id),
    foreign key (sunday) references daily_schedule (id)
);

create table if not exists profile
(
    id bigint not null
        primary key
        auto_increment,
    about varchar(255) null,
    address varchar(255) null,
    date_of_birth date null,
    degree varchar(255) null,
    email varchar(255) not null,
    first_name varchar(255) not null,
    gender varchar(255) null,
    last_name varchar(255) not null,
    office int null,
    social_number varchar(255) null,
    telephone varchar(255) null,
    schedule bigint null,
    user_id bigint null,
    unique (email),
    foreign key (user_id) references user (id),
    foreign key (schedule) references weekly_schedule (id)
);

create table if not exists doctors_speciality
(
    doctor_id bigint not null,
    speciality_id bigint not null,
    foreign key (speciality_id) references speciality (id),
    foreign key (doctor_id) references profile (id)
);

create table if not exists holiday
(
    id bigint not null
        primary key
        auto_increment,
    description varchar(255) null,
    end datetime(6) not null,
    start datetime(6) not null,
    profile_id bigint null,
    foreign key (profile_id) references profile (id)
);

