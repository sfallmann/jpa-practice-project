insert into artist (name, genre) values ('Pantera', 'Metal');
insert into artist (name, genre) values ('Kiss', 'Rock');

insert into album (name, artist_id) values ('Cowboys From Hell', 1);
insert into album (name, artist_id) values ('Vulgar Display of Power', 1);

insert into album (name, artist_id) values ('Kiss', 2);
insert into album (name, artist_id) values ('Alive!', 2);


insert into song(name, artist_id) values ('Deuce', 2);
insert into song(name, artist_id) values ('Cowboys From Hell', 1);
insert into song(name, artist_id) values ('Walk', 1);

insert into song_albums(songs_id, albums_id) values(1,3);
insert into song_albums(songs_id, albums_id) values(1,4);
insert into song_albums(songs_id, albums_id) values(2,1);
insert into song_albums(songs_id, albums_id) values(3,2);
/*





*/