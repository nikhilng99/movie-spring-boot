package com.cricket.api.moviespringboot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class MovieDTO {
    private Integer id;

    @NotBlank(message = "Movie Name cannot be blank")
    private String name;

    @Min(value = 0, message = "Rating cannot be negative")
    private Double rating;

    @Min(value = 0, message = "Duration cannot be negative")
    private Integer duration;

    public MovieDTO() {
    }

    public MovieDTO(Integer id, String name, Double rating, Integer duration) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
