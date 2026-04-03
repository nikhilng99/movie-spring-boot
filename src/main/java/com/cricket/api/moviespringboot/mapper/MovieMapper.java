package com.cricket.api.moviespringboot.mapper;

import com.cricket.api.moviespringboot.dto.MovieDTO;
import com.cricket.api.moviespringboot.entity.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDTO toDTO(Movie movie);
    Movie toEntity(MovieDTO movieDTO);
    List<MovieDTO> toDTOList(List<Movie> movieList);
}
