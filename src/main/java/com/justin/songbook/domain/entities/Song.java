package com.justin.songbook.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "canciones")
public class Song {

    @Id
    private Long id;
    private String titulo;
    private String tonalidad;
    private String letra;

    public Song() {
    }

    public Song(Long id, String titulo, String tonalidad, String letra) {
        this.id = id;
        this.titulo = titulo;
        this.tonalidad = tonalidad;
        this.letra = letra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTonalidad() {
        return tonalidad;
    }

    public void setTonalidad(String tonalidad) {
        this.tonalidad = tonalidad;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
}
