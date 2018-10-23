-- create SmartEvents schema
create schema if not exists smartevents;

-- user_profile
create table if not exists smartevents.user (
   id UUID PRIMARY KEY ,
   fname varchar(255) NOT NULL ,
   lname varchar(255) NOT NULL,
   username varchar(255) NOT NULL UNIQUE ,
   email varchar(255) NOT NULL UNIQUE,
   phone varchar(255),
   password varchar(255) not null
);

--SEED DATA
insert into smartevents.user values('a5430c94-0fdd-4839-8140-7f49d47f8081', 'Wayne', 'Rooney','wayne.rooney','wayne@gmail.com','','pass');

insert into smartevents.user values('a5430c94-0fdd-4839-8140-7f49d47f8082', 'Paul', 'Pogba','paul.pogba','pogba@gmail.com','','pass');

insert into smartevents.user values('a5430c94-0fdd-4839-8140-7f49d47f8083', 'Rahul', 'Dravid','rahul.dravid','dravid@gmail.com','','pass');
