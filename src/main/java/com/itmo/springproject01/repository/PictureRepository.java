package com.itmo.springproject01.repository;

import com.itmo.springproject01.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
    // получить все картины по url жанра
    List<Picture> findAllByGenreUrl (String genreUrl);
}

// PictureRepository -> PictureService -> PictureController