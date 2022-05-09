package com.codegym.service;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> getAllSong() {
        return iMusicRepository.getAllSong();
    }

    @Override
    public void createMusic(Music music) {
        iMusicRepository.createMusic(music);
    }

    @Override
    public Music findSongById(String id) {
        return iMusicRepository.findSongById(id);
    }

    @Override
    public void save(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public void remove(Music songById) {
        iMusicRepository.remove(songById);
    }
}
