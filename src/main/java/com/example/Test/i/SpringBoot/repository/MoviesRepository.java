package com.example.Test.i.SpringBoot.repository;

import com.example.Test.i.SpringBoot.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MoviesRepository extends JpaRepository<Movies , Long> {

    boolean existsByTitle(String title);

}
