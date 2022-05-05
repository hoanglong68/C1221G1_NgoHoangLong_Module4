package com.codegym.repository;

import com.codegym.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepositoryImpl implements ISongRepository {
    static List<Song> songList = new ArrayList<>();

    static {
        songList.add(new Song("hehe", "huu", "vang", "..."));
    }

    @Override
    public List<Song> getSongList() {
        return songList;
    }

    @Override
    public void save(Song song) {
        songList.add(song);
    }

}
