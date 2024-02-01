package com.itmo.springproject01.repository;

import com.itmo.springproject01.entity.Genre;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
// PagingAndSortingRepository;
// JpaRepository: CrudRepository + PagingAndSortingRepository;


public interface GenreRepository extends CrudRepository<Genre, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM tb_genres WHERE in_archive = false")
    List<Genre> findActive();

    @Query("SELECT g FROM Genre g WHERE g.inArchive = true")
    List<Genre> findNonActive();

    List<Genre> findAllByInArchiveFalse();

    @Query(nativeQuery = true, value = "SELECT * FROM tb_genres WHERE name = :name")
    Genre byName(@Param("name") String genreName);

    Genre findByName(String name);

    @Transactional
    @Modifying // @Modifying включает INSERT, UPDATE, DELETE запросы
    @Query("update Genre g set g.inArchive = :addToArchive where g.url = :url")
    int archive(String url, boolean addToArchive);
}