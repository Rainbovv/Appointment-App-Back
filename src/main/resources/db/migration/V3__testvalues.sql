-- noinspection SqlNoDataSourceInspectionForFile

insert into user (id, login, password, status) values (2, "doctor2@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (2, "Very good doctor", "NYC Medical School", "doctor2@example.com", "Michael", "Scott", 0, 1, 2);
insert into user_roles (user_id, role_id) values (2, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (2, 1);

insert into user (id, login, password, status) values (3, "doctor3@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (3, "Very good doctor", "NYC Medical School", "doctor3@example.com", "Dwight", "Schrute", 0, 1, 3);
insert into user_roles (user_id, role_id) values (3, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (3, 1);

insert into user (id, login, password, status) values (4, "doctor4@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (4, "Very good doctor", "NYC Medical School", "doctor4@example.com", "Jim", "Halpert", 0, 1, 4);
insert into user_roles (user_id, role_id) values (4, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (4, 1);

insert into user (id, login, password, status) values (5, "doctor5@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (5, "Very good doctor", "NYC Medical School", "doctor5@example.com", "Pam", "Beesly", 0, 1, 5);
insert into user_roles (user_id, role_id) values (5, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (5, 2);

insert into user (id, login, password, status) values (6, "doctor6@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (6, "Very good doctor", "NYC Medical School", "doctor6@example.com", "Ryan", "Howard", 0, 1, 6);
insert into user_roles (user_id, role_id) values (6, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (6, 2);

insert into user (id, login, password, status) values (7, "doctor7@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (7, "Very good doctor", "NYC Medical School", "doctor7@example.com", "Andy", "Bernard", 0, 1, 7);
insert into user_roles (user_id, role_id) values (7, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (7, 2);

insert into user (id, login, password, status) values (8, "doctor8@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (8, "Very good doctor", "NYC Medical School", "doctor8@example.com", "Robert", "California", 0, 1, 8);
insert into user_roles (user_id, role_id) values (8, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (8, 3);

insert into user (id, login, password, status) values (9, "doctor9@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (9, "Very good doctor", "NYC Medical School", "doctor9@example.com", "Jan", "Levinson", 0, 1, 9);
insert into user_roles (user_id, role_id) values (9, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (9, 3);

insert into user (id, login, password, status) values (10, "doctor10@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (10, "Very good doctor", "NYC Medical School", "doctor10@example.com", "David", "Wallace", 0, 1, 10);
insert into user_roles (user_id, role_id) values (10, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (10, 3);

insert into user (id, login, password, status) values (11, "doctor11@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (11, "Very good doctor", "NYC Medical School", "doctor11@example.com", "Stanley", "Hudson", 0, 1, 11);
insert into user_roles (user_id, role_id) values (11, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (11, 4);

insert into user (id, login, password, status) values (12, "doctor12@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (12, "Very good doctor", "NYC Medical School", "doctor12@example.com", "Kevin", "Malone", 0, 1, 12);
insert into user_roles (user_id, role_id) values (12, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (12, 4);

insert into user (id, login, password, status) values (13, "doctor13@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (13, "Very good doctor", "NYC Medical School", "doctor13@example.com", "Phyllis", "Vance", 0, 1, 13);
insert into user_roles (user_id, role_id) values (13, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (13, 4);

insert into user (id, login, password, status) values (14, "doctor14@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (14, "Very good doctor", "NYC Medical School", "doctor14@example.com", "Angela", "Martin", 0, 1, 14);
insert into user_roles (user_id, role_id) values (14, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (14, 5);

insert into user (id, login, password, status) values (15, "doctor15@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (15, "Very good doctor", "NYC Medical School", "doctor15@example.com", "Oscar", "Martinez", 0, 1, 15);
insert into user_roles (user_id, role_id) values (15, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (15, 5);

insert into user (id, login, password, status) values (16, "doctor16@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (16, "Very good doctor", "NYC Medical School", "doctor16@example.com", "Meredith", "Palmer", 0, 1, 16);
insert into user_roles (user_id, role_id) values (16, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (16, 5);

insert into user (id, login, password, status) values (17, "doctor17@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (17, "Very good doctor", "NYC Medical School", "doctor17@example.com", "Toby", "Flanderson", 0, 1, 17);
insert into user_roles (user_id, role_id) values (17, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (17, 6);

insert into user (id, login, password, status) values (18, "doctor18@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (18, "Very good doctor", "NYC Medical School", "doctor18@example.com", "Kelly", "Kapoor", 0, 1, 18);
insert into user_roles (user_id, role_id) values (18, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (18, 6);

insert into user (id, login, password, status) values (19, "doctor19@example.com", "$2y$12$K3XJEz/YF5PxgrwMcHEvc.HfUJhUS7SINbE0sd3mvVe1PcPRnN0Ta", 1);
insert into profile (id, about, degree, email, first_name, last_name, office, schedule, user_id) values (19, "Very good doctor", "NYC Medical School", "doctor19@example.com", "Creed", "Bratton", 0, 1, 19);
insert into user_roles (user_id, role_id) values (19, 3);
insert into doctors_speciality (doctor_id, speciality_id) values (19, 6);