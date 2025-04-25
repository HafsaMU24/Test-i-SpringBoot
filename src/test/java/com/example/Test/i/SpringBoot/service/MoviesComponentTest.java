package com.example.Test.i.SpringBoot.service;


import com.example.Test.i.SpringBoot.model.Movies;
import com.example.Test.i.SpringBoot.repository.MoviesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//@Transactional
public class MoviesComponentTest {

    @Autowired
    private MoviesRepository moviesRepo;


    @Autowired
    private MoviesService moviesService;

    @Test
    public void testCreateAndFetchMovies() {

        //Arrange
        Movies movies = new Movies(null, "Movie", "Movie1");

        // Act
        Movies savedMovies = moviesService.createMovies(movies);
        Movies fetchedMovies = moviesService.getMoviesById(savedMovies.getId()).orElse(null);

        //Assert
        assertNotNull(fetchedMovies);
        assertEquals("Movie", fetchedMovies.getTitle());

    }

}
