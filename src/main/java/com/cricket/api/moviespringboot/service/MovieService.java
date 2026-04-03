package com.cricket.api.moviespringboot.service;

import com.cricket.api.moviespringboot.dto.MovieDTO;
import com.cricket.api.moviespringboot.entity.Movie;
import com.cricket.api.moviespringboot.exception.ResourceNotFoundException;
import com.cricket.api.moviespringboot.mapper.MovieMapper;
import com.cricket.api.moviespringboot.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public MovieDTO getMovieById(Integer id){
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
        return movieMapper.toDTO(movie);
    }

    public List<MovieDTO> getMovies(){
        return movieMapper.toDTOList(movieRepository.findAll());
    }

    public MovieDTO addMovie(MovieDTO movieDTO){
        Movie addedMovie = movieMapper.toEntity(movieDTO);
        return movieMapper.toDTO(movieRepository.save(addedMovie));
    }

    public void deleteMovieById(Integer id){
        Movie movie = movieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Movie not found with id: " + id));
        movieRepository.delete(movie);
    }

    public MovieDTO updateMovie(Integer id, MovieDTO movieDTO){
        Movie oldMovie = movieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Movie not found with id: " + id));
        oldMovie.setName(movieDTO.getName());
        oldMovie.setDuration(movieDTO.getDuration());
        oldMovie.setRating(movieDTO.getRating());

        return movieMapper.toDTO(movieRepository.save(oldMovie));
    }

}
