drop database if exists projeto_integrado;
create database if not exists projeto_integrado;

use projeto_integrado;

## Creating users table

create table users (
	id varchar(255),
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null unique,
    about text(500),
    birthday date,
    role enum('manager', 'analyst') default 'analyst',
    created_at timestamp not null default now(),
    
    constraint users_pk primary key(id)
);

## Creating manager table
create table managers (
	id varchar(255),
    user_id varchar(255),
    
    constraint managers_pk primary key(id),
    constraint managers_users_fk foreign key (user_id) references users(id)
);

## Adding manager reference in users table
alter table users
add column manager_id varchar(255);

alter table users
add constraint users_managers_fk foreign key (manager_id)
references managers(id);

## Creating analysts table
create table analysts (
	id varchar(255),
    user_id varchar(255),
    
    constraint analysts_pk primary key(id),
    constraint analysts_users_fk foreign key (user_id) references users(id)
);

## Adding analyst reference in users table
alter table users
add column analyst_id varchar(255);

alter table users
add constraint users_analysts_fk foreign key (analyst_id)
references analysts(id);

CREATE TABLE files_resource(

	id			varchar(255) not null,
    resource_id	varchar(255) not null,
    file		mediumblob,
    
    constraint files_resource_pk primary key(id),
    constraint resources_fk foreign key (resource_id) references resources(id)
)