create table users
(
    id         bigserial
        constraint pk_users
            primary key,
    email      varchar(32)  not null,
    first_name varchar(32)  not null,
    last_name  varchar(32)  not null,
    password   varchar(255) not null,
    role       varchar(21) default 'USER'::character varying,
    status     varchar(21) default 'ACTIVE'::character varying
);

alter table users
    owner to postgres;
