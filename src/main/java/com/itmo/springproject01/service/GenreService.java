package com.itmo.springproject01.service;

import com.itmo.springproject01.entity.Genre;
import com.itmo.springproject01.exception.ShopException;
import com.itmo.springproject01.repository.GenreRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public String saveGenre(Genre genre) throws ShopException {
        if (genreRepository.existsById(genre.getUrl())) {
            throw new ShopException("Жанр с url '" + genre.getUrl() + "' уже существует");
        }
        genre.setCreatedAt(LocalDate.now());
        return genreRepository.save(genre).getUrl();
    }

    public Genre getGenreByUrl(String url) throws ShopException {
        return genreRepository.findById(url)
                .orElseThrow(() -> new ShopException("Жанр с url '" + url + "' не существует"));
    }

    public Iterable<Genre> getAllGenres(){
        return genreRepository.findAll();
    }

    public void update(Genre genre) throws ShopException {
        if (!genreRepository.existsById(genre.getUrl())) {
            throw new ShopException("Жанр с url '" + genre.getUrl() + "' не существует");
        }
        genreRepository.save(genre);
    }


    public void archive(String url, boolean addToArchive) throws ShopException {
        if (genreRepository.archive(url, addToArchive) == 0) {
            throw new ShopException("Жанр с url '" + url + "' не существует");
        }
    }
}
