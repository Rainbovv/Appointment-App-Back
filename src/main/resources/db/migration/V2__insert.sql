-- noinspection SqlNoDataSourceInspectionForFile

insert into role (id, name) values (1, "ADMIN");
insert into role (id, name) values (2, "PATIENT");
insert into role (id, name) values (3, "DOCTOR");
insert into role (id, name) values (4, "UNREGISTERED");

insert into department (id, name) values (1, "Surgery");
insert into department (id, name) values (2, "Therapy");
insert into department (id, name) values (3, "Oncology");

insert into speciality (id, name, department_id) values (1, "Heart surgery", 1);
insert into speciality (id, name, department_id) values (2, "Plastic surgery", 1);
insert into speciality (id, name, department_id) values (3, "Psycological therapy", 2);
insert into speciality (id, name, department_id) values (4, "Pediatric therapy", 2);
insert into speciality (id, name, department_id) values (5, "Surgical oncology", 3);
insert into speciality (id, name, department_id) values (6, "Pediatric oncology", 3);

insert into daily_schedule (id, end , start) VALUES (1, "18:00:00", "09:00:00");
insert into weekly_schedule (id, friday, monday, thursday, tuesday, wednesday) values (1, 1, 1, 1, 1, 1);

insert into user (id, login, password, status) values (1, "admin@example.com", "$2y$12$meZ18A7SxE8IY4jkJYBOq.wv8rrXlyUEvUeLHs1iLoNzbSsIKNzPq", 1);
insert into profile (id, email, first_name, last_name, office, user_id) values (1, "admin@example.com", "admin", "admin", 0, 1);
insert into user_roles (user_id, role_id) values (1, 1);