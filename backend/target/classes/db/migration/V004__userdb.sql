create table user
(

    id    bigint      not null auto_increment,

    login varchar(50) not null,

    senha varchar(6)  not null,

    primary key (id)

);