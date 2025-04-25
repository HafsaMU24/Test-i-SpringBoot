package com.example.Test.i.SpringBoot.service;

import com.example.Test.i.SpringBoot.model.Movies;
import com.example.Test.i.SpringBoot.repository.MoviesRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {

    private final MoviesRepository moviesRepo;

    public MoviesService(MoviesRepository moviesRepo) {
        this.moviesRepo = moviesRepo;
    }

    public List<Movies> getAllMovies(){
        return moviesRepo.findAll();
    }

    public Optional<Movies> getMoviesById(Long id) {
        return moviesRepo.findById(id);
    }

    public Movies createMovies(Movies movies) {
        if(moviesRepo.existsByTitle(movies.getTitle())) {
            throw new IllegalArgumentException("Movie already exists");
        }
        return moviesRepo.save(movies);
    }

    public void deleteMovie(Long id){
        moviesRepo.deleteById(id);
    }

}
