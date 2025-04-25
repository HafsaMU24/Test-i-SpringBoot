package com.example.Test.i.SpringBoot.service;

import com.example.Test.i.SpringBoot.model.Movies;
import com.example.Test.i.SpringBoot.repository.MoviesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class MoviesServiceUnitTest {

    @Mock
    private MoviesRepository moviesRepo;

    @InjectMocks
    private MoviesService moviesService;

    @Test // Enheten: Unit Test - Testing service logic isolated DB
    void testGetAllMovies(){

        // Arrange
        Movies m1 = new Movies(1L,"Babylon A.D.","Mathieu Kassovitz");
        Movies m2 = new Movies(2L,"Annie Hall", "Woody Allen");
        when(moviesRepo.findAll()).thenReturn(Arrays.asList(m1,m2));

        //Act
        List<Movies> result = moviesService.getAllMovies();

        //Assert
        assertEquals(2,result.size());
        verify(moviesRepo).findAll();
   }

   @Test

    void testCreateMovieThrowsIfExists() {
 // Enhetstest: testar att undantag kastas om filmen redan finns

        //Arrange
        Movies movie = new Movies(null, "Inception", "Nolan");
        when(moviesRepo.existsByTitle("Inception")).thenReturn(true);

        //Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                moviesService.createMovies(movie));

        assertEquals("Movie already exists", exception.getMessage());
    }

}