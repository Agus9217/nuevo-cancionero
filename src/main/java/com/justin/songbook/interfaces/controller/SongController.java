package com.justin.songbook.interfaces.controller;

import com.justin.songbook.application.dtos.SongDto;
import com.justin.songbook.domain.services.ISongServices;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class SongController {

    private final ISongServices songServices;

    public SongController(ISongServices songServices) {
        this.songServices = songServices;
    }

    @GetMapping("/")
    public ResponseEntity<List<SongDto>> getAllSongs() throws BadRequestException {
        List<SongDto> allSongs = songServices.findAllSongs();
        return ResponseEntity.ok(allSongs);
    }
}
