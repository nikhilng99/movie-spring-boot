package com.cricket.api.moviespringboot.controller;

import com.cricket.api.moviespringboot.dto.MovieDTO;
import com.cricket.api.moviespringboot.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> fetchMovieById(@PathVariable Integer id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> fetchAllMovies(){
        return ResponseEntity.ok(movieService.getMovies());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeMovie(@PathVariable Integer id){
        movieService.deleteMovieById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<MovieDTO> addNewMovie(@RequestBody @Valid MovieDTO movie){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.addMovie(movie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> updateMovieById(@PathVariable Integer id, @RequestBody @Valid MovieDTO movie){
        MovieDTO updatedMovieDTO = movieService.updateMovie(id, movie);
        return ResponseEntity.ok(updatedMovieDTO);
    }
}
