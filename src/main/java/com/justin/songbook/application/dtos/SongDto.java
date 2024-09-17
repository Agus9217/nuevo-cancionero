package com.justin.songbook.application.dtos;

public class SongDto {
    private String titulo;
    private String tonalidad;
    private String letra;

    public SongDto() {
    }

    public SongDto(String titulo, String tonalidad, String letra) {
        this.titulo = titulo;
        this.tonalidad = tonalidad;
        this.letra = letra;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTonalidad() {
        return tonalidad;
    }

    public String getLetra() {
        return letra;
    }
}
