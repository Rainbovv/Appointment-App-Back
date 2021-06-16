INSERT INTO role (name)
VALUES ('ADMIN'),
       ('DOCTOR'),
       ('PATIENT'),
       ('UNREGISTERED');

INSERT INTO department (name)
VALUES ('Surgery'),
       ('Ophthalmology'),
       ('Traumatology'),
       ('Management');

INSERT INTO speciality (name, department_id)
VALUES ('Facial surgeon', 1),
       ('Ophthalmolog', 2),
       ('Orthoped', 3),
       ('Manager', 4);

INSERT INTO user (login, password, status)
VALUES ('admin@mail.com', '$2a$04$xrAwXxsF7KZWZI6s6qwHVuIlwJjZLmxDUBBgwF9nAlDT1.r/g7B7.', 1),
       ('doctor@mail.com', '$2a$04$xrAwXxsF7KZWZI6s6qwHVuIlwJjZLmxDUBBgwF9nAlDT1.r/g7B7.', 1),
       ('patient@mail.com', '$2a$04$xrAwXxsF7KZWZI6s6qwHVuIlwJjZLmxDUBBgwF9nAlDT1.r/g7B7.', 1),
       ('patient2@mail.com', '$2a$04$xrAwXxsF7KZWZI6s6qwHVuIlwJjZLmxDUBBgwF9nAlDT1.r/g7B7.', 1);

INSERT INTO profile (about, address, email, first_name, gender, last_name, office, social_number, telephone,  user_id)
VALUES ('info about admin', 'admin address', 'admin@mail.com', 'admin', 'male', 'admin', 1, 12345, +37312345, 1),
       ('info about doctor', 'doctor addres', 'doctor@mail.com', 'doc', 'female', 'doc', 5, 1122333, +37323244, 2),
       ('info about patient', 'patient address', 'patient@mail.com', 'patient', 'female', 'pat', null, 1222234, +37386866, 3),
       ('info about patient2', 'patient2 address', 'patient2@mail.com', 'patient2', 'male', 'pat2', null, 34434, +373864455, 4);

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 3);

INSERT INTO appointments(created, end_time, last_update, remark, start_time, doctor_id, patient_id )
VALUES ('2021-06-15 15:02:28', '2021-08-22 15:02:31', '2021-06-15 15:02:43', 'appointment remark', '2021-06-16 15:02:52', 2, 3),
       ('2021-06-17 15:02:28', '2021-08-22 15:02:31', '2021-06-15 15:02:43', 'appointment remark2', '2021-06-17 15:02:52', 2, 4);