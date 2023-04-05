package com.example.song.repository;

import com.example.song.model.Song;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ISongRepository extends PagingAndSortingRepository<Song,Integer> {
}
