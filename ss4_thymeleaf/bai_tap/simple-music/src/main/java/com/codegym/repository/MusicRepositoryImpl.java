package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepositoryImpl implements IMusicRepository {
    @Override
    public List<Music> getAllSong() {
        TypedQuery<Music> typedQuery = BaseRepository.entityManager.createQuery
                ("select m from Music m", Music.class);
        return typedQuery.getResultList();
    }

    @Override
    public void createMusic(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public Music findSongById(String id) {
        return BaseRepository.entityManager.find(Music.class, Integer.parseInt(id));
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void remove(Music songById) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(songById);
        entityTransaction.commit();
    }
}
