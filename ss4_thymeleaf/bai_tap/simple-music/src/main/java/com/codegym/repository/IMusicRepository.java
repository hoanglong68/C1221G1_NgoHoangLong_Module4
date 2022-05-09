package com.codegym.repository;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> getAllSong();

    void createMusic(Music music);

    Music findSongById(String id);

    void save(Music music);

    void remove(Music songById);
}
