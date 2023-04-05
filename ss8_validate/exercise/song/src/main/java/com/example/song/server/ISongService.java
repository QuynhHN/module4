package com.example.song.server;

import com.example.song.dto.SongDTO;
import com.example.song.model.Song;

import java.util.List;
public interface ISongService{
    List<Song> findAll();
    void create(SongDTO song);
    Song findById(int id);
    void update(SongDTO song);
}
