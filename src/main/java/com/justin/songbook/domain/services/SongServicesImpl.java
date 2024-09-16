package com.justin.songbook.domain.services;

import com.justin.songbook.domain.entities.Song;
import com.justin.songbook.domain.error.ErrorResponse;
import com.justin.songbook.infraestructure.repository.ISongRepository;

import java.util.List;
import java.util.Optional;

public class SongServicesImpl implements ISongServices {

    final private ISongRepository songRepository;

    public SongServicesImpl(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> findAllSongs() {
        List<Song> songs = songRepository.findAll();
        if (songs.isEmpty()){
            throw new ErrorResponse("Something is wrong", 404);
        }
        return songs;
    }

    @Override
    public Song findSongById(long id) {
        Optional<Song> song = songRepository.findById(id);
        if (song.isPresent()){
            return song.get();
        }
        throw new ErrorResponse("Something is wrong", 404);
    }

    @Override
    public List<Song> findSongByTitle(String title) {
        List<Song> song = songRepository.findByTitle(title);
        if (song.isEmpty()){
            throw new ErrorResponse("Song not found", 404);
        }
        return song;
    }

    @Override
    public void deleteSongById(long id) {
        if (songRepository.existsById(id)){
            songRepository.deleteById(id);
        }
        throw new ErrorResponse("Something is wrong", 404);
    }

    @Override
    public Song saveSong(Song song) {
        return null;
    }
}
