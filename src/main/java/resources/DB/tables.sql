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
    constraint managers_users_fk foreign key(user_id) references users(id)
);

## Adding manager reference in users table
alter table users
add column manager_id varchar(255);
alter table users
add constraint users_managers_fk foreign key(manager_id)
references managers(id);

## Creating analysts table
create table analysts (
	id varchar(255),
    user_id varchar(255),
    
    constraint analysts_pk primary key(id),
    constraint analysts_users_fk foreign key(user_id) references users(id)
);

## Adding analyst reference in users table
alter table users
add column analyst_id varchar(255);
alter table users
add constraint users_analysts_fk foreign key(analyst_id)
references analysts(id);

## Creating sectors table
create table sectors (
	id varchar(255),
    name varchar(255),
    
    constraint sectors_pk primary key(id)
);

## Creating clients table
## drop table clients;
create table clients (
	id varchar(255),
    name varchar(255) not null,
    email varchar(255) not null,
    sector_id varchar(255) not null,
    phone_number varchar(255) not null,
    
    constraint clients_pk primary key(id),
    constraint clients_sectors_fk foreign key(sector_id) references sectors(id)
);

alter table clients
add column cnpj varchar(255) not null;

## Creating projects table
## drop table projects;
create table projects (
	id varchar(255),
    name varchar(255),
    client_id varchar(255),
    description text(500),
    
    constraint projects_pk primary key(id),
    constraint projects_clients_fk foreign key(client_id) references clients(id)
);

## Creating tasks table
## drop table tasks;
create table tasks (
	id varchar(255),
    name varchar(255),
    description text(500),
    assign_to varchar(255),
    estimated_time int(2) default 1,
    priority varchar(255) default 'low',
    project_id varchar(255) not null, 
	created_at timestamp not null default now(),
    status varchar(255) default 'to-do',
    
    constraint tasks_id primary key(id),
    constraint tasks_projects_fk foreign key(project_id) references projects(id),
    constraint tasks_analysts_fk foreign key(assign_to) references analysts(id)
);

## Alter table on users
alter table users
add column gender enum('female', 'male') not null;

CREATE TABLE files_resource(
	id			varchar(255) not null,
    resource_id	varchar(255) not null,
    file		mediumblob,
    
    constraint files_resource_pk primary key(id),
    constraint resources_fk foreign key(resource_id) references resources(id)
);

alter table files_resource add name varchar(255) not null;
select * from files_resource;
alter table files_resource modify file varchar(255) not null; 

CREATE TABLE time_logs (
	id varchar(255) not null,
    task_id varchar(255) not null,
    minutes varchar(255) not null,
    observation text(500),
    created_at timestamp not null default now(),
    
    constraint time_logs_pk primary key(id),
    constraint time_logs_tasks_fk foreign key(task_id) references tasks(id)
); 

alter table time_logs add user_id varchar(255) not null;

alter table time_logs
add constraint time_logs_users_fk foreign key(user_id)
references users(id);
