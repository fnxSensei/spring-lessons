package com.itmo.springproject01.controller;

import com.itmo.springproject01.entity.Genre;
import com.itmo.springproject01.exception.ShopException;
import com.itmo.springproject01.service.GenreService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@Validated // в классе будет использоваться валидация по аннотациям
@RestController
@RequestMapping("/genre") // обработка запросов, начинающихся с ./genre
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    // добавление нового жанра в БД
    // запрос приходит методом POST (@PostMapping)
    // в теле сообщения приходит json с описанием жанра (@RequestBody Genre genre)
    // объект должен быть валидными по всем описанным в нем правилам (@Valid Genre genre)
    @PostMapping
    public ResponseEntity<Void> addGenre(@RequestBody @Valid Genre genre) {
        // ResponseEntity для формирования ответа используется,
        // когда необходимо добавить заголовки или изменить статус ответа
        try {
            String genreUrl = genreService.saveGenre(genre);
            URI location = URI.create("http://127.0.0.1:8080/genre/" + genreUrl);

            // ответ - 201, в заголовках передаётся расположение нового жанра, тело - пустое
            return ResponseEntity.created(location).build();
        } catch (ShopException e) {
            // ответ - 409, в теле передается информация об источнике конфликта
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    // получение информации по url жанра
    // запрос приходит методом GET (@GetMapping)
    // параметры передаются, как часть строки запроса (/{genreUrl} -> @PathVariable String genreUrl)
    @GetMapping("/{genreUrl}")
    public Genre getGenreByURL(@PathVariable String genreUrl) {
        try {
            // ответ - 200, тело - содержит json строку с описанием найденного жанра
            return genreService.getGenreByUrl(genreUrl);
        } catch (ShopException e) {
            // ответ - 404, в теле передается информация об ошибке
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    // получение информации по всем жанрам
    // запрос приходит методом GET (@GetMapping)
    @GetMapping
    public Iterable<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    // обновление жанра
    // запрос приходит методом PUT (@PutMapping)
    // объект должен быть валидными по всем описанным в нем правилам (@Valid Genre genre)
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid Genre genre) {
        try {
            genreService.update(genre);
            // ответ - 204, тело - пустое
            return ResponseEntity.noContent().build();
        } catch (ShopException e) {
            // ответ - 404, в теле передается информация об ошибке
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    // обновление жанра
    // запрос приходит методом PATCH (@PatchMapping)
    // параметры передаются, как часть строки запроса
    //      (/{url}/archive/{value} -> @PathVariable String url и @PathVariable boolean value)
    @PatchMapping("/{url}/archive/{value}")
    public ResponseEntity<Void> archive(@Size(min = 3, max = 10) @PathVariable String url,
                                        @PathVariable boolean value) {
        try {
            genreService.archive(url, value);
            // ответ - 204, тело - пустое
            return ResponseEntity.noContent().build();
        } catch (ShopException e) {
            // ответ - 404, в теле передается информация об ошибке
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}