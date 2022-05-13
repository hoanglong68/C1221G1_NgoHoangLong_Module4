package com.codegym.service;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository iSongRepository;
    @Override
    public Page<Song> findAll(Pageable pageable) {
        return iSongRepository.findAll(pageable);
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song findById(String id) {
        return iSongRepository.findById(Integer.parseInt(id)).orElse(null);
    }
}
