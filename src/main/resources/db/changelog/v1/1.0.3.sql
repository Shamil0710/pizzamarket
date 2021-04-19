--liquibase formatted sql

--changeset shamil:003

--DELETE FROM mampiza.roles WHERE roles_name = 'ROLE_USER';

INSERT INTO mampiza.roles(roles_name) VALUES ('ROLE_USER');