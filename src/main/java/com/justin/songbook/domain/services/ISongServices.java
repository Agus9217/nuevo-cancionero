package com.justin.songbook.domain.services;

import com.justin.songbook.domain.entities.Song;

import java.util.List;

public interface ISongServices {
    List<Song> findAllSongs();
    Song findSongById(long id);
    List<Song> findSongByTitle(String title);
    void deleteSongById(long id);
    Song saveSong(Song song);
}
