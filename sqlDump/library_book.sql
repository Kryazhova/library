create table book
(
    id         bigint auto_increment
        primary key,
    book_title varchar(255) null,
    author_id  bigint       null,
    user_id    bigint       null,
    constraint FK1wxwagv6cm3vjrxqhmv884hir
        foreign key (user_id) references user (id),
    constraint FKklnrv3weler2ftkweewlky958
        foreign key (author_id) references author (id)
);

INSERT INTO library.book (id, book_title, author_id, user_id) VALUES (1, 'Узкая дорога на дальний север', 1, null);
INSERT INTO library.book (id, book_title, author_id, user_id) VALUES (2, 'Война и мир', 2, 1);
INSERT INTO library.book (id, book_title, author_id, user_id) VALUES (3, 'Анна Каренина', 2, 1);