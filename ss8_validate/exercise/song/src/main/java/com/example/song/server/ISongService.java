package com.example.song.server;

import com.example.song.model.Song;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ISongService{
    List<Song> listAll();
    void create(Song song);
    Song findById(Integer id);
    void update(Song song);
}
