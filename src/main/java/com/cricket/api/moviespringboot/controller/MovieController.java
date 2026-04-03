package com.cricket.api.moviespringboot.controller;

import com.cricket.api.moviespringboot.Service.MovieService;
import com.cricket.api.moviespringboot.entity.Movie;
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
    public Movie fetchMovieById(@PathVariable Integer id){
        return movieService.getMovieById(id);
    }

    @GetMapping
    public List<Movie> fetchAllMovies(){
        return movieService.getMovies();
    }

    @DeleteMapping("/{id}")
    public void removeMovie(@PathVariable Integer id){
        movieService.deleteMovieById(id);
    }

    @PostMapping()
    public Movie addNewMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovieById(@PathVariable Integer id, @RequestBody Movie movie){
        return movieService.updateMovie(id, movie);
    }
}
