# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table w1673694_actor (
  actid                         integer auto_increment not null,
  actname                       varchar(255),
  constraint pk_w1673694_actor primary key (actid)
);

create table w1673694_actor_w1673694_dvd (
  w1673694_actor_act_id         integer not null,
  w1673694_dvd_dvd_id           integer not null,
  constraint pk_w1673694_actor_w1673694_dvd primary key (w1673694_actor_act_id,w1673694_dvd_dvd_id)
);

create table w1673694_author (
  authid                        integer auto_increment not null,
  authname                      varchar(255),
  constraint pk_w1673694_author primary key (authid)
);

create table w1673694_author_w1673694_books (
  w1673694_author_auth_id       integer not null,
  w1673694_books_book_id        integer not null,
  constraint pk_w1673694_author_w1673694_books primary key (w1673694_author_auth_id,w1673694_books_book_id)
);

create table w1673694_books (
  bookid                        integer auto_increment not null,
  isbn                          integer not null,
  title                         varchar(255) not null,
  sector                        varchar(255) not null,
  publicationdate               varchar(255) not null,
  borroweddate                  varchar(255),
  reader                        integer,
  objecttype                    varchar(255) not null,
  publisher                     integer not null,
  pages                         integer not null,
  constraint pk_w1673694_books primary key (bookid)
);

create table w1673694_dvd (
  dvdid                         integer auto_increment not null,
  isbn                          integer not null,
  title                         varchar(255) not null,
  sector                        varchar(255) not null,
  publicationdate               varchar(255) not null,
  borroweddate                  varchar(255),
  reader                        integer,
  objecttype                    varchar(255) not null,
  producer                      integer,
  ava_lang                      varchar(255),
  ava_sub                       varchar(255),
  constraint pk_w1673694_dvd primary key (dvdid)
);

create table w1673694_producer (
  proid                         integer auto_increment not null,
  proname                       varchar(255) not null,
  constraint pk_w1673694_producer primary key (proid)
);

create table w1673694_publisher (
  pubid                         integer auto_increment not null,
  pubcomname                    varchar(255) not null,
  constraint pk_w1673694_publisher primary key (pubid)
);

create table w1673694_reader (
  redid                         integer auto_increment not null,
  redname                       varchar(255),
  redmobilenum                  bigint not null,
  redemail                      varchar(255),
  constraint pk_w1673694_reader primary key (redid)
);

alter table w1673694_actor_w1673694_dvd add constraint fk_w1673694_actor_w1673694_dvd_w1673694_actor foreign key (w1673694_actor_act_id) references w1673694_actor (actid) on delete restrict on update restrict;
create index ix_w1673694_actor_w1673694_dvd_w1673694_actor on w1673694_actor_w1673694_dvd (w1673694_actor_act_id);

alter table w1673694_actor_w1673694_dvd add constraint fk_w1673694_actor_w1673694_dvd_w1673694_dvd foreign key (w1673694_dvd_dvd_id) references w1673694_dvd (dvdid) on delete restrict on update restrict;
create index ix_w1673694_actor_w1673694_dvd_w1673694_dvd on w1673694_actor_w1673694_dvd (w1673694_dvd_dvd_id);

alter table w1673694_author_w1673694_books add constraint fk_w1673694_author_w1673694_books_w1673694_author foreign key (w1673694_author_auth_id) references w1673694_author (authid) on delete restrict on update restrict;
create index ix_w1673694_author_w1673694_books_w1673694_author on w1673694_author_w1673694_books (w1673694_author_auth_id);

alter table w1673694_author_w1673694_books add constraint fk_w1673694_author_w1673694_books_w1673694_books foreign key (w1673694_books_book_id) references w1673694_books (bookid) on delete restrict on update restrict;
create index ix_w1673694_author_w1673694_books_w1673694_books on w1673694_author_w1673694_books (w1673694_books_book_id);

alter table w1673694_books add constraint fk_w1673694_books_reader foreign key (reader) references w1673694_reader (redid) on delete restrict on update restrict;
create index ix_w1673694_books_reader on w1673694_books (reader);

alter table w1673694_books add constraint fk_w1673694_books_publisher foreign key (publisher) references w1673694_publisher (pubid) on delete restrict on update restrict;
create index ix_w1673694_books_publisher on w1673694_books (publisher);

alter table w1673694_dvd add constraint fk_w1673694_dvd_reader foreign key (reader) references w1673694_reader (redid) on delete restrict on update restrict;
create index ix_w1673694_dvd_reader on w1673694_dvd (reader);

alter table w1673694_dvd add constraint fk_w1673694_dvd_producer foreign key (producer) references w1673694_producer (proid) on delete restrict on update restrict;
create index ix_w1673694_dvd_producer on w1673694_dvd (producer);


# --- !Downs

alter table w1673694_actor_w1673694_dvd drop foreign key fk_w1673694_actor_w1673694_dvd_w1673694_actor;
drop index ix_w1673694_actor_w1673694_dvd_w1673694_actor on w1673694_actor_w1673694_dvd;

alter table w1673694_actor_w1673694_dvd drop foreign key fk_w1673694_actor_w1673694_dvd_w1673694_dvd;
drop index ix_w1673694_actor_w1673694_dvd_w1673694_dvd on w1673694_actor_w1673694_dvd;

alter table w1673694_author_w1673694_books drop foreign key fk_w1673694_author_w1673694_books_w1673694_author;
drop index ix_w1673694_author_w1673694_books_w1673694_author on w1673694_author_w1673694_books;

alter table w1673694_author_w1673694_books drop foreign key fk_w1673694_author_w1673694_books_w1673694_books;
drop index ix_w1673694_author_w1673694_books_w1673694_books on w1673694_author_w1673694_books;

alter table w1673694_books drop foreign key fk_w1673694_books_reader;
drop index ix_w1673694_books_reader on w1673694_books;

alter table w1673694_books drop foreign key fk_w1673694_books_publisher;
drop index ix_w1673694_books_publisher on w1673694_books;

alter table w1673694_dvd drop foreign key fk_w1673694_dvd_reader;
drop index ix_w1673694_dvd_reader on w1673694_dvd;

alter table w1673694_dvd drop foreign key fk_w1673694_dvd_producer;
drop index ix_w1673694_dvd_producer on w1673694_dvd;

drop table if exists w1673694_actor;

drop table if exists w1673694_actor_w1673694_dvd;

drop table if exists w1673694_author;

drop table if exists w1673694_author_w1673694_books;

drop table if exists w1673694_books;

drop table if exists w1673694_dvd;

drop table if exists w1673694_producer;

drop table if exists w1673694_publisher;

drop table if exists w1673694_reader;

