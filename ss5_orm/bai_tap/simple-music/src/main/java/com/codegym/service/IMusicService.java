package com.codegym.service;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> getAllSong();

    void createMusic(Music music);

    Music findSongById(String id);

    void save(Music music);

    void remove(Music songById);
}
