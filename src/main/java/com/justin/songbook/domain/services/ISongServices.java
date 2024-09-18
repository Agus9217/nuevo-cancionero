package com.justin.songbook.domain.services;

import com.justin.songbook.application.dtos.SongDto;
import com.justin.songbook.domain.entities.Song;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface ISongServices {
    List<SongDto> findAllSongs() throws BadRequestException;
    SongDto findSongById(Long id) throws NotFoundResponse;
    List<SongDto> findSongByTitle(String title) throws NotFoundResponse;
    void deleteSongById(Long id) throws NotFoundResponse;
    Song saveSong(SongDto song) throws NotFoundResponse;
    Song updateSong(Long id, SongDto song) throws NotFoundResponse;
}
