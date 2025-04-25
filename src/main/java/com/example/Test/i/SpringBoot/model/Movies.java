package com.example.Test.i.SpringBoot.model;

import jakarta.persistence.*;


@Entity
@Table(name = "movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;

    private String director;

    public Movies(Long id,String title, String director) {
        this.id = id;
        this.title = title;
        this.director = director;
    }

    public Movies(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;

    }
}


