package com.example.Test.i.SpringBoot.controller;

import com.example.Test.i.SpringBoot.model.Movies;
import com.example.Test.i.SpringBoot.service.MoviesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private  final MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping
    public ResponseEntity<List<Movies>> getAllMovies() {
        return ResponseEntity.ok(moviesService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movies> getMoviesById(@PathVariable Long id) {
        Optional<Movies> movie = moviesService.getMoviesById(id);
        return movie.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Movies> createMovies(@RequestBody Movies movies){
        Movies savedMovie = moviesService.createMovies(movies);
        return  ResponseEntity.status(HttpStatus.OK).body(savedMovie);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMoviesById(@PathVariable Long id){
       if(moviesService.getMoviesById(id).isEmpty()) {
           return ResponseEntity.notFound().build();
       }
          moviesService.deleteMovie(id);
        return ResponseEntity.noContent().build();

    }
}
