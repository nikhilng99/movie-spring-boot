package com.cricket.api.moviespringboot.Service;

import com.cricket.api.moviespringboot.entity.Movie;
import com.cricket.api.moviespringboot.exception.ResourceNotFoundException;
import com.cricket.api.moviespringboot.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovieById(Integer id){
        return movieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Movie not found with id: " + id));
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public void deleteMovieById(Integer id){
        Movie movie = movieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Movie not found with id: " + id));
        movieRepository.delete(movie);
    }

    public Movie updateMovie(Integer id, Movie movie){
        Movie oldMovie = movieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Movie not found with id: " + id));
        oldMovie.setName(movie.getName());
        oldMovie.setDuration(movie.getDuration());
        oldMovie.setRating(movie.getRating());

        return movieRepository.save(oldMovie);
    }

}
