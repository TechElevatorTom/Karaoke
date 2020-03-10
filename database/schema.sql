DROP TABLE IF EXISTS songs;
DROP TABLE IF EXISTS song_requests;

CREATE TABLE songs (
    id serial,
    artist varchar(100) not null,
    title varchar(100) not null,
    album varchar(100),

    CONSTRAINT pk_songs_id PRIMARY KEY (id)
);

CREATE TABLE song_requests (
    id serial,
    artist varchar(100) not null,
    title varchar(100) not null,
    album varchar(100),

    CONSTRAINT pk_song_requests_id PRIMARY KEY (id),
    CONSTRAINT un_song_requests_artist_title UNIQUE (artist, title)

);
