package com.codegym.model;

public class Song {
    String nameSong;
    String nameSinger;
    String typeSong;
    String path;

    public Song() {
    }

    public Song(String nameSong, String nameSinger, String typeSong, String path) {
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.typeSong = typeSong;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
