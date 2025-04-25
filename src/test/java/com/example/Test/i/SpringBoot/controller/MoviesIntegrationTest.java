package com.example.Test.i.SpringBoot.controller;

import com.example.Test.i.SpringBoot.model.Movies;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.*;


@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MoviesIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateAndGetMoviesByHttp(){
        // Arrange - skapa en film  med unik namn
        Movies movie = new Movies(null,"Lion of the Desert" , "Mustafa Akkad");

        //Act - skicka Post
        ResponseEntity<Movies> postResponse =
                restTemplate.postForEntity("http://localhost:" + port + "/movies", movie, Movies.class);

        assertEquals(HttpStatus.OK, postResponse.getStatusCode());

        // Act - hämta Filmen
        Long movieid = postResponse.getBody().getId();

        ResponseEntity<Movies> getResponse =
                restTemplate.getForEntity("http://localhost:" + port + "/movies/" + movieid, Movies.class);

       // Assert -kontrollera svar
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertEquals("Lion of the Desert", getResponse.getBody().getTitle());
        assertEquals("Mustafa Akkad", getResponse.getBody().getDirector());

    }

}