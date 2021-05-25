create table article
(
    id       int auto_increment primary key,
    title    varchar(255) not null default '' comment '标题',
    author_id int          not null comment '作者ID',
    content  text         not null default '' comment '内容'
);