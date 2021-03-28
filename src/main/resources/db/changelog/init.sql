--liquibase formatted sql

--changeset: shamil001

--drop table if exists user cascade;
--drop table if exists product cascade;
--drop table if exists order cascade;

create table if not exists "mampiza"."user"(
    "user_id"           BIGSERIAL primary key,
    "password"          VARCHAR NOT NULL,
    "first_name"        VARCHAR,
    "last_name"         VARCHAR,
    "phone_number"      VARCHAR(8) unique,
    "user_roles"        //TODO какой тип указывать для сета
);

create table if not exists "mampiza"."product"(
    "product_id"        BIGSERIAL primary key,
    "cost"              NUMERIC(17, 2) NOT NULL,
    "title"             VARCHAR,
    "description"       VARCHAR,
    "tag"               VARCHAR,
);

create table if not exists "mampiza"."order"(
    "order_id"          BIGSERIAL primary key,
    "user_id"           BIGINT NOT NULL,
    "product_id"        BIGINT NOT NULL,
    "time_of_ordering"  DATE,
    "cost"              NUMERIC (17, 2) NOT NULL,

    constraint order_table_user_id_fk foreign key (user_id) references "mampiza_table"."user_table" (user_id) on delete cascade
    constraint order_table_producr_id_fk foreign key (product_id) references "mampiza_table"."product_table" (product_id) on derived cascade
);

create table if not exists "mampiza"."roles"(
    "roles_id"          BIGSERIAL primary key,
    "roles_name"        VARCHAR,

)

