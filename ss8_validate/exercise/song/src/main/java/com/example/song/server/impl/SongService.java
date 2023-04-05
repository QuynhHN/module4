package com.example.song.server.impl;

import com.example.song.model.Song;
import com.example.song.repository.ISongRepository;
import com.example.song.server.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> listAll() {
        return (List<Song>) iSongRepository.findAll();
    }

    @Override
    public void create(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return iSongRepository.findById(id).get();
    }

    @Override
    public void update(Song song) {
        iSongRepository.save(song);
    }
}
