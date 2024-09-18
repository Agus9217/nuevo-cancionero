package com.justin.songbook.domain.services;

import com.justin.songbook.application.dtos.SongDto;
import com.justin.songbook.domain.entities.Song;
import com.justin.songbook.infraestructure.repository.ISongRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServicesImpl implements ISongServices {

    final private ISongRepository songRepository;

    public SongServicesImpl(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }


    @Override
    public List<SongDto> findAllSongs() throws BadRequestException {
        List<Song> songs = songRepository.findAll();
        if (songs.isEmpty()) {
            throw new BadRequestException("No existe la cancion");
        }
        return songs.stream()
                .map(song -> new SongDto(
                        song.getTitulo(),
                        song.getTonalidad(),
                        song.getLetra()
                ))
                .toList();
    }

    @Override
    public SongDto findSongById(Long id) throws NotFoundResponse {
        Song song = songRepository.findById(id)
                .orElseThrow(
                        ()-> new NotFoundResponse("No existe la cancion"));
        return new SongDto(
                song.getTitulo(),
                song.getTonalidad(),
                song.getLetra()
        );
    }

    @Override
    public List<SongDto> findSongByTitle(String title) throws NotFoundResponse {
        List<Song> songs = songRepository.findByTitulo(title);
        if (songs.isEmpty()) {
            throw new NotFoundResponse("No hay canciones por el titulo");
        }
        return songs.stream()
                .map(song -> new SongDto(
                        song.getTitulo(),
                        song.getTonalidad(),
                        song.getLetra()
                ))
                .toList();
    }

    @Override
    public void deleteSongById(Long id) throws NotFoundResponse {
        if (!songRepository.existsById(id)) {
            throw new NotFoundResponse("La cancion que intentas eliminar no existe");
        }
        songRepository.deleteById(id);
    }

    @Override
    public Song saveSong(SongDto song) throws NotFoundResponse {
        if (song.getTitulo().isEmpty()){
            throw new NotFoundResponse("El titulo no puede ser nulo");
        }
        Song savedSong = new Song(
                null,
                song.getLetra(),
                song.getTonalidad(),
                song.getTitulo()
        );
        return songRepository.save(savedSong);
    }

    @Override
    public Song updateSong(Long id, SongDto song) throws NotFoundResponse {
        Optional<Song> songOptional = songRepository.findById(id);
        if (songOptional.isEmpty()) {
            throw new NotFoundResponse("La cancion que quieres actualizar no existe");
        }
        Song songToUpdate = songOptional.get();
        Song songToSave = new Song(
                null,
                songToUpdate.getLetra(),
                songToUpdate.getTonalidad(),
                songToUpdate.getTitulo()
        );
        return songRepository.save(songToSave);
    }
}
