create table carteira_habilitacao
(

    cnh           varchar(9) not null,
    categoria_cnh varchar(3) not null,
    prontuario    integer    not null,
    data_emicao   datetime   not null,

    primary key (cnh)

);

create table motorista

(

    cpf                  varchar(11)  not null,
    nome                 varchar(100) not null,
    rg                   varchar(11)  not null,

    motorista_cep        varchar(8)   not null,
    motorista_logradouro varchar(100),
    motorista_bairro     varchar(100) not null,
    motorista_uf         varchar(20)  not null,
    motorista_localidade varchar(30)  not null,

    numero_cnh           varchar(9) references carteira_habilitacao (cnh),

    primary key (cpf)

);


create table veiculo
(

    renavam       varchar(11)  not null,
    modelo        varchar(100) not null,
    crlv          varchar(12)  not null,
    crv           varchar(11)  not null,
    cor           varchar(20)  not null,
    placa         varchar(7)   not null,


    cpf_motorista varchar(11) references motorista (cpf),

    primary key (renavam)

);

create table licenciamento
(

    id                            bigint   not null auto_increment,
    valor                         numeric(20, 2),
    data_vencimento_licenciamento datetime not null,

    renavam_veiculo               varchar(11) references veiculo (renavam),

    primary key (id)

);

create table multa
(

    id                    bigint       not null auto_increment,
    valor                 numeric(20, 2),
    motivo                varchar(100) not null,
    data_vencimento_multa datetime     not null,
    grau                  varchar(10)  not null,

    renavam_multa         varchar(11) references veiculo (renavam),

    primary key (id)


);
