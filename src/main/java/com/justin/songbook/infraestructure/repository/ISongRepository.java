package com.justin.songbook.infraestructure.repository;

import com.justin.songbook.domain.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISongRepository extends JpaRepository<Song, Long> {

    List<Song> findByTitle(String title);
}
