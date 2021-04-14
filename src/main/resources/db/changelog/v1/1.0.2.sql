--liquibase formatted sql

--changeset shamil:002

alter table mampiza."user" drop column if exists user_roles;