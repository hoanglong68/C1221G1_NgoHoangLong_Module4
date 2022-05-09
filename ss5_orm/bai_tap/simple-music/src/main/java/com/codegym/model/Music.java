package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nameSong;
    String nameSinger;
    String typeSong;
    String pathSong;

    public Music() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getTypeSong() {
        return typeSong;
    }

    public void setTypeSong(String typeSong) {
        this.typeSong = typeSong;
    }

    public String getPathSong() {
        return pathSong;
    }

    public void setPathSong(String pathSong) {
        this.pathSong = pathSong;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", nameSong='" + nameSong + '\'' +
                ", nameSinger='" + nameSinger + '\'' +
                ", typeSong='" + typeSong + '\'' +
                ", pathSong='" + pathSong + '\'' +
                '}';
    }
}
