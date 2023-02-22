create table song(
    song_id int not null primary key,
    name varchar(100),
    release_year int,
    artist_name varchar(100)
);

insert into song values (1, 'Knocking on your heart', 2020, 'Maggie Lindemann');
insert into song values (2, 'Waka Waka', 2014, 'Shakira');
insert into song values (3, 'Human', 2016, 'Maggie Lindemann');
insert into song values (4, 'Drive', 2020, 'Halsey');
insert into song values (5, 'Hurricane', 2021, 'Halsey');
insert into song values (6, 'Swim', 2019, 'Chase Atlantic');
insert into song values (7, 'Strangers', 2020, 'Halsey');
insert into song values (8, 'Stranger things', 2017, 'Chase Atlantic');
