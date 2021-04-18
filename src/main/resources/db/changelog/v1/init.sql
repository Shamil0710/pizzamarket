--liquibase formatted sql

--changeset shamil:001

--drop table if exists user cascade;
--drop table if exists product cascade;
--drop table if exists order cascade;

--drop table if exists roles cascade;
--drop table if exists order_product cascade;

create table if not exists mampiza.roles(
    roles_id          BIGSERIAL primary key,
    roles_name        VARCHAR
);
create table if not exists mampiza.user(
    user_id           BIGSERIAL primary key,
    password          VARCHAR NOT NULL,
    first_name        VARCHAR,
    last_name         VARCHAR,
    phone_number      VARCHAR(8) unique,
    user_roles        BIGINT references mampiza.roles(roles_id) on delete cascade
);
create table if not exists mampiza.product(
    product_id        BIGSERIAL primary key,
    cost              NUMERIC(17, 2) NOT NULL,
    title             VARCHAR,
    description       VARCHAR,
    tag               VARCHAR
);
create table if not exists mampiza.order(
    order_id          BIGSERIAL primary key,
    user_id           BIGINT NOT NULL references mampiza.user (user_id),
    time_of_ordering  DATE,
    cost              NUMERIC (17, 2) NOT NULL
);
create table if not exists mampiza.order_product(
    order_id          BIGINT NOT NULL references mampiza.order (order_id),
    product_id        BIGINT NOT NULL references mampiza.product (product_id),
    id                BIGSERIAL primary key
);