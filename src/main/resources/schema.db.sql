create schema if not exists "mampiza_schema";

/* уточнить у ванька по поводу дропа таблиц */

create table if not exists "mampiza"."user"(
    "user_id"           BIGSERIAL NOT NULL,
    "password"          VARCHAR NOT NULL,
    "first_name"        VARCHAR,
    "last_name"         VARCHAR,
    "phone_number"      INT(8),
    constraint user_table_pk primary key ("user_id")
);

create table if not exists "mampiza"."product"(
    "product_id"        BIGSERIAL NOT NULL,
    "cost"              NUMERIC(17, 2) NOT NULL,
    "title"             VARCHAR,
    "description"       VARCHAR,
    "teg"               VARCHAR,
    constraint  proct_table_pk primary key ("product_id")
);

create table if not exists "mampiza"."order"(
    "order_id"          BIGSERIAL NOT NULL,
    "user_id"           BIGSERIAL NOT NULL,
    "product_id"        BIGSERIAL NOT NULL,
    "time_of_ordering"  DATE,
    constraint order_table_pk primary key ("order_id")
    constraint order_table_user_id_fk foreign key (user_id) references "mampiza_table"."user_table" (user_id) on delete cascade
    constraint order_table_producr_id_fk foreign key (product_id) references "mampiza_table"."product_table" (product_id) on derived cascade
);

