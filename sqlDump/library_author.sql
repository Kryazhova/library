create table author
(
    id          bigint auto_increment
        primary key,
    first_name  varchar(255) null,
    second_name varchar(255) null
);

INSERT INTO library.author (id, first_name, second_name) VALUES (1, 'Ричард', 'Флэнаган');
INSERT INTO library.author (id, first_name, second_name) VALUES (2, 'Лев', 'Толстой');
INSERT INTO library.author (id, first_name, second_name) VALUES (3, 'Леонид', 'Андреев');