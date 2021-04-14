--liquibase formatted sql

--changeset shamil:002

-- drop table if exists mampiza.roles_users;

create table if not exists mampiza.roles_users(
    user_id           BIGINT NOT NULL references mampiza.user (user_id) on delete cascade,
    role_id           BIGINT NOT NULL references mampiza.roles (roles_id) on delete cascade,
    Primary Key (user_id, role_id)
);