insert into artist (name, genre) values ('Pantera', 'Metal');
insert into artist (name, genre) values ('Kiss', 'Rock');

insert into album (name) values ('Cowboys From Hell');
insert into album (name) values ('Vulgar Display of Power');
insert into album (name) values ('Kiss');
insert into album (name) values ('Alive!');


insert into song(name) values ('Deuce');
insert into song(name) values ('Cowboys From Hell');
insert into song(name) values ('Walk');

insert into song_artist(song_id, artist_id) values(1,2);
insert into song_artist(song_id, artist_id) values(2,1);
insert into song_artist(song_id, artist_id) values(3,1);

insert into album_artist(album_id, artist_id) values(1,1);
insert into album_artist(album_id, artist_id) values(2,1);
insert into album_artist(album_id, artist_id) values(3,2);
insert into album_artist(album_id, artist_id) values(4,2);

insert into song_album(song_id, album_id) values(1,3);
insert into song_album(song_id, album_id) values(1,4);
insert into song_album(song_id, album_id) values(2,1);
insert into song_album(song_id, album_id) values(3,2);
