create table user
(
    id          bigint auto_increment
        primary key,
    first_name  varchar(255) null,
    second_name varchar(255) null
);

INSERT INTO library.user (id, first_name, second_name) VALUES (1, 'Дмитрий', 'Дмитриев');
INSERT INTO library.user (id, first_name, second_name) VALUES (2, 'Александра', 'Александрова');