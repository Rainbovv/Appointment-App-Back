INSERT INTO role (name)
VALUES ('ADMIN'),
       ('DOCTOR'),
       ('PATIENT'),
       ('UNREGISTERED');

INSERT INTO department (name)
VALUES ('Surgery'),
       ('Pathology'),
       ('Radiology'),
       ('Pediatrics');

INSERT INTO speciality (name, department_id)
VALUES ('Plastic surgery', 1),
       ('General surgery', 1),
       ('Neuro-pathology', 2),
       ('Pediatric pathology', 2),
       ('Abdominal radiology', 3),
       ('Breast imaging', 3),
       ('Neonatal-perinatal medicine', 4),
       ('Pediatric endocrinology', 4);

INSERT INTO user (created, last_update, login, password, status)
VALUES (NOW(), NOW(), 'admin@domain.com', '$2y$10$p0SwmNHakBpd2d6kP.wgWeMp6nWOUEWwhSXgeS/SzOQUzQ6sUlmFy', 1),
       (NOW(), NOW(), 'doctor@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1),
       (NOW(), NOW(), 'doctor1@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1),
       (NOW(), NOW(), 'doctor2@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1),
       (NOW(), NOW(), 'doctor3@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1),
       (NOW(), NOW(), 'doctor4@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1),
       (NOW(), NOW(), 'doctor5@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1),
       (NOW(), NOW(), 'doctor6@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1),
       (NOW(), NOW(), 'doctor7@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1),
       (NOW(), NOW(), 'doctor8@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1),
       (NOW(), NOW(), 'doctor9@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1),
       (NOW(), NOW(), 'doctor10@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1),
       (NOW(), NOW(), 'doctor11@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1),
       (NOW(), NOW(), 'doctor12@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1),
       (NOW(), NOW(), 'doctor13@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1),
       (NOW(), NOW(), 'doctor14@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1),
       (NOW(), NOW(), 'doctor15@domain.com', '$2y$10$jHhIl1D3Fa5raUjImLFhC.bQf5WFjJV8O3ylUSUo5M.R2N85vIaxO', 1);

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1),
       (2, 2),
       (3, 2),
       (4, 2),
       (5, 2),
       (6, 2),
       (7, 2),
       (8, 2),
       (9, 2),
       (10, 2),
       (11, 2),
       (12, 2),
       (13, 2),
       (14, 2),
       (15, 2);

INSERT INTO daily_schedule (end, start)
VALUES ('16:00:00', '09:00:00'),
       ('17:00:00', '10:00:00');

INSERT INTO weekly_schedule (friday, monday, saturday, sunday, thursday, tuesday, wednesday)
VALUES (1,1,1,1,1,1,1),
       (2,2,2,2,2,2,2);

INSERT INTO profile (about, address, email, first_name, gender, last_name, office, social_number, telephone, schedule ,user_id)
VALUES ('info about admin', 'Milky Way 1', 'admin@domain.com', 'admin', 'male', 'admin', null, 12345, +37312345, 1 ,1),
       ('info about doctor', 'Milky Way 2', 'doctor@domain.com', 'Eugen', 'male', 'Vitalco', 144, 1122333, +37323244, 2, 2),
       ('info about doctor', 'Milky Way 3', 'doctor1@domain.com', 'Magomed', 'male', 'Musafirovich', 145, 1122333, +37323244, 1, 3),
       ('info about doctor', 'Milky Way 4', 'doctor2@domain.com', 'Eliza', 'female', 'Voshca', 146, 1122333, +37323244, 2, 4),
       ('info about doctor', 'Milky Way 5', 'doctor3@domain.com', 'Pedro', 'male', 'Vincoa', 174, 1122333, +37323244, 1, 5),
       ('info about doctor', 'Milky Way 6', 'doctor4@domain.com', 'Claudia', 'female', 'Vivaldi', 255, 1122333, +37323244, 2, 6),
       ('info about doctor', 'Milky Way 7', 'doctor5@domain.com', 'Frosea', 'female', 'Mariupca', 266, 1122333, +37323244, 1, 7),
       ('info about doctor', 'Milky Way 8', 'doctor6@domain.com', 'Carbit', 'male', 'Leorca', 666, 1122333, +37323244, 2, 8),
       ('info about doctor', 'Milky Way 9', 'doctor7@domain.com', 'Funtic', 'female', 'Vereovca', 777, 1122333, +37323244, 1, 9),
       ('info about doctor', 'Milky Way 10', 'doctor8@domain.com', 'Vasilisa', 'female', 'Molodec', 263, 1122333, +37323244, 2, 10),
       ('info about doctor', 'Milky Way 11', 'doctor9@domain.com', 'Vasilii', 'male', 'Grecika', 152, 1122333, +37323244, 1, 11),
       ('info about doctor', 'Milky Way 12', 'doctor10@domain.com', 'Monea', 'female', 'Martovscki', 222, 1122333, +37323244, 2, 12),
       ('info about doctor', 'Milky Way 13', 'doctor11@domain.com', 'Evlampii', 'male', 'Brun', 122, 1122333, +37323244, 1, 13),
       ('info about doctor', 'Milky Way 14', 'doctor12@domain.com', 'Mirabela', 'female', 'Mizanbunca', 155, 1122333, +37323244, 2, 14),
       ('info about doctor', 'Milky Way 15', 'doctor13@domain.com', 'Esmeralda', 'female', 'Fatamea', 123, 1122333, +37323244, 1, 15),
       ('info about doctor', 'Milky Way 16', 'doctor14@domain.com', 'Mitea', 'male', 'Prostomitea', 136, 1122333, +37323244, 2, 16),
       ('info about doctor', 'Milky Way 17', 'doctor15@domain.com', 'Ferguson', 'male', 'Mujic', 233, 1122333, +37323244, 1, 17);

INSERT INTO doctors_speciality (doctor_id, speciality_id)
VALUES (2, 1),
       (3, 1),
       (4, 1),
       (5, 1),
       (6, 1),
       (7, 1),
       (8, 1),
       (9, 2),
       (2, 2),
       (4, 2),
       (6, 2),
       (8, 2),
       (3, 2),
       (10, 2),
       (12, 2),
       (6, 3),
       (2, 3),
       (3, 3),
       (10, 3),
       (12, 3),
       (6, 4),
       (8, 4),
       (3, 4),
       (10, 4),
       (12, 4),
       (6, 5),
       (13, 5),
       (3, 5),
       (14, 5),
       (15, 5),
       (6, 6),
       (14, 6),
       (15, 6),
       (17, 6),
       (16, 6),
       (14, 7),
       (15, 7),
       (6, 7),
       (14, 7),
       (15, 7),
       (17, 7),
       (16, 8),
       (15, 8),
       (6, 8),
       (14, 8),
       (8, 8),
       (2, 8),
       (3, 8);

INSERT INTO holiday (description, end, start, profile_id)
VALUES ('Annual Holiday', '2021-09-04 08:00:00', '2021-08-04 08:00:00', 2),
       ('Annual Holiday', '2021-09-04 08:00:00', '2021-08-04 08:00:00', 3),
       ('Annual Holiday', '2021-09-04 08:00:00', '2021-08-04 08:00:00', 4),
       ('Annual Holiday', '2021-09-04 08:00:00', '2021-08-04 08:00:00', 5),
       ('Annual Holiday', '2021-09-04 08:00:00', '2021-08-04 08:00:00', 6),
       ('Annual Holiday', '2021-09-04 08:00:00', '2021-08-04 08:00:00', 7),
       ('Annual Holiday', '2021-09-04 08:00:00', '2021-08-04 08:00:00', 8),
       ('Annual Holiday', '2021-09-04 08:00:00', '2021-08-04 08:00:00', 9),
       ('Annual Holiday', '2021-09-04 08:00:00', '2021-08-04 08:00:00', 10),
       ('Annual Holiday', '2021-09-04 08:00:00', '2021-08-04 08:00:00', 11),
       ('Annual Holiday', '2021-09-04 08:00:00', '2021-08-04 08:00:00', 12),
       ('Annual Holiday', '2021-09-04 08:00:00', '2021-08-04 08:00:00', 13),
       ('Annual Holiday', '2021-09-04 08:00:00', '2021-08-04 08:00:00', 14);